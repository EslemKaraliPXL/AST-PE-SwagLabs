package serviceObjects.dtos;

import java.util.List;

public class UpdateCartRequest {
    public List<CartProduct> products;

    public UpdateCartRequest(List<CartProduct> products) {
        this.products = products;
    }
}
