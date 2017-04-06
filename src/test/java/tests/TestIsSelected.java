package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestIsSelected extends SeleniumTestFixture {
    @Before
    public void setup() {
        driver.navigate().to("http://biologist-gladys-66140.bitballoon.com/");
    }

    @Test
    public void testCheckboxes() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.name("chb_cars"));
        System.out.println(checkbox.getAttribute("value"));

        List<WebElement> checkboxes = driver.findElements(By.name("chb_cars"));
        for (int i = 0; i < checkboxes.size(); i++) {
            System.out.println("Checkbox '" + i + "' value: " + checkboxes.get(i).getAttribute("value"));
        }

        System.out.println();

        //Thread.sleep(2000);
        //checkboxes.get(3).click();

        //Thread.sleep(2000);
        //checkboxes.get(1).click();

        //Thread.sleep(2000);
        //selectElement(checkboxes.get(3));

        Thread.sleep(3000);

        int index = rnd.nextInt(checkboxes.size());
        selectElement(checkboxes.get(index));
        Thread.sleep(2000);

        for (WebElement chb : checkboxes) {
            System.out.println(chb.getAttribute("value") + ": " + chb.isSelected());
        }

        for (int i = 0; i < checkboxes.size(); i++) {
            if (i != index) {
                Assert.assertEquals("Checkbox is selected!", false, checkboxes.get(i).isSelected());
            } else {
                Assert.assertEquals("Checkbox is not selected!", true, checkboxes.get(i).isSelected());
            }
        }

        //Assert.assertEquals("Checkbox is not selected!", true, checkboxes.get(1).isSelected());
        //Assert.assertEquals("Checkbox is not selected!", true, checkboxes.get(3).isSelected());

        Thread.sleep(3000);
    }

    @Test
    public void testRadioButtons() {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//form[@id='form_one']/input[@type='radio']"));
        for (WebElement rbt : radioButtons) {
            System.out.println(rbt.getAttribute("value"));
        }

        int index = rnd.nextInt(radioButtons.size());
        selectElement(radioButtons.get(index + 1));


        for (int i = 0; i < radioButtons.size(); i++) {
            System.out.println("RadioButton with value: '" + radioButtons.get(i).getAttribute("value") + " selected: " + radioButtons.get(i).isSelected());
            if (i != index) {
                Assert.assertEquals("RadioButton is selected!", false, radioButtons.get(i).isSelected());
            } else {
                Assert.assertEquals("RadioButton is not selected!", true, radioButtons.get(i).isSelected());
            }
        }
    }

    private void selectElement(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        } else {
            System.out.println("Element with value: ' " + element.getAttribute("value") + "' is already selected");
        }
    }
}
