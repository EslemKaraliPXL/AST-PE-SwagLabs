package serviceObjects.dtos;

public class CartResponse {
    public int id;
    public int userId;
    public CartItem[] products;

    public static class CartItem {
        public int id;
        public String title;
        public int quantity;
        public double price;
        public double total;
    }
}
