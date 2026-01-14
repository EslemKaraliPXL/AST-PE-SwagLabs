package testObjects;

import java.util.List;

public interface IProductsObject extends IBaseObject {
    boolean isLoaded();

    int getProductCount();
    List<String> getAllProductNames();
    void sortProducts(String sortOption);

    String openRandomProductDetails();
    void addRandomProductToCart();

    int getCartItemCount();
    void openCart();
}
