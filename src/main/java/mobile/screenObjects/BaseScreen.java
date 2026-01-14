package mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testObjects.IBaseObject;
import web.pageObjects.SwagLabsConfig;

import java.time.Duration;

public class BaseScreen implements IBaseObject {
    protected AppiumDriver driver;
    protected String baseUrl = SwagLabsConfig.getBaseUrl();
    protected String endpoint;
    protected WebDriverWait wait;

    protected BaseScreen(AppiumDriver driver, String endpoint) {
        this.driver = driver;
        this.endpoint = endpoint;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigateTo() {
        this.driver.get(baseUrl + endpoint);
    }
}
