package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class handleBrowserWindows extends SeleniumTestFixture {
    @Before
    public void setup() {
        driver.navigate().to("http://toolsqa.com/automation-practice-switch-windows/");
    }

    @Test
    public void handleBrowserTabs() throws InterruptedException {
        System.out.println(driver.getTitle());
        /*String firstTab = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[.='New Browser Tab']")).click();
        Thread.sleep(3000);
        List<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
        for (String tab : allTabs) {
            System.out.println("Before remove: " + tab);
        }
        Thread.sleep(3000);
        allTabs.remove(firstTab);
        String newTab = allTabs.get(0);

        for (String tab : allTabs) {
            System.out.println("After remove: " + tab);
        }

        driver.switchTo().window(newTab);
        Thread.sleep(3000);
        System.out.println(driver.getTitle());

        driver.close();

        allTabs = new ArrayList<String>(driver.getWindowHandles());
        for (String tab : allTabs) {
            System.out.println("After close: " + tab);
        }

        driver.switchTo().window(firstTab);
        Thread.sleep(3000);

        System.out.println();
        System.out.println();

        driver.findElement(By.xpath("//button[.='New Message Window']")).click();
        List<String> allWindows = new ArrayList<String>(driver.getWindowHandles());
        for (String tab : allWindows) {
            System.out.println("Before remove: " + tab);
        }
        firstTab = driver.getWindowHandle();
        allWindows.remove(firstTab);
        newTab = allWindows.get(0);
        driver.switchTo().window(newTab);
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);

        driver.switchTo().window(firstTab);
        System.out.println(driver.getTitle());

        Thread.sleep(3000);*/

        driver.findElement(By.xpath("//button[.='New Browser Window']")).click();
        List<String> allWindows = new ArrayList<String>(driver.getWindowHandles());
        for (String tab : allWindows) {
            System.out.println("Windows - Before remove: " + tab);
        }
        String firstTab = driver.getWindowHandle();
        allWindows.remove(firstTab);
        String newTab = allWindows.get(0);
        driver.switchTo().window(newTab);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.close();

        Thread.sleep(3000);
    }
}
