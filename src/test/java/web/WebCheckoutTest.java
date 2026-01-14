package web;

import org.testng.annotations.Test;
import web.hooks.WebTestBase;

import static org.hamcrest.MatcherAssert.assertThat;

public class WebCheckoutTest extends WebTestBase {
//    @Test(description = "User cancels checkout in step one and returns to cart.", groups = "web")
//    public void checkout_cancelOnStepOne_returnsToCart() {
//        pages.login.navigateTo();
//        pages.login.login("standard_user", "secret_sauce");
//
//        pages.products.addRandomProductToCart();
//        pages.products.openCart();
//        pages.cart.checkout();
//
//        assertThat(pages.checkoutInfo.isLoaded();
//
//        pages.checkoutInfo.cancel();
//
//        assertThat(pages.cart.isLoaded()).isTrue();
//        assertThat(pages.getDriver().getCurrentUrl()).contains("cart");
//    }

//    @Test(description = "User completes checkout successfully and sees confirmation page.", groups = "web")
//    public void checkout_happyPath_completesSuccessfully() {
//        pages.login.navigateTo();
//        pages.login.login("standard_user", "secret_sauce");
//
//        // Add product
//        pages.products.openRandomProductDetails();
//        String productName = pages.details.getProductName();
//        pages.details.addToCart();
//        pages.details.openCart();
//
//        assertThat(pages.cart.isLoaded()).isTrue();
//        assertThat(pages.cart.isItemInCart(productName)).isTrue();
//
//        // info
//        pages.cart.checkout();
//        assertThat(pages.checkoutInfo.isLoaded()).isTrue();
//
//        pages.checkoutInfo.fillInformation("Eslem", "Test", "3500");
//        pages.checkoutInfo.continueCheckout();
//
//        // overview
//        assertThat(pages.checkoutOverview.isLoaded()).isTrue();
//        assertThat(pages.checkoutOverview.getItemCount()).isEqualTo(1);
//
//        assertThat(pages.checkoutOverview.getItemTotalText()).contains("Item total");
//        assertThat(pages.checkoutOverview.getTaxText()).contains("Tax");
//        assertThat(pages.checkoutOverview.getTotalText()).contains("Total");
//
//        pages.checkoutOverview.finishCheckout();
//
//        // Complete
//        assertThat(pages.checkoutComplete.isLoaded()).isTrue();
//        assertThat(pages.checkoutComplete.getSuccessMessage()).contains("Thank you");
//    }
}
