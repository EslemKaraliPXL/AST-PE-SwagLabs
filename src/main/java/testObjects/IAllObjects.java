package testObjects;

public interface IAllObjects {
    ILoginObject login();
    IProductsObject products();
    IProductDetailsObject productDetails();

    void closeBrowser();
}
