package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testWaits extends SeleniumTestFixture {
    @Test
    public void waitElementNotDisplayed() {
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.id("btn")).click();

        System.out.println("Wait started");
        long start = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        long end = System.currentTimeMillis() - start;
        System.out.println(new SimpleDateFormat("mm:ss:SSS").format(new Date(end)));
        System.out.println("Wait finished");

        driver.findElement(By.id("btn")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox")));
        System.out.println("Test finished");
    }
}
