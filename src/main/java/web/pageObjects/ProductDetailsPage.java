package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testObjects.IProductDetailsObject;

public class ProductDetailsPage extends BasePage implements IProductDetailsObject {
    private final By pageTitle = By.className("title");
    private final By productName = By.className("inventory_details_name");
    private final By productDescription = By.className("inventory_details_desc");
    private final By addToCartButton = By.cssSelector("button.btn_inventory");
    private final By backToProductsButton = By.id("back-to-products");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By cartBadge = By.className("shopping_cart_badge");

    public ProductDetailsPage(WebDriver driver) {
        super(driver, "inventory_item.html");
    }

    public boolean isLoaded() {
        return isVisible(productName) && isVisible(backToProductsButton);
    }

    public String getProductName() {
        return getText(productName).trim();
    }

    public void backToProducts() {
        click(backToProductsButton);
    }

    public void addToCart() {
        click(addToCartButton);
    }

    public void removeFromCart() {
        click(addToCartButton);
    }

    public int getCartItemCount() {
        if (!isVisible(cartBadge)) return 0;
        return Integer.parseInt(getText(cartBadge).trim());
    }

    public void openCart() {
        click(cartIcon);
    }
}
