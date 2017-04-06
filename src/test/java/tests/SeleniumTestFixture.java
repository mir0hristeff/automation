package tests;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SeleniumTestFixture {
    static WebDriver driver;
    static Random rnd;
    static ObjectMap objectMap;

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void finished(Description description) {
            driver.quit();
        }

        @Override
        protected void failed(Throwable e, Description description) {
            try {
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

                String projectDir = System.getProperty("user.dir");
                String screenshotPath = projectDir + "/screenshots/" + description.getClassName() + "_" + description.getMethodName() + ".jpg";

                FileUtils.copyFile(screenshot, new File(screenshotPath));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            driver.quit();
        }
    };

    @BeforeClass
    public static void classSetup() {
        objectMap = new ObjectMap();
        //EdgeDriverManager.getInstance().setup();
        //FirefoxDriverManager.getInstance().setup();
        ChromeDriverManager.getInstance().setup();

        //driver = new EdgeDriver();
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        rnd = new Random();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /*@AfterClass
    public static void classTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
