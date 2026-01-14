package web.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeOptions.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserUtil {
    public static WebDriver createBrowser(String browsername) {
        WebDriver driver;

        // sluit automatisch alle popups
        var options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--guest");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-save-password-bubble");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);

        options.setExperimentalOption("prefs", prefs);

        switch (browsername.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browsername);
        }

        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver createBrowser() {
        return createBrowser(BrowserConfig.getBrowserName());
    }
}
