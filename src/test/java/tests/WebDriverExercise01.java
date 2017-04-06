package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WebDriverExercise01 extends SeleniumTestFixture {

    @Before
    public void testSetup() {
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void typeInTinyMCE() {
        By locator = By.xpath("//a[@href='/tinymce']");
        waitForElementToBeVisibleByLocator(locator);
        driver.findElement(locator).click();

        waitForElementToBeVisibleByLocator(By.id("mce_0_ifr"));
        driver.switchTo().frame("mce_0_ifr");

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Some random text typed in TinyMCE");
        driver.switchTo().defaultContent();
    }

    @Test
    public void testNewTab() {
        By locator = By.xpath("//a[@href='/windows']");
        waitForElementToBeVisibleByLocator(locator);
        driver.findElement(locator).click();

        By clickHereButtonLocator = By.xpath("//a[@href='/windows/new']");
        waitForElementToBeVisibleByLocator(clickHereButtonLocator);;
        driver.findElement(clickHereButtonLocator).click();

        String currentTab = driver.getWindowHandle();
        List<String> allTOpenedTabs = new ArrayList<String>(driver.getWindowHandles());
        allTOpenedTabs.remove(currentTab);
        driver.switchTo().window(allTOpenedTabs.get(0));
        System.out.println("New tab: " + driver.getPageSource());
        driver.close();

        driver.switchTo().window(currentTab);
        System.out.println("First tab: " + driver.getPageSource());
    }

    @Test
    public void testJsAlerts() {
        By jsAlertsPageLocator = By.xpath("//a[@href='/javascript_alerts']");
        clickOnElementLocatedBy(jsAlertsPageLocator);

        By jsAlertButtonLocator = By.xpath("//button[@onclick='jsAlert()']");
        clickOnElementLocatedBy(jsAlertButtonLocator);

        Alert jsAlert = driver.switchTo().alert();
        System.out.println(jsAlert.getText());
        jsAlert.accept();

        assertResultText("You successfuly clicked an alert");

        By jsConfirmButtonLocator = By.xpath("//button[@onclick='jsConfirm()']");
        clickOnElementLocatedBy(jsConfirmButtonLocator);

        Alert jsConfirm = driver.switchTo().alert();
        System.out.println(jsConfirm.getText());
        jsConfirm.accept();

        assertResultText("You clicked: Ok");

        clickOnElementLocatedBy(jsConfirmButtonLocator);

        jsConfirm = driver.switchTo().alert();
        System.out.println(jsConfirm.getText());
        jsConfirm.dismiss();

        assertResultText("You clicked: Cancel");

        By jsPromptButtonLocator = By.xpath("//button[@onclick='jsPrompt()']");
        clickOnElementLocatedBy(jsPromptButtonLocator);;

        Alert jsPrompt = driver.switchTo().alert();
        jsPrompt.sendKeys("Some random text in a js alert");
        System.out.println(jsPrompt.getText());
        jsPrompt.accept();

        assertResultText("You entered: Some random text in a js alert");
    }

    @Test
    public void nestedFrames() {
        By nestedFramesLinkLocator = By.xpath("//a[@href='/nested_frames']");
        clickOnElementLocatedBy(nestedFramesLinkLocator);

        //waitForElementToBeVisibleByLocator(By.name("frame-top"));
        //driver.switchTo().frame("frame-top");
        waitForFrameAndSwitchToIt("frame-top");

        //waitForElementToBeVisibleByLocator(By.name("frame-left"));
        //driver.switchTo().frame("frame-left");
        waitForFrameAndSwitchToIt("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();

        //waitForElementToBeVisibleByLocator(By.name("frame-middle"));
        //driver.switchTo().frame("frame-middle");
        waitForFrameAndSwitchToIt("frame-middle");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();

        //driver.switchTo().frame("frame-top");
        waitForFrameAndSwitchToIt("frame-top");
        //waitForElementToBeVisibleByLocator(By.name("frame-right"));
        //driver.switchTo().frame("frame-right");
        waitForFrameAndSwitchToIt("frame-right");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();

        //driver.switchTo().frame("frame-bottom");
        waitForFrameAndSwitchToIt("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }

    @Test
    public void sortableTable() {
        By sortableDataTableLinkLocator = By.xpath("//a[@href='/tables']");
        clickOnElementLocatedBy(sortableDataTableLinkLocator);

        By tableSecondColumnHeaderLocator = By.xpath("//table[@id='table2']//tr//th[2]");
        waitForElementToBeVisibleByLocator(tableSecondColumnHeaderLocator);
        //driver.findElement(tableSecondColumnHeaderLocator).click();

        List<WebElement> firstNameColumn = driver.findElements(By.xpath("//table[@id='table2']//tr//td[2]"));
        for (int i = 0; i < firstNameColumn.size() - 1; i++) {
            String one = firstNameColumn.get(i).getText();
            String two = firstNameColumn.get(i + 1).getText();
            String message = one + " is before " + two;
            Assert.assertEquals(message, true, one.compareTo(two) < 0);
        }
    }

    private void assertResultText(String expectedText) {
        String resultConfirm = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("Result is wrong", expectedText, resultConfirm);
    }

    private void clickOnElementLocatedBy(By locator) {
        waitForElementToBeVisibleByLocator(locator);
        driver.findElement(locator).click();
    }

    private void waitForElementToBeVisibleByLocator(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForFrameAndSwitchToIt(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
}
