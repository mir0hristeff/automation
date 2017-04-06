package pageobject.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.HelperMethods;

public class JavascriptAlertsPage {
    WebDriver driver;

    @FindBy(linkText = "Click for JS Alert")
    private WebElement jsAlertButton;

    @FindBy(linkText = "Click for JS Confirm")
    private WebElement jsConfirmButton;

    @FindBy(linkText = "Click for JS Prompt")
    private WebElement jsPromptButton;

    @FindBy(id = "result")
    private WebElement resultTextbox;

    public JavascriptAlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openJsAlert() {
        this.jsAlertButton.click();
    }

    public void openJsConfirm() {
        this.jsConfirmButton.click();
    }

    public void openJsPrompt() {
        this.jsPromptButton.click();
    }

    public String getJsAlertText() {
        return HelperMethods.getAlertText(this.driver);
    }

    public void acceptAlert() {
        HelperMethods.handleAlert(driver, true);
    }

    public void dismissAlert() {
        HelperMethods.handleAlert(driver, false);
    }

    public void setPromptText(String textToType) {
        HelperMethods.enterTextInJsPromtp(driver, textToType);
    }

    public String getResultText() {
        return this.resultTextbox.getText();
    }
}
