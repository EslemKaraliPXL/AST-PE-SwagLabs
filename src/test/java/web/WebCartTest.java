package web;

import org.testng.annotations.Test;
import web.hooks.WebTestBase;

import static com.google.common.truth.Truth.assertThat;

public class WebCartTest extends WebTestBase {
    @Test(description = "The user can add a product to the cart after login", groups = "web")
    public void addOneProductToCart() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");

        assertThat(pages.products.isLoaded()).isTrue();

        pages.products.addRandomProductToCart();

        assertThat(pages.products.getCartItemCount()).isEqualTo(1);
    }

    @Test(description = "User removes a product from cart and cart becomes empty.", groups = "web")
    public void removeProductFromCart_cartBecomesEmpty() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");

        String productName = pages.products.openRandomProductDetails();
        pages.products.addProductToCart(productName);
        pages.products.openCart();

        assertThat(pages.cart.getItemCount()).isEqualTo(1);

        pages.cart.removeItemByName(productName);

        assertThat(pages.cart.getItemCount()).isEqualTo(0);
    }
}
