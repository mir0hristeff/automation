package pageobject.demostore;

import com.gargoylesoftware.htmlunit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;

    @FindBy(how = How.ID, using = "log")
    private WebElement usernameTextbox;

    @FindBy(id = "pwd")
    private WebElement passwordTextbox;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='http://store.demoqa.com/tools-qa/?action=register']")
    private WebElement registerLink;

    @FindBy(xpath = "//a[@href='http://store.demoqa.com/tools-qa/']")
    private WebElement loginLink;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        this.usernameTextbox.clear();
        this.usernameTextbox.sendKeys(username);

        this.passwordTextbox.clear();
        this.passwordTextbox.sendKeys(password);

        this.loginButton.click();
    }

    public void openRegistrationPage() {
        this.registerLink.click();
    }
}
