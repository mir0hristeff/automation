package pageobject.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Wait;

public class NestedFramesPage {
    WebDriver driver;

    @FindBy(xpath = "//frame[@src='/frame_top']")
    private WebElement topFrame;

    @FindBy(xpath = "//frame[@src='/frame_left']")
    private WebElement leftFrame;

    @FindBy(xpath = "//frame[@src='/frame_middle']")
    private WebElement middleFrame;

    @FindBy(xpath = "//frame[@src='/frame_right']")
    private WebElement rightFrame;

    @FindBy(xpath = "//frame[@src='/frame_bottom']")
    private WebElement bottomFrame;

    @FindBy(tagName = "body")
    private WebElement bodyElement;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void swithToLeftFrame() {
        Wait.forFrameToBeDisplayedAndSwitchToIt(driver, topFrame);
        Wait.forFrameToBeDisplayedAndSwitchToIt(driver, leftFrame);
    }

    public void swithToMiddleFrame() {
        Wait.forFrameToBeDisplayedAndSwitchToIt(driver, topFrame);
        Wait.forFrameToBeDisplayedAndSwitchToIt(driver, middleFrame);
    }

    public void swithToRightFrame() {
        Wait.forFrameToBeDisplayedAndSwitchToIt(driver, topFrame);
        Wait.forFrameToBeDisplayedAndSwitchToIt(driver, rightFrame);
    }

    public void swithToBottomFrame() {
        Wait.forFrameToBeDisplayedAndSwitchToIt(driver, bottomFrame);
    }

    public String getFrameText() {
        return bodyElement.getText();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
