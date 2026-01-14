package api;

import api.hooks.ApiTestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class UserTests extends ApiTestBase {
    @Test(description = "The endpoint returns a user by ID", groups = "api")
    public void getUserById_returnsUser() {
        Response r = services.users.getUserById(1);
        assertEquals(r.statusCode(), 200, r.asPrettyString());

        assertEquals(r.jsonPath().getInt("id"), 1);
        assertNotNull(r.jsonPath().getString("username"));
    }

    @Test(description = "The endpoint returns a list of users matching the search criteria", groups = "api")
    public void searchUsers_returnsList() {
        Response r = services.users.searchUsers("Emily");
        assertEquals(r.statusCode(), 200, r.asPrettyString());

        int total = r.jsonPath().getInt("total");
        assertTrue(total >= 1);
    }
}
