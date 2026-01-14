package mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import testObjects.ILoginObject;

public class LoginScreen extends BaseScreen implements ILoginObject {
    private final By usernameTxt = By.xpath("//input[@name='username']");
    private final By passwordTxt = By.id("password");
    private final By loginBtn = By.xpath("//button");
    private final By errorLbl = By.id("flash");

    public LoginScreen(AppiumDriver driver) {
        super(driver, "/login");
    }

    public void fillInUsername(String username) {
        driver.findElement(usernameTxt).sendKeys(username);
    }

    public void fillInPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void login(String username, String password) {
        this.fillInUsername(username);
        this.fillInPassword(password);
        this.clickLogin();
    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public boolean isErrorDisplayed() {
        return false;
    }

    public String getErrormessage() {
        return driver.findElement(errorLbl).getText();
    }
}
