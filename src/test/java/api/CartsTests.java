package api;

import api.hooks.ApiTestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import serviceObjects.dtos.AddCartRequest;
import serviceObjects.dtos.CartProduct;
import serviceObjects.dtos.UpdateCartRequest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class CartsTests extends ApiTestBase {
    @Test(description = "The user can retrieve the carts by user ID", groups = "api")
    public void getCartsByUser() {
        Response r = services.carts.getCartsByUser(1);
        assertEquals(r.statusCode(), 200, r.asPrettyString());

        assertNotNull(r.jsonPath().getList("carts"));
    }

//    @Test
//    public void cart_CRUD_multi() {
//        AddCartRequest addBody = new AddCartRequest(
//                1,
//                List.of(new CartProduct(1, 2), new CartProduct(2, 1))
//        );
//
//        Response addR = services.carts.addCart(addBody);
//        assertEquals(addR.statusCode(), 200, addR.asPrettyString());
//
//        int cartId = addR.jsonPath().getInt("id");
//        assertTrue(cartId > 0);
//
//        Response getR = services.carts.getCartById(cartId);
//        assertEquals(getR.statusCode(), 200, getR.asPrettyString());
//
//        UpdateCartRequest updBody = new UpdateCartRequest(List.of(new CartProduct(1, 5)));
//        Response updR = services.carts.updateCart(cartId, updBody);
//        assertEquals(updR.statusCode(), 200, updR.asPrettyString());
//
//        Response delR = services.carts.deleteCart(cartId);
//        assertEquals(delR.statusCode(), 200, delR.asPrettyString());
//        assertTrue(delR.jsonPath().getBoolean("isDeleted"));
//    }
}
