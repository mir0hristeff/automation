package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise02 extends SeleniumTestFixture {
    List<Product> products;
    WebDriverWait wait;

    @Before
    public void testSetup() {
        driver.navigate().to("http://store.demoqa.com/");
        rnd = new Random();
        products = new ArrayList<Product>();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void checkoutTest() throws Exception {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='tests.Product Category']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(objectMap.getLocator("productCategory")));

        openProductCategoryByCategory(ProductCategory.IMACS);
        addProductToShoppingCart();
        continueShoppingOrGoToCheckout(Action.CONTINUE_SHOPPING);

        Thread.sleep(2000);

        openProductCategoryByCategory(ProductCategory.IPADS);
        addProductToShoppingCart();
        continueShoppingOrGoToCheckout(Action.CONTINUE_SHOPPING);

        Thread.sleep(2000);

        openProductCategoryByCategory(ProductCategory.ACCESSORIES);
        addProductToShoppingCart();
        continueShoppingOrGoToCheckout(Action.GO_TO_CHECKOUT);

        for (Product p : products) {
            System.out.println("Title: " + p.getTitle() + "; Price: " + p.getPrice());
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout_cart")));

        List<WebElement> itemsInCart = driver.findElements(By.xpath("//table/tbody/tr[starts-with(@class,'product_row')]"));
        for (WebElement itemInCart : itemsInCart) {
            String productTitle = itemInCart.findElement(By.xpath("//td[starts-with(@class,'wpsc_product_name')]")).getText();
            int productQuantity = Integer.valueOf(itemInCart.findElement(By.name("quantity")).getAttribute("value"));
            double productPrice = Double.valueOf(itemInCart.findElement(By.className("pricedisplay")).getText().replace("$", ""));
            double productTotalPrice = Double.valueOf(itemInCart.findElement(By.xpath("//td[starts-with(@class,'wpsc_product_price')]//span[@class='pricedisplay']")).getText().replace("$", ""));

            Product productToCheck = getProductByTitle(productTitle);
            Assert.assertEquals("Quantity is not the same!", productToCheck.getQuantity(), productQuantity);
            Assert.assertEquals("tests.Product price is not the same!", productToCheck.getPrice(), productPrice, 0.1);
            Assert.assertEquals("tests.Product total price is not the same!", productToCheck.getQuantity() * productToCheck.getPrice(), productTotalPrice, 0.1);
        }

        WebElement subTotalPriceElement = driver.findElement(By.xpath("//span[@class='yourtotal']//span[@class='pricedisplay']"));
        double subTotalPrice = Double.valueOf(subTotalPriceElement.getText().replace("$", ""));

        Assert.assertEquals("SubTotal price is not the same!", getSubTotalPrice(), subTotalPrice, 0.1);

        driver.findElement(By.xpath("//a[@class='step2']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wpsc_checkout_forms")));
    }

    private void continueShoppingOrGoToCheckout(Action action) {
        By buttonLocator = By.className("continue_shopping");
        if (action == Action.GO_TO_CHECKOUT) {
            buttonLocator = By.className("go_to_checkout");
        }

        wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        driver.findElement(buttonLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(buttonLocator));
    }

    private void addProductToShoppingCart() throws Exception {
        //By itemLocator = By.className("default_product_display");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(objectMap.getLocator("itemLocator")));
        List<WebElement> items = driver.findElements(objectMap.getLocator("itemLocator"));
        int itemIndex = rnd.nextInt(items.size());
        Product product = new Product();
        product.setTitle(items.get(itemIndex).findElement(By.className("wpsc_product_title")).getText());
        product.setPrice(Double.valueOf(items.get(itemIndex).findElement(By.className("currentprice")).getText().replace("$", "")));
        if (getProductByTitle(product.getTitle()) == null) {
            product.setQuantity();
            products.add(product);
        } else {
            getProductByTitle(product.getTitle()).setQuantity();
        }
        items.get(itemIndex).findElement(By.className("wpsc_buy_button")).click();
    }

    private void openProductCategoryByCategory(ProductCategory productCategory) {
        Actions actions = new Actions(driver);
        WebElement productCategoryMenuElement = driver.findElement(By.id("menu-item-33"));
        actions.moveToElement(productCategoryMenuElement);
        switch (productCategory) {
            case ACCESSORIES:
                actions.moveToElement(driver.findElement(By.xpath("//a[.='Accessories']")));
                break;
            case IMACS:
                actions.moveToElement(driver.findElement(By.xpath("//a[.='iMacs']")));
                break;
            case IPADS:
                actions.moveToElement(driver.findElement(By.xpath("//a[.='iPads']")));
                break;
            default:
                throw new NoSuchElementException(productCategory.toString() + " is not defined!");
        }

        actions.click();
        actions.build().perform();
    }

    public enum ProductCategory {
        ACCESSORIES, IMACS, IPADS
    }

    public enum Action {
        GO_TO_CHECKOUT, CONTINUE_SHOPPING
    }

    private Product getProductByTitle(String title) {
        Product product = null;
        for (Product p : products) {
            if (p.getTitle().equals(title)) {
                product = p;
                break;
            }
        }

        return product;
    }

    private double getSubTotalPrice() {
        double subTotal = 0;
        for (Product p : products) {
            subTotal += p.getQuantity() * p.getPrice();
        }

        return subTotal;
    }
}
