package serviceObjects;

import io.restassured.response.Response;
import serviceObjects.dtos.AddCartRequest;
import serviceObjects.dtos.UpdateCartRequest;

import static io.restassured.RestAssured.given;

public class CartsService extends BaseService {
    public CartsService() {
        super("carts/");
    }

    public Response getCartById(int id) {
        return given().when().get(baseUrl + endpoint + id);
    }

    public Response getCartsByUser(int userId) {
        return given().when().get(baseUrl + endpoint + "user/" + userId);
    }

    public Response addCart(AddCartRequest body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(baseUrl + endpoint + "add");
    }

    public Response updateCart(int id, UpdateCartRequest body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(baseUrl + endpoint + id);
    }

    public Response deleteCart(int id) {
        return given().when().delete(baseUrl + endpoint + id);
    }
}
