package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class handleIFrames extends SeleniumTestFixture {
    @Before
    public void setup() {
        driver.navigate().to("https://www.tinymce.com/docs/demo/classic/");
    }

    @Test
    public void testIFrame() throws InterruptedException {
        Thread.sleep(10000);

        driver.switchTo().frame("cp_embed_YybwmL");
        driver.switchTo().frame("result-iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement tinyMceEditor = driver.findElement(By.id("tinymce"));
        System.out.println(tinyMceEditor.getText());

        Thread.sleep(3000);

        tinyMceEditor.clear();
        Thread.sleep(3000);
        tinyMceEditor.sendKeys("Typing text in TinyMCE");

        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[@href='/docs/demo/format-html5/']")).click();

        Thread.sleep(10000);
    }
}
