package serviceObjects;

import io.restassured.response.Response;
import serviceObjects.dtos.AddProductRequest;
import serviceObjects.dtos.UpdateProductRequest;

import static io.restassured.RestAssured.given;

public class ProductsService extends BaseService {
    public ProductsService() {
        super("products/");
    }

    public Response getAllProducts(int limit, int skip) {
        return given()
                .queryParam("limit", limit)
                .queryParam("skip", skip)
                .when()
                .get(baseUrl + endpoint);
    }

    public Response getProductById(int id) {
        return given().when().get(baseUrl + endpoint + id);
    }

    public Response searchProducts(String q) {
        return given()
                .queryParam("q", q)
                .when()
                .get(baseUrl + endpoint + "search");
    }

    public Response getCategories() {
        return given().when().get(baseUrl + endpoint + "categories");
    }

    public Response addProduct(AddProductRequest body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(baseUrl + endpoint + "add");
    }

    public Response updateProduct(int id, UpdateProductRequest body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(baseUrl + endpoint + id);
    }

    public Response deleteProduct(int id) {
        return given().when().delete(baseUrl + endpoint + id);
    }
}
