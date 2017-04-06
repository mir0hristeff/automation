package TheInternetTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import TestFixture.BaseTest;
import pageobject.theinternet.BasePage;
import pageobject.theinternet.JavascriptAlertsPage;
import pageobject.theinternet.MultipleWindowsPage;
import pageobject.theinternet.NestedFramesPage;
import pageobject.theinternet.SortableDataTablesPage;

public class MultipleWindowsTests extends BaseTest {
    @Before
    public void setupTest() {
        getDriver().navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void closeTab() {
        BasePage basePage = new BasePage(getDriver());
        basePage.openMultipleWindows();
        MultipleWindowsPage page = new MultipleWindowsPage(getDriver());
        page.openNewTab();
        page.switchToTab("new");
        System.out.println(page.getPageSource());
        page.closeTab();
        page.switchToTab("old");
        System.out.println(page.getPageSource());
    }

    @Test
    public void jsAlerts() {
        BasePage basePage = new BasePage(getDriver());
        basePage.openJavascriptAlerts();
        JavascriptAlertsPage page = new JavascriptAlertsPage(getDriver());
        page.openJsAlert();
        page.acceptAlert();
        Assert.assertEquals("Result is wrong!", "js alert", page.getResultText());

        page.openJsConfirm();
        page.acceptAlert();
        Assert.assertEquals("Result is wrong!", "accept", page.getResultText());

        page.openJsConfirm();
        page.dismissAlert();
        Assert.assertEquals("Result is wrong!", "dismiss", page.getResultText());

        page.openJsPrompt();
        page.setPromptText("Text");
        page.acceptAlert();
        Assert.assertEquals("Result is wrong!", "Text", page.getResultText());
    }

    @Test
    public void nestedFrames() {
        BasePage basePage = new BasePage(getDriver());
        basePage.openNestedFrames();
        NestedFramesPage page = new NestedFramesPage(getDriver());
        page.swithToLeftFrame();
        Assert.assertEquals("Text is wrong!", "LEFT", page.getFrameText());
        page.switchToDefaultContent();

        page.swithToMiddleFrame();
        Assert.assertEquals("Text is wrong!", "MIDDLE", page.getFrameText());
        page.switchToDefaultContent();

        page.swithToRightFrame();
        Assert.assertEquals("Text is wrong!", "RIGHT", page.getFrameText());
        page.switchToDefaultContent();

        page.swithToBottomFrame();
        Assert.assertEquals("Text is wrong!", "BOTTOM", page.getFrameText());
        page.switchToDefaultContent();
    }

    @Test
    public void sortableTable() throws Exception {
        BasePage basePage = new BasePage(getDriver());
        basePage.openSortableDataTables();
        SortableDataTablesPage page = new SortableDataTablesPage(getDriver());
        page.sortSecondTableBy(SortableDataTablesPage.SortTableBy.FIRST_NAME);
        page.assertTableSortedByFirstNameAscending();
    }
}
