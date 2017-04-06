package PageObjectTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import TestFixture.BaseTest;
import entities.Product;
import enums.Action;
import enums.ProductCategory;
import helpers.HelperMethods;
import pageobject.demostore.CheckoutPage;
import pageobject.demostore.HomePage;
import pageobject.demostore.ProductPage;

public class FirstPageObjectTest extends BaseTest {
    List<Product> expectedProducts;

    @Before
    public void testSetup() {
        expectedProducts = new ArrayList<Product>();
        getDriver().navigate().to("http://store.demoqa.com/");
    }

    @Test
    public void addItemsInCart() throws Exception {
        HomePage homePage = new HomePage(getDriver());
        ProductPage productPage = new ProductPage(getDriver());

        homePage.openProductCategoryByCategory(ProductCategory.IMACS);
        productPage.addProductToShoppingCart(expectedProducts);
        productPage.continueShoppingOrGoToCheckout(Action.CONTINUE_SHOPPING);
        productPage.openProductCategoryByCategory(ProductCategory.IPADS);
        productPage.addProductToShoppingCart(expectedProducts);
        productPage.continueShoppingOrGoToCheckout(Action.GO_TO_CHECKOUT);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        List<Product> actualProducts = checkoutPage.getAllProductFromCart();
        Assert.assertEquals("Products count is not the same!", expectedProducts.size(), actualProducts.size());
        for (Product expected : expectedProducts) {
            Product actual = HelperMethods.getProductByTitle(actualProducts, expected.getTitle());
            Assert.assertEquals("Quantity is not the same!", expected.getQuantity(), actual.getQuantity());
            Assert.assertEquals("tests.Product price is not the same!", expected.getPrice(), actual.getPrice(), 0.1);
            Assert.assertEquals("tests.Product total price is not the same!", expected.getQuantity() * expected.getPrice(), actual.getTotalPrice(), 0.1);
        }

        Assert.assertEquals("Subtotal price is incorrect", checkoutPage.getSubtotalPrice(), HelperMethods.getSubTotalPrice(expectedProducts), 0.1);

        Thread.sleep(5000);

        //homePage.gotoMyAccount();
        //MyAccountPage myAccountPage = new MyAccountPage(driver);
        //myAccountPage.openRegistrationPage();
    }

    @Test
    public void openMyAccount() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.gotoMyAccount();

        Thread.sleep(5000);
    }
}
