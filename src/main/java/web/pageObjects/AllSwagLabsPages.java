package web.pageObjects;
import org.openqa.selenium.WebDriver;
import testObjects.IAllObjects;
import testObjects.ILoginObject;
import testObjects.IProductDetailsObject;
import testObjects.IProductsObject;
import web.browser.BrowserUtil;

public class AllSwagLabsPages implements IAllObjects {
    public LoginPage login;
    public ProductsPage products;
    public ProductDetailsPage details;
    public CartPage cart;
    public CheckoutCompletePage checkoutComplete;
    public CheckoutInfoPage checkoutInfo;
    public CheckoutOverviewPage checkoutOverview;

    private WebDriver driver;

    public AllSwagLabsPages(){
        driver = BrowserUtil.createBrowser();

        this.login = new LoginPage(driver);
        this.products = new ProductsPage(driver);
        this.details = new ProductDetailsPage(driver);
        this.cart = new CartPage(driver);
        this.checkoutComplete = new CheckoutCompletePage(driver);
        this.checkoutOverview = new CheckoutOverviewPage(driver);
        this.checkoutInfo = new CheckoutInfoPage(driver);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public ILoginObject login() {
        return login;
    }

    public IProductsObject products() {
        return products;
    }

    public IProductDetailsObject productDetails() {
        return details;
    }
}
