package web.hooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import web.pageObjects.AllSwagLabsPages;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class WebTestBase {
    protected AllSwagLabsPages pages;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        pages = new AllSwagLabsPages();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        pages.closeBrowser();
    }
}
