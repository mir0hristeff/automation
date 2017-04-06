package driver;

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

public class DriverFactory {
    private static WebDriver driver;
    private static Properties properties;
    private static Browser browser;

    private static void initDriver() throws Exception {
        properties = HelperMethods.loadProperties("testSettings.properties");
        browser = getBrowser(properties.getProperty("browser"));
        driver = getDriverByBrowser(browser);
    }

    public static WebDriver getDriver() throws Exception {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
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
