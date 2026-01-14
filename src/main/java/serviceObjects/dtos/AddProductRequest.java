package serviceObjects.dtos;

public class AddProductRequest {
    public String title;
    public String description;
    public double price;

    public AddProductRequest(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
