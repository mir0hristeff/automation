package TestFixture;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

import enums.Browser;
import helpers.HelperMethods;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class BaseTest {
    static WebDriver driver;
    static Properties properties;
    static Browser browser;

    @BeforeClass
    public static void setup() throws Exception {
        properties = HelperMethods.loadProperties("testSettings.properties");
        browser = getBrowser(properties.getProperty("browser"));

        driver = getDriverByBrowser(browser);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static Browser getBrowser(String browser) throws Exception {
        switch (browser.toLowerCase()) {
            case "firefox": return Browser.FIREFOX;
            case "chrome": return Browser.CHROME;
            case "ie": return Browser.IE;
            case "edge": return Browser.EGDE;
            case "safari": return Browser.SAFARI;
            default:
                throw new Exception(browser + " is not defined!");
        }
    }

    private static WebDriver getDriverByBrowser(Browser browser) throws Exception {
        switch (browser) {
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver();
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                return new ChromeDriver();
            case EGDE:
                EdgeDriverManager.getInstance().setup();
                return new EdgeDriver();
            default:
                throw new Exception(browser.toString() + " is not defined!");
        }
    }
}
