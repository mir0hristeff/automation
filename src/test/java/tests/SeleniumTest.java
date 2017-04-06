package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        String projectDir = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", projectDir + "/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        driver.get("https://the-internet.herokuapp.com");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void secondTest() {
        driver.navigate().to("https://the-internet.herokuapp.com/challenging_dom");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
