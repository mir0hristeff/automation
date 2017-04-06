package pageobject.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultipleWindowsPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/windows/new']")
    WebElement newTabButton;

    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openNewTab() {
        newTabButton.click();
    }

    public void switchToTab(String tab) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String tabTitle = tabs.get(0);
        if (tab.equals("new")) {
            tabTitle = tabs.get(1);
        }

        driver.switchTo().window(tabTitle);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void closeTab() {
        driver.close();
    }
}
