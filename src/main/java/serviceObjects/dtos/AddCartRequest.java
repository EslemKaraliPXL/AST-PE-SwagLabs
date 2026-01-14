package serviceObjects.dtos;

import java.util.List;

public class AddCartRequest {
    public int userId;
    public List<CartProduct> products;

    public AddCartRequest(int userId, List<CartProduct> products) {
        this.userId = userId;
        this.products = products;
    }
}
