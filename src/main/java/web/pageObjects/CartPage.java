package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By pageTitle = By.className("title");
    private final By cartList = By.className("cart_list");
    private final By cartItem = By.className("cart_item");
    private final By cartItemName = By.className("inventory_item_name");

    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver, "cart.html");
    }

    public boolean isLoaded() {
        return isVisible(pageTitle) && isVisible(cartList);
    }

    public int getItemCount() {
        waitForVisible(cartItem);
        List<WebElement> items = driver.findElements(cartItem);
        return items.size();
    }

    public void checkout() {
        click(checkoutButton);
    }

    public void continueShopping() {
        click(continueShoppingButton);
    }

    public boolean isItemInCart(String productName) {
        waitForVisible(cartItemName);
        List<WebElement> names = driver.findElements(cartItemName);

        for (WebElement n : names) {
            if (n.getText().trim().equalsIgnoreCase(productName.trim())) {
                return true;
            }
        }
        return false;
    }

    public void removeItemByName(String productName) {
        By removeButton = By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name' and normalize-space()='" + productName + "']" +
                "/ancestor::div[@class='cart_item']//button[normalize-space()='Remove']");

        click(removeButton);
    }
}
