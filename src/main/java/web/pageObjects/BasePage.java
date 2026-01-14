package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public BasePage() {
    }

    public void navigateTo() {
        driver.navigate().to(baseurl + endpoint);
    }

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isVisible(By locator) {
        try
        {
            return waitForVisible(locator).isDisplayed();
        } catch (TimeoutException e)
        {
            return false;
        }
    }

    protected String getText(By locator) {
        return waitForVisible(locator).getText();
    }
}
