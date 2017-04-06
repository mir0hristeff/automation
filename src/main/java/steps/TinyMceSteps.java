package steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import pageobject.theinternet.WysiwygEditorPage;

public class TinyMceSteps {
    @Then("^I should be on '(.*)' page$")
    public void i_should_be_on_WYSIWYG_Editor_page(String pageTitle) throws Throwable {
        switch (pageTitle) {
            case "WYSIWYG Editor":
                WysiwygEditorPage page = new WysiwygEditorPage(DriverFactory.getDriver());
                page.pageIsFullyLoaded();
        }
    }

    @When("^I type '(.*)' in the tiny mce editor$")
    public void i_type_some_text_in_the_tiny_mce_editor(String textToType) throws Throwable {
        WysiwygEditorPage page = new WysiwygEditorPage(DriverFactory.getDriver());
        page.typeInEditor(textToType);
    }

    @Then("^the tiny mce editor text should be '(.*)'$")
    public void the_tiny_mce_editor_text_should_be_some_text(String text) throws Throwable {
        WysiwygEditorPage page = new WysiwygEditorPage(DriverFactory.getDriver());
        Thread.sleep(3000);
        Assert.assertEquals("Text in Tiny MCE editor is different!", text, page.getEditorText());
    }
}
