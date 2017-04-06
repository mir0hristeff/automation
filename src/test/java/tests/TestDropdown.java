package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestDropdown extends SeleniumTestFixture {
    @Before
    public void setup() {
        driver.navigate().to("http://biologist-gladys-66140.bitballoon.com/");
    }

    @Test
    public void testOne() throws InterruptedException {
        List<WebElement> options = driver.findElements(By.xpath("//select[@id='select_two']/option"));

        for (WebElement option : options) {
            System.out.println("Option - Value: " + option.getAttribute("value") + "; Text: " + option.getText());
        }

        //options.get(4).click();

        Select dropdown = new Select(driver.findElement(By.id("select_two")));
        System.out.println("IsMultiple: " + dropdown.isMultiple());
        dropdown.selectByIndex(2);
        Thread.sleep(5000);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("volvo");
        Thread.sleep(5000);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("McLaren");
        Thread.sleep(5000);
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }

    @Test
    public void testMultipleSelect() throws InterruptedException {
        WebElement multiSelectElement = driver.findElement(By.id("select_one"));
        Select multiSelect = new Select(multiSelectElement);
        List<WebElement> multiSelectOptions = multiSelect.getOptions();

        System.out.println(multiSelect.isMultiple());

        for (WebElement option : multiSelectOptions) {
            System.out.println("Option - Value: " + option.getAttribute("value") + "; Text: " + option.getText());
        }

        if (multiSelect.isMultiple()) {
            multiSelect.selectByIndex(2);
            Thread.sleep(1000);
            multiSelect.selectByValue("volvo");
            Thread.sleep(1000);
            multiSelect.selectByVisibleText("McLaren");
            Thread.sleep(1000);
            multiSelect.selectByIndex(8);
            multiSelect.selectByIndex(7);
            Thread.sleep(1000);
        }

        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        for (WebElement option : selectedOptions) {
            System.out.println("Selected Option - Value: " + option.getAttribute("value") + "; Text: " + option.getText());
        }

        WebElement firstSelectedOption = multiSelect.getFirstSelectedOption();
        System.out.println("First selected option - Value: " + firstSelectedOption.getAttribute("value") + "; Text: " + firstSelectedOption.getText());

        Thread.sleep(3000);

        if (multiSelect.isMultiple()) {
            multiSelect.deselectByIndex(2);
            Thread.sleep(5000);

            multiSelect.deselectByValue("volvo");
            Thread.sleep(5000);

            multiSelect.deselectByVisibleText("McLaren");
            Thread.sleep(5000);
        }

        System.out.println("Before deselect all: " + multiSelect.getAllSelectedOptions().size());

        if (multiSelect.isMultiple()) {
            multiSelect.deselectAll();
            Thread.sleep(5000);
        }

        System.out.println("After deselect all: " + multiSelect.getAllSelectedOptions().size());

        Thread.sleep(3000);
    }
}
