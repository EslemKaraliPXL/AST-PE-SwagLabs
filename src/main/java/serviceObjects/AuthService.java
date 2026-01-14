package serviceObjects;

import io.restassured.response.Response;
import serviceObjects.dtos.LoginRequest;

import static io.restassured.RestAssured.given;

public class AuthService extends BaseService {
    public AuthService() {
        super("auth/");
    }

    public Response loginResponse(String username, String password) {
        LoginRequest body = new LoginRequest(username, password);

        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(baseUrl + endpoint + "login");
    }

    public Response meResponse(String accessToken) {
        return given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(baseUrl + endpoint + "me");
    }
}
