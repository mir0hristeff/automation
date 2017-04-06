package steps;

import org.openqa.selenium.NoSuchElementException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import pageobject.theinternet.BasePage;

public class BaseSteps {
    @Given("^I am on base page$")
    public void i_am_on_base_page() throws Throwable {
        DriverFactory.getDriver().navigate().to("https://the-internet.herokuapp.com/");
    }

    @When("^I open '(.*)'$")
    public void i_open_WYSIWYG_Editor(String pageTitle) throws Throwable {
        BasePage page = new BasePage(DriverFactory.getDriver());
        switch (pageTitle) {
            case "WYSIWYG Editor":
                page.openWysiwygEditor();
                break;
            case "Nested Frames":
                page.openNestedFrames();
                break;
            default:
                throw new NoSuchElementException(pageTitle + " is not defined!");
        }
    }
}
