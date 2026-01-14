package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By pageTitle = By.className("title");
    private final By completeHeader = By.className("complete-header"); // "Thank you for your order!"
    private final By backHomeButton = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver, "checkout-complete.html");
    }

    public boolean isLoaded() {
        return isVisible(pageTitle) && isVisible(completeHeader);
    }

    public String getSuccessMessage() {
        return getText(completeHeader).trim();
    }

    public void backHome() {
        click(backHomeButton);
    }
}
