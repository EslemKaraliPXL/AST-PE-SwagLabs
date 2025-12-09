package web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriverWait wait;
    protected WebDriver driver;
    public String baseurl = SwagLabsConfig.getBaseUrl();
    public String endpoint;

    public BasePage(WebDriver driver, String endpoint) {
        this.endpoint = endpoint;
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigateTo() {
        driver.navigate().to(baseurl + endpoint);
    }
}
