package web;

import org.testng.annotations.Test;
import web.hooks.WebTestBase;

import static com.google.common.truth.Truth.assertThat;

public class WebLoginTest extends WebTestBase {
    @Test(description = "The user logs in with correct credentials and is redirected to the products page.", groups = "web")
    public void loginWithCorrectCredentials() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");

        assertThat(pages.getDriver().getCurrentUrl()).contains("inventory");
        assertThat(pages.products.isLoaded()).isTrue();
    }

    @Test(description = "The user logs in with incorrect credentials and an error gets displayed. The user stays on the login page.", groups = "web")
    public void loginWithIncorrectCredentials() {
        pages.login.navigateTo();
        pages.login.login("wrong_user", "wrong_password");

        assertThat(pages.login.isErrorDisplayed()).isTrue();
        assertThat(pages.getDriver().getCurrentUrl()).doesNotContain("inventory");
    }

    @Test(description = "A locked out user tries logging in and an error gets displayed. The user stays on the login page", groups = "web")
    public void loginWithLockedOutUser() {
        pages.login.navigateTo();
        pages.login.login("locked_out_user", "secret_sauce");

        assertThat(pages.login.isErrorDisplayed()).isTrue();
    }
}
