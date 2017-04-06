package pageobject.demostore;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.ProductCategory;

public class HomePage {
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@href='http://store.demoqa.com/products-page/checkout/']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//a[@href='http://store.demoqa.com/products-page/your-account/']")
    private WebElement myAcountButton;

    @FindBy(id = "menu-item-33")
    private WebElement productCategoryMenuElement;

    @FindBy(xpath = "//a[.='Accessories']")
    private WebElement accessoriesSubMenu;

    @FindBy(xpath = "//a[.='iMacs']")
    private WebElement imacsSubMenu;

    @FindBy(how = How.XPATH, using = "//a[.='iPads']")
    private WebElement ipadsSubMenu;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(myAcountButton));
    }

    public void gotoCheckoutPage() {
        checkoutButton.click();
    }

    public void gotoMyAccount() {
        myAcountButton.click();
    }

    public void openProductCategoryByCategory(ProductCategory productCategory) {
        Actions actions = new Actions(driver);
        actions.moveToElement(productCategoryMenuElement);
        switch (productCategory) {
            case ACCESSORIES:
                actions.moveToElement(accessoriesSubMenu);
                break;
            case IMACS:
                actions.moveToElement(imacsSubMenu);
                break;
            case IPADS:
                actions.moveToElement(ipadsSubMenu);
                break;
            default:
                throw new NoSuchElementException(productCategory.toString() + " is not defined!");
        }

        actions.click();
        actions.build().perform();
    }
}
