package api;

import api.hooks.ApiTestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import serviceObjects.dtos.AddProductRequest;
import serviceObjects.dtos.UpdateProductRequest;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ProductsTests extends ApiTestBase {
    @Test(description = "The endpoint returns a list of products", groups = "api")
    public void getProductsList_returnsItems() {
        Response r = services.products.getAllProducts(10, 0);
        assertEquals(r.statusCode(), 200, r.asPrettyString());

        int size = r.jsonPath().getList("products").size();
        assertTrue(size > 0);
    }

    @Test(description = "The endpoint returns a list of products that match the search term", groups = "api")
    public void searchProducts_returnsResults() {
        Response r = services.products.searchProducts("phone");
        assertEquals(r.statusCode(), 200, r.asPrettyString());

        assertTrue(r.jsonPath().getInt("total") >= 0);
    }

    @Test(description = "The endpoint returns a product by ID", groups = "api")
    public void getProduct_invalidId_negative() {
        Response r = services.products.getProductById(999999);
        assertTrue(r.statusCode() == 404 || r.statusCode() == 400);
    }

    @Test(description = "The endpoint returns an array of product categories", groups = "api")
    public void getProductCategories_returnsArray() {
        Response r = services.products.getCategories();
        assertEquals(r.statusCode(), 200, r.asPrettyString());

        assertTrue(r.asString().startsWith("["));
    }

//    @Test
//    public void product_CRUD_multi() {
//        // add
//        AddProductRequest addBody = new AddProductRequest(
//                "PXL Test Product",
//                "Created by automation",
//                123.45
//        );
//
//        Response addR = services.products.addProduct(addBody);
//        assertEquals(addR.statusCode(), 200, addR.asPrettyString());
//
//        int newId = addR.jsonPath().getInt("id");
//        assertTrue(newId > 0);
//
//        // get
//        Response getR = services.products.getProductById(newId);
//        assertEquals(getR.statusCode(), 200, getR.asPrettyString());
//
//        // update
//        UpdateProductRequest updBody = new UpdateProductRequest("PXL Updated Product", 222.22);
//        Response updR = services.products.updateProduct(newId, updBody);
//        assertEquals(updR.statusCode(), 200, updR.asPrettyString());
//
//        assertEquals(updR.jsonPath().getString("title"), "PXL Updated Product");
//
//        // delete
//        Response delR = services.products.deleteProduct(newId);
//        assertEquals(delR.statusCode(), 200, delR.asPrettyString());
//        assertTrue(delR.jsonPath().getBoolean("isDeleted"));
//    }
}
