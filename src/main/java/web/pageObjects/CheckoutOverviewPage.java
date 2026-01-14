package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By pageTitle = By.className("title");
    private final By cartItem = By.className("cart_item");

    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");

    private final By itemTotal = By.className("summary_subtotal_label"); // "Item total: $xx.xx"
    private final By tax = By.className("summary_tax_label");            // "Tax: $x.xx"
    private final By total = By.className("summary_total_label");        // "Total: $xx.xx"

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver, "checkout-step-two.html");
    }

    public boolean isLoaded() {
        return isVisible(pageTitle) && isVisible(finishButton);
    }

    public int getItemCount() {
        waitForVisible(cartItem);
        return driver.findElements(cartItem).size();
    }

    public void finishCheckout() {
        click(finishButton);
    }

    public void cancelCheckout() {
        click(cancelButton);
    }

    public String getItemTotalText() {
        return getText(itemTotal).trim();
    }

    public String getTaxText() {
        return getText(tax).trim();
    }

    public String getTotalText() {
        return getText(total).trim();
    }
}
