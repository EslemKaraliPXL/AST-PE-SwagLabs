package web;

import org.testng.annotations.Test;
import web.hooks.WebTestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class WebProductsTest extends WebTestBase {
    @Test(description = "The user can see all available products after login", groups = "web")
    public void productsAreVisibleAfterLogin() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");

        assertThat(pages.products.isLoaded()).isTrue();
        assertThat(pages.products.getProductCount()).isGreaterThan(0);
    }

    @Test(description = "The user can sort products by name (A to Z) and (Z to A) after login", groups = "web")
    public void sortNameZtoA_Correctly() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");
        assertThat(pages.products.isLoaded()).isTrue();

        List<String> before = pages.products.getAllProductNames();

        pages.products.sortProducts("Name (Z to A)");
        List<String> after = pages.products.getAllProductNames();

        assertThat(after).isNotEqualTo(before);

        List<String> expected = new ArrayList<>(after);
        expected.sort(Collections.reverseOrder());

        assertThat(after).isEqualTo(expected);
    }

    @Test(description = "The user can open a random product details page from products list after login", groups = "web")
    public void openRandomProductDetails() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");
        assertThat(pages.products.isLoaded()).isTrue();

        String randomProduct = pages.products.openRandomProductDetails();

        assertThat(pages.details.isLoaded()).isTrue();
        assertThat(pages.details.getProductName()).isEqualTo(randomProduct);

        pages.details.backToProducts();
        assertThat(pages.products.isLoaded()).isTrue();
    }
}
