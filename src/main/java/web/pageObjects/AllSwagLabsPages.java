package web.pageObjects;
import org.openqa.selenium.WebDriver;
import web.browser.BrowserUtil;

public class AllSwagLabsPages {
    public LoginPage login;
    private WebDriver driver;

    public AllSwagLabsPages(){
        driver = BrowserUtil.createBrowser();
        this.login = new LoginPage(driver);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
