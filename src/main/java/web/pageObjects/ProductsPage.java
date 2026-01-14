package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testObjects.IProductsObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage implements IProductsObject {
    private final By pageTitle = By.className("title");
    private final By sortDropdown = By.className("product_sort_container");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By productList = By.className("inventory_list");
    private final By productItem = By.className("inventory_item");
    private final By productItemName = By.className("inventory_item_name");
    private final By addToCartButton = By.cssSelector("button.btn_inventory");

    public ProductsPage(WebDriver driver) {
        super(driver, "inventory.html");
    }

    private WebElement getRandomProduct() {
        waitForVisible(productItemName);
        List<WebElement> products = driver.findElements(productItemName);

        int index = new Random().nextInt(products.size());
        return products.get(index);
    }

    public boolean isLoaded() {
        return isVisible(pageTitle) && isVisible(productList);
    }

    public int getProductCount() {
        waitForVisible(productItem);
        return driver.findElements(productItem).size();
    }

    public List<String> getAllProductNames() {
        waitForVisible(productItemName);
        List<WebElement> products = driver.findElements(productItemName);

        List<String> names = new ArrayList<>();

        for (WebElement prods : products) {
            names.add(prods.getText().trim());
        }

        return names;
    }

    public void sortProducts(String sortOption) {
        click(sortDropdown);

        By option = By.xpath("//select[contains(@class,'product_sort_container')]/option[normalize-space()='" + sortOption + "']");
        click(option);
    }

    public String openRandomProductDetails() {
        WebElement randomProduct = getRandomProduct();
        String productName = randomProduct.getText().trim();
        randomProduct.click();

        return productName;
    }

    public void addRandomProductToCart() {
        WebElement product = getRandomProduct();
        WebElement addButton = product.findElement(By.xpath("./ancestor::div[@class='inventory_item']//button"));

        addButton.click();
    }

    public int getCartItemCount() {
        if (!isVisible(cartBadge)) return 0;

        return Integer.parseInt(getText(cartBadge).trim());
    }

    @Override
    public void openCart() {
        click(cartIcon);
    }

    public void addProductToCart(String productName) {
        waitForVisible(productItemName);

        By addBtn = By.xpath(
                "//div[@class='inventory_item' or @class='inventory_item_description' or @class='inventory_details_desc_container']" +
                        "[.//div[contains(@class,'inventory_item_name') and normalize-space()='" + productName + "']]" +
                        "//button[contains(@id,'add-to-cart') or normalize-space()='Add to cart']"
        );

        click(addBtn);
    }

    public void removeProductFromCart(String productName) {
        waitForVisible(productItemName);

        By removeBtn = By.xpath(
                "//div[@class='inventory_item' or @class='inventory_item_description' or @class='inventory_details_desc_container']" +
                        "[.//div[contains(@class,'inventory_item_name') and normalize-space()='" + productName + "']]" +
                        "//button[contains(@id,'remove') or normalize-space()='Remove']"
        );

        click(removeBtn);
    }
}
