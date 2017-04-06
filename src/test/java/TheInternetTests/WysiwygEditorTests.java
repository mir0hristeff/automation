package TheInternetTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import TestFixture.BaseTest;
import pageobject.theinternet.BasePage;
import pageobject.theinternet.WysiwygEditorPage;

public class WysiwygEditorTests extends BaseTest {
    @Before
    public void setupTest() {
        getDriver().navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void enterText() {
        BasePage basePage = new BasePage(getDriver());
        basePage.openWysiwygEditor();
        WysiwygEditorPage page = new WysiwygEditorPage(getDriver());
        String textToType = "Some new text";
        page.typeInEditor(textToType);
        Assert.assertEquals("Text is not the same!", textToType, page.getEditorText());
    }
}
