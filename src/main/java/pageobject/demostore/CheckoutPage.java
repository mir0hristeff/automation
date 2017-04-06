package pageobject.demostore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class CheckoutPage extends HomePage {
    @FindBy(xpath = "//span[@class='yourtotal']//span[@class='pricedisplay']")
    private WebElement subTotalPriceElement;

    @FindBy(xpath = "//a[@class='step2']")
    private WebElement contunieButton;

    @FindBy(xpath = "//table/tbody/tr[starts-with(@class,'product_row')]")
    List<WebElement> itemsInCart;

    private By productTiteLocator = By.xpath("//td[starts-with(@class,'wpsc_product_name')]");
    private By productTotalPriceLocator = By.xpath("//td[starts-with(@class,'wpsc_product_price')]//span[@class='pricedisplay']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public double getSubtotalPrice() {
        return Double.valueOf(this.subTotalPriceElement.getText().replace("$", ""));
    }

    public List<Product> getAllProductFromCart() {
        List<Product> productInCart = new ArrayList<Product>();
        for (WebElement itemInCart : itemsInCart) {
            Product product = new Product();
            product.setTitle(itemInCart.findElement(productTiteLocator).getText());
            product.setQuantity(Integer.valueOf(itemInCart.findElement(By.name("quantity")).getAttribute("value")));
            product.setPrice(Double.valueOf(itemInCart.findElement(By.className("pricedisplay")).getText().replace("$", "")));
            product.setTotalPrice(Double.valueOf(itemInCart.findElement(productTotalPriceLocator).getText().replace("$", "")));
            productInCart.add(product);
        }

        return productInCart;
    }

    public void updateItemQuantity(String title) {

    }

    public void gotoNextStep() {
        this.contunieButton.click();
    }
}
