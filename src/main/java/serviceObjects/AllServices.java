package serviceObjects;

public class AllServices {
    public AuthService auth;
    public UsersService users;
    public ProductsService products;
    public CartsService carts;

    public AllServices() {
        auth = new AuthService();
        users = new UsersService();
        products = new ProductsService();
        carts = new CartsService();
    }
}
