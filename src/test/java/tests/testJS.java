package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class testJS extends SeleniumTestFixture {
    @Test
    public void jsTestScrollToView() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/large");

        Thread.sleep(2000);

        WebElement tableElement = driver.findElement(By.id("large-table"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tableElement);

        Thread.sleep(5000);
    }

    @Test
    public void scrollToCoordinates() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/large");

        Thread.sleep(2000);

        WebElement tableElement = driver.findElement(By.id("large-table"));
        int x = tableElement.getLocation().getX() - 50;
        int y = tableElement.getLocation().getY() - 50;
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + x + "," + y + ");");

        Assert.assertEquals("Should be true", true, false);

        Thread.sleep(5000);
    }

    private void runJS(String script) {
        ((JavascriptExecutor) driver).executeScript(script);
    }

    private void runJS(String script, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(script, element);
    }
}
