package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SeleniumActions extends SeleniumTestFixture{
    @Test
    public void hover() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        Thread.sleep(3000);
        Actions hoverAction = new Actions(driver);
        hoverAction
                .moveToElement(driver.findElement(By.xpath("//div[@class='figure']")))
                .click(driver.findElement(By.xpath("//div[@class='figcaption']/a")))
                .build()
                .perform();

        Thread.sleep(4000);

        String text = driver.findElement(By.xpath("//div[@class='figcaption']/h5")).getText();
        System.out.println(text);

        driver.findElement(By.xpath("//div[@class='figcaption']/a")).click();

        Thread.sleep(4000);
    }

    @Test
    public void testKeyDown() throws InterruptedException {
        driver.navigate().to("http://toolsqa.wpengine.com/automation-practice-form/");

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.not(ExpectedConditions.numberOfWindowsToBe(1)));

        Thread.sleep(4000);

        ((JavascriptExecutor) driver).executeScript("alert('JS executed by webdriver');");

        Thread.sleep(5000);

        List<WebElement> options = driver.findElements(By.xpath("//select[@id='selenium_commands']/option"));

        Thread.sleep(2000);

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL)
                .click(options.get(1))
                .click(options.get(3))
                .click(options.get(1))
                .build()
                .perform();

        Thread.sleep(5000);
    }

    @Test
    public void testDragAndDrop() throws InterruptedException {
        driver.navigate().to("http://jqueryui.com/resources/demos/droppable/default.html");

        Thread.sleep(3000);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        System.out.println(droppable.getText());
        Assert.assertEquals("Not equals", "Drop here", droppable.getText());

        Actions action = new Actions(driver);
        action.dragAndDrop(draggable, droppable);
        action.build().perform();

        System.out.println(droppable.getText());
        Assert.assertEquals("Drag and drop unsuccessful", "Dropped!", droppable.getText());

        Thread.sleep(5000);
    }
}
