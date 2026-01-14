package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {

    private final By pageTitle = By.className("title");

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");

    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");

    private final By errorContainer = By.cssSelector("h3[data-test='error']");

    public CheckoutInfoPage(WebDriver driver) {
        super(driver, "checkout-step-one.html");
    }

    public boolean isLoaded() {
        return isVisible(pageTitle) && isVisible(firstNameInput);
    }

    public void fillInformation(String firstName, String lastName, String postalCode) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
    }

    public void continueCheckout() {
        click(continueButton);
    }

    public void cancel() {
        click(cancelButton);
    }

    public boolean isErrorDisplayed() {
        return isVisible(errorContainer);
    }

    public String getErrorMessage() {
        if (!isVisible(errorContainer)) return "";
        return getText(errorContainer).trim();
    }
}
