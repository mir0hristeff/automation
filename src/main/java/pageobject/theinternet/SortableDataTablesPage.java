package pageobject.theinternet;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SortableDataTablesPage {
    WebDriver driver;

    @FindBy(id = "table1")
    private WebElement firstTable;

    @FindBy(id = "table2")
    private WebElement secondTable;

    public SortableDataTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortSecondTableBy(SortTableBy sortTableBy) throws Exception {
        String className;

        switch (sortTableBy) {
            case FIRST_NAME: className = "first_name"; break;
            case LAST_NAME: className = "last-name"; break;
            default: throw new Exception(sortTableBy + " is not defined!");
        }

        secondTable.findElement(By.xpath("//th//span[@class='" + className + "']")).click();
    }

    public List<String> getFirstNames() {
        List<WebElement> firstNameColumnElements = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        List<String> names = new ArrayList<>();

        for (WebElement row : firstNameColumnElements) {
            names.add(row.getText());
        }

        return names;
    }

    public void assertTableSortedByFirstNameAscending() {
        List<String> names = getFirstNames();
        for (int i = 0; i < names.size() - 1; i++) {
            Assert.assertTrue(names.get(i).compareTo(names.get(i + 1)) < 0);
        }
    }

    public enum SortTableBy {
        FIRST_NAME, LAST_NAME
    }
}
