package steps;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import cucumber.api.java.en.Then;
import driver.DriverFactory;
import pageobject.theinternet.NestedFramesPage;

public class NestedFramesSteps {
    @Then("^(.*) frame text should be '(.*)'$")
    public void frame_text_should_be(String framePosition, String expectedText) throws Throwable {
        NestedFramesPage page = new NestedFramesPage(DriverFactory.getDriver());
        switch (framePosition) {
            case "upper left":
                page.swithToLeftFrame(); break;
            case "upper middle":
                page.swithToMiddleFrame(); break;
            case "upper right":
                page.swithToRightFrame(); break;
            case "bottom":
                page.swithToBottomFrame(); break;
            default:
                throw new NoSuchElementException(framePosition + " is not defined!");

        }
        Assert.assertEquals("Text is wrong!", expectedText, page.getFrameText());
        page.switchToDefaultContent();
    }
}
