package tests;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Homework06 extends SeleniumTestFixture {
    @Before
    public void setup() {
        driver.navigate().to("http://toolsqa.wpengine.com/automation-practice-form/");
        driver.findElement(By.linkText("Partial Link Test")).click();
        WebElement firstNameTextbox = driver.findElement(By.name("firstname"));
        //firstNameTextbox.clear();
        //firstNameTextbox.sendKeys("First Name test");
        enterText(firstNameTextbox, "First Name test");
        WebElement lastNameTextbox = driver.findElement(By.name("lastname"));
        //lastNameTextbox.clear();
        //lastNameTextbox.sendKeys("Last Name test");
        enterText(lastNameTextbox, "Last Name test");

        //List<WebElement> sexRadiobuttons = driver.findElements(By.name("sex"));
        //int index = rnd.nextInt(sexRadiobuttons.size());
        //sexRadiobuttons.get(index).click();
        selectRandomButtonByLocator(By.name("sex"));

        //List<WebElement> experienceRadiobuttons = driver.findElements(By.name("exp"));
        //index = rnd.nextInt(experienceRadiobuttons.size());
        //experienceRadiobuttons.get(index).click();
        selectRandomButtonByLocator(By.name("exp"));

        selectRandomButtonByLocator(By.name("profession"));

        selectRandomButtonByLocator(By.name("tool"));
        selectRandomButtonByLocator(By.name("tool"), 0);

        Select continents = new Select(driver.findElement(By.id("continents")));
        int index = rnd.nextInt(continents.getOptions().size());
        continents.selectByIndex(index);
        continents.selectByVisibleText("Antartica");

        Select continentsMulti = new Select(driver.findElement(By.id("selenium_commands")));
        if (continentsMulti.isMultiple()) {
            continentsMulti.selectByIndex(0);
            continentsMulti.selectByIndex(4);
            continentsMulti.selectByVisibleText("Navigation Commands");
            continentsMulti.selectByVisibleText("Wait Commands");
        }

        Assert.assertEquals("Element not selected!", true, continentsMulti.getOptions().get(0).isSelected());

        //for (WebElement element : continentsMulti.getOptions()) {

        //}

        if (continentsMulti.isMultiple()) {
            continentsMulti.deselectByIndex(0);
            continentsMulti.deselectByVisibleText("Wait Commands");
        }

        Assert.assertEquals("Element not selected!", false, continentsMulti.getOptions().get(0).isSelected());

        continentsMulti.deselectAll();

        Assert.assertEquals("At least one element is selected!", true, continentsMulti.getAllSelectedOptions().size() == 0);

        driver.findElement(By.id("submit")).click();
    }

    private void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    private void selectRandomButtonByLocator(By locator) {
        List<WebElement> radiobuttons = driver.findElements(locator);
        int index = rnd.nextInt(radiobuttons.size());
        if (!radiobuttons.get(index).isSelected()) {
            radiobuttons.get(index).click();
        }
    }

    private void selectRandomButtonByLocator(By locator, Integer index) {
        List<WebElement> radiobuttons = driver.findElements(locator);
        if (!radiobuttons.get(index).isSelected()) {
            radiobuttons.get(index).click();
        }
    }
}
