package serviceObjects;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersService extends BaseService {
    public UsersService() {
        super("users/");
    }

    public Response getUserById(int id) {
        return given().when().get(baseUrl + endpoint + id);
    }

    public Response getAllUsers(int limit, int skip) {
        return given()
                .queryParam("limit", limit)
                .queryParam("skip", skip)
                .when()
                .get(baseUrl + endpoint);
    }

    public Response searchUsers(String q) {
        return given()
                .queryParam("q", q)
                .when()
                .get(baseUrl + endpoint + "search");
    }
}
