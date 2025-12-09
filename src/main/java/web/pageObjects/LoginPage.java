package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver, "login");
    }

    public void enterUsername(String username) {
        WebElement usernameElem = driver.findElement(usernameField);
        usernameElem.sendKeys(username);
    }

    public void enterPassword(String password) {WebElement passwordElem = driver.findElement(passwordField);
        passwordElem.clear();
        passwordElem.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
