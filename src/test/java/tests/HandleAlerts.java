package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class HandleAlerts extends SeleniumTestFixture {
    @Before
    public void setup() {
        driver.navigate().to("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
    }

    @Test
    public void handleSimpleAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[.='Simple Alert']")).click();
        Alert simpleAlert;
        /*Alert simpleAlert = driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        Thread.sleep(3000);
        Assert.assertEquals("Wrong alert", true, getAlertText().equals("A simple Alert"));
        simpleAlert.accept();
        Thread.sleep(3000); */
        handleAlertAndAssertItsText(true, "A simple Alert");

        driver.findElement(By.xpath("//button[.='Confirm Pop up']")).click();
        simpleAlert = driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        Thread.sleep(3000);
        simpleAlert.dismiss();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[.='Confirm Pop up']")).click();
        simpleAlert = driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        Thread.sleep(3000);
        simpleAlert.accept();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[.='Prompt Pop up']")).click();
        simpleAlert =  driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        simpleAlert.sendKeys("Some text in an alert");
        Thread.sleep(5000);
        simpleAlert.accept();
        Thread.sleep(3000);
    }

    private void handleAlert(Boolean accept) {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    private void handleAlertAndAssertItsText(Boolean accept, String expectedText) {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("Wrong alert", true, getAlertText().equals(expectedText));
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    private String getAlertText() {
        return driver.switchTo().alert().getText();

    }

    private void handleAlert(Boolean accept, String textToSend) {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys(textToSend);
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }
}
