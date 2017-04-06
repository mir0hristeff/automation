package pageobject.demostore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import entities.Product;
import enums.Action;
import helpers.HelperMethods;
import helpers.Wait;

public class ProductPage extends HomePage {
    Random rnd;

    @FindBy(className = "default_product_display")
    private List<WebElement> items;

    public ProductPage(WebDriver driver) {
        super(driver);
        rnd = new Random();
    }

    public void addProductToShoppingCart(List<Product> products) throws Exception {
        Wait.forElementsToBeDisplayed(driver, items);

        int itemIndex = rnd.nextInt(items.size());
        Product product = new Product();
        product.setTitle(items.get(itemIndex).findElement(By.className("wpsc_product_title")).getText());
        product.setPrice(Double.valueOf(items.get(itemIndex).findElement(By.className("currentprice")).getText().replace("$", "")));
        if (HelperMethods.getProductByTitle(products, product.getTitle()) == null) {
        product.setQuantity();
        products.add(product);
    } else {
        HelperMethods.getProductByTitle(products, product.getTitle()).setQuantity();
    }
        items.get(itemIndex).findElement(By.className("wpsc_buy_button")).click();
    }

    public void continueShoppingOrGoToCheckout(Action action) {
        By buttonLocator = By.className("continue_shopping");
        if (action == Action.GO_TO_CHECKOUT) {
            buttonLocator = By.className("go_to_checkout");
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        driver.findElement(buttonLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(buttonLocator));
    }


}
