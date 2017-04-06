package pageobject.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/tinymce']")
    private WebElement wysiwygEditorButton;

    @FindBy(xpath = "//a[@href='/windows']")
    private WebElement multipleWindowsButton;

    @FindBy(xpath = "//a[@href='/javascript_alerts']")
    private WebElement javasctiptAlertsButton;

    @FindBy(xpath = "//a[@href='/nested_frames']")
    private WebElement nestedFramesButton;

    @FindBy(xpath = "//a[@href='/tables']")
    private WebElement sortableDataTablesButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openWysiwygEditor() {
        wysiwygEditorButton.click();
    }

    public void openMultipleWindows() {
        multipleWindowsButton.click();
    }

    public void openJavascriptAlerts() {
        javasctiptAlertsButton.click();
    }

    public void openNestedFrames() {
        nestedFramesButton.click();
    }

    public void openSortableDataTables() {
        sortableDataTablesButton.click();
    }
}
