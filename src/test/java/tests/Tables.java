package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tables extends SeleniumTestFixture {
    @Test
    public void getAllTextFromTable() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/challenging_dom");

        List<WebElement> tableHeaderRows = driver.findElements(By.xpath("//table/thead/tr"));
        for (WebElement headerRow : tableHeaderRows) {
            System.out.println(headerRow.getText());
            List<WebElement> columns = headerRow.findElements(By.tagName("th"));
            for (WebElement column : columns) {
                System.out.println("Column: " + column.getText());
            }
        }

        Thread.sleep(3000);
        System.out.println();

        List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
        for (WebElement row : tableRows) {
            System.out.println(row.getText());
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (WebElement column : columns) {
                System.out.println("Column: " + column.getText());
            }
        }

        Thread.sleep(3000);
    }
}
