package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testObjects.ILoginObject;

public class LoginPage extends BasePage implements ILoginObject {
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver, "");
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);

        clickLogin();
    }

    public boolean isLoaded() {
        return isVisible(loginButton);
    }

    public boolean isErrorDisplayed() {
        return isVisible(errorMessage);
    }
}
