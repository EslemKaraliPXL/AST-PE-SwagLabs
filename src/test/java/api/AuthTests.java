package api;

import api.hooks.ApiTestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import serviceObjects.dtos.LoginResponse;
import serviceObjects.dtos.MeResponse;

import static org.testng.Assert.*;

public class AuthTests extends ApiTestBase {
    @Test(description = "Valid login credentials", groups = "api")
    public void login_valid() {
        Response r = services.auth.loginResponse("emilys", "emilyspass");
        assertEquals(r.statusCode(), 200, r.asPrettyString());

        LoginResponse login = r.as(LoginResponse.class);

        assertTrue(login.id > 0);
        assertNotNull(login.accessToken);
        assertFalse(login.accessToken.isBlank());
        assertNotNull(login.refreshToken);
        assertFalse(login.refreshToken.isBlank());
    }

    @Test(description = "Invalid login credentials", groups = "api")
    public void login_invalid_negative() {
        Response r = services.auth.loginResponse("emilys", "wrongpassword");

        assertNotEquals(r.statusCode(), 200, r.asPrettyString());
        assertNotNull(r.jsonPath().getString("message"));
    }

    @Test(description = "The user tries to access the /me endpoint without a valid token", groups = "api")
    public void me_withoutToken_unauthorized_negative() {
        Response meR = services.auth.meResponse("this-is-not-a-valid-token");
        assertTrue(meR.statusCode() == 401 || meR.statusCode() == 403, meR.asPrettyString());
    }
}
