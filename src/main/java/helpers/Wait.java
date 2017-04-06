package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;

public class Wait {
    private static Properties properties = HelperMethods.loadProperties("testSettings.properties");
    private static final int timeout = Integer.valueOf(properties.getProperty("timeout"));

    public static void forElementToBeDisplayedByLocator(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void forElementToBeDisplayed(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void forElementsToBeDisplayed(WebDriver driver, List<WebElement> elementList) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public static void forElementToNotBeDisplayedByLocator(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void forElementToNotBeDisplayed(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }

    public static void forFrameToBeDisplayedAndSwitchToIt(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }
}
