package web.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
    public static WebDriver createBrowser(String browsername) {
        WebDriver driver;

        switch (browsername.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();
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
