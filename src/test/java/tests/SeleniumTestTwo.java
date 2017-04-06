package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTestTwo {
    WebDriver driver;

    @Before
    public void setup() {
        String projectDir = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", projectDir + "/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void openLink() {
        driver.navigate().to("https://the-internet.herokuapp.com/challenging_dom");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get("https://the-internet.herokuapp.com/challenging_dom");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com");
        WebElement linkText = driver.findElement(By.linkText("Form Authentication"));
        System.out.println("Selected: " + linkText.isSelected());
        System.out.println("Text: " + linkText.getText());
        System.out.println("TagName: " + linkText.getTagName());
        System.out.println("hrefAttribute: " + linkText.getAttribute("href"));
        System.out.println("Displayed: " + linkText.isDisplayed());
        System.out.println("Enabled: " + linkText.isEnabled());
        System.out.println("X: " + linkText.getLocation().getX());
        System.out.println("Y: " + linkText.getLocation().getY());
        System.out.println("getRect Width: " + linkText.getRect().getWidth());
        System.out.println("getRect Height: " + linkText.getRect().getHeight());
        System.out.println("getSize Width: " + linkText.getSize().getWidth());
        System.out.println("getSize Height: " + linkText.getSize().getHeight());
        System.out.println();

        WebElement partialLinkText = driver.findElement(By.partialLinkText("Authentication"));
        System.out.println("Selected: " + partialLinkText.isSelected());
        System.out.println("Text: " + partialLinkText.getText());
        System.out.println("TagName: " + partialLinkText.getTagName());
        System.out.println("hrefAttribute: " + partialLinkText.getAttribute("href"));
        System.out.println("Displayed: " + partialLinkText.isDisplayed());
        System.out.println("Enabled: " + partialLinkText.isEnabled());
        System.out.println("X: " + partialLinkText.getLocation().getX());
        System.out.println("Y: " + partialLinkText.getLocation().getY());
        System.out.println("getRect Width: " + partialLinkText.getRect().getWidth());
        System.out.println("getRect Height: " + partialLinkText.getRect().getHeight());
        System.out.println("getSize Width: " + partialLinkText.getSize().getWidth());
        System.out.println("getSize Height: " + partialLinkText.getSize().getHeight());
        System.out.println();

        WebElement linkTextXpath = driver.findElement(By.xpath("//a[@href='/login']"));
        System.out.println("Selected: " + linkTextXpath.isSelected());
        System.out.println("Text: " + linkTextXpath.getText());
        System.out.println("TagName: " + linkTextXpath.getTagName());
        System.out.println("hrefAttribute: " + linkTextXpath.getAttribute("href"));
        System.out.println("Displayed: " + linkTextXpath.isDisplayed());
        System.out.println("Enabled: " + linkTextXpath.isEnabled());
        System.out.println("X: " + linkTextXpath.getLocation().getX());
        System.out.println("Y: " + linkTextXpath.getLocation().getY());
        System.out.println("getRect Width: " + linkTextXpath.getRect().getWidth());
        System.out.println("getRect Height: " + linkTextXpath.getRect().getHeight());
        System.out.println("getSize Width: " + linkTextXpath.getSize().getWidth());
        System.out.println("getSize Height: " + linkTextXpath.getSize().getHeight());
        System.out.println();

        WebElement linkTextCssSelector = driver.findElement(By.cssSelector("a[href='/login']"));
        System.out.println("Selected: " + linkTextCssSelector.isSelected());
        System.out.println("Text: " + linkTextCssSelector.getText());
        System.out.println("TagName: " + linkTextCssSelector.getTagName());
        System.out.println("hrefAttribute: " + linkTextCssSelector.getAttribute("href"));
        System.out.println("Displayed: " + linkTextCssSelector.isDisplayed());
        System.out.println("Enabled: " + linkTextCssSelector.isEnabled());
        System.out.println("X: " + linkTextCssSelector.getLocation().getX());
        System.out.println("Y: " + linkTextCssSelector.getLocation().getY());
        System.out.println("getRect Width: " + linkTextCssSelector.getRect().getWidth());
        System.out.println("getRect Height: " + linkTextCssSelector.getRect().getHeight());
        System.out.println("getSize Width: " + linkTextCssSelector.getSize().getWidth());
        System.out.println("getSize Height: " + linkTextCssSelector.getSize().getHeight());
        System.out.println();

        Thread.sleep(3000);

        //linkText.click();
        //driver.navigate().refresh();

        Thread.sleep(2000);

        partialLinkText = driver.findElement(By.partialLinkText("Authentication"));
        partialLinkText.click();

        Thread.sleep(2000);

        WebElement usernameId = driver.findElement(By.id("username"));
        System.out.println("X: " + usernameId.getLocation().getX() + "; Y: " + usernameId.getLocation().getY());
        usernameId.sendKeys("id");

        Thread.sleep(2000);

        WebElement usernameName = driver.findElement(By.name("username"));
        System.out.println("X: " + usernameName.getLocation().getX() + "; Y: " + usernameName.getLocation().getY());
        usernameName.clear();
        Thread.sleep(1000);
        usernameName.sendKeys("Name");

        Thread.sleep(2000);

        WebElement passwordId = driver.findElement(By.id("password"));
        System.out.println("X: " + passwordId.getLocation().getX() + "; Y: " + passwordId.getLocation().getY());
        passwordId.sendKeys("id");

        Thread.sleep(2000);

        WebElement passwordName = driver.findElement(By.name("password"));
        System.out.println("X: " + passwordName.getLocation().getX() + "; Y: " + passwordName.getLocation().getY());
        passwordName.clear();
        Thread.sleep(1000);
        passwordName.sendKeys("Name");

        WebElement loginButton = driver.findElement(By.className("radius"));
        System.out.println("X: " + loginButton.getLocation().getX() + "; Y: " + loginButton.getLocation().getY());

        Assert.assertEquals("Username field is not displayed!", true, usernameId.isDisplayed());
        Assert.assertEquals("Password field is not displayed!", true, passwordId.isDisplayed());
        Assert.assertEquals("Login button is not displayed!", true, loginButton.isDisplayed());

        loginButton.click();

        Thread.sleep(1000);

        WebElement errorElement = driver.findElement(By.id("flash"));
        checkMessage(errorElement, "Error element is not displayed!", "Your username is invalid!\n×");
        checkMessage(By.id("flash"), "Error element is not displayed!", "Your username is invalid!\n×");
        checkMessage(PageElements.flashMessageLocator, "Error element is not displayed!", "Your username is invalid!\n×");

        usernameId = driver.findElement(By.id("username"));
        usernameId.clear();
        usernameId.sendKeys("tomsmith");
        passwordId = driver.findElement(By.id("password"));
        passwordId.clear();
        passwordId.sendKeys("SuperSecretPassword!");
        loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        Thread.sleep(1000);

        checkMessage("Successful login element is not displayed!", "You logged into a secure area!\n×");

        WebElement logoutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
        Assert.assertEquals("Logout button is not enabled!", true, logoutButton.isEnabled() && logoutButton.isDisplayed());

        logoutButton.click();

        Thread.sleep(1000);

        checkMessage("Not logged out", "You logged out of the secure area!\n×");

        Thread.sleep(3000);
    }

    private void checkMessage(String assertMessage, String expectedText) {
        WebElement messageLabel = driver.findElement(By.id("flash"));
        checkMessage(messageLabel, assertMessage, expectedText);
    }

    private void checkMessage(WebElement element, String assertMessage, String expectedText) {
        System.out.println(element.getText());
        Assert.assertEquals(assertMessage, true, element.isDisplayed() && element.isEnabled());
        Assert.assertEquals("Wrong text!", expectedText, element.getText());
    }

    private void checkMessage(By locator, String assertMessage, String expectedText) {
        WebElement messageLabel = driver.findElement(locator);
        checkMessage(messageLabel, assertMessage, expectedText);
    }
}
