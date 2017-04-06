package pageobject.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Wait;

public class WysiwygEditorPage {
    WebDriver driver;

    @FindBy(id = "mce_0_ifr")
    private WebElement iframeElement;

    @FindBy(id = "tinymce")
    private WebElement bodyElement;

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeInEditor(String textToType) {
        Wait.forFrameToBeDisplayedAndSwitchToIt(this.driver, this.iframeElement);
        this.bodyElement.clear();
        this.bodyElement.sendKeys(textToType);
        driver.switchTo().defaultContent();
    }

    public String getEditorText() {
        Wait.forFrameToBeDisplayedAndSwitchToIt(this.driver, this.iframeElement);
        String text = this.bodyElement.getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public void pageIsFullyLoaded() {
        Wait.forElementToBeDisplayed(driver, iframeElement);
    }
}
