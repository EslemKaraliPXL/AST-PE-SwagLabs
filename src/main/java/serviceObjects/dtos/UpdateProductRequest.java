package serviceObjects.dtos;

public class UpdateProductRequest {
    public String title;
    public Double price;

    public UpdateProductRequest(String title, Double price) {
        this.title = title;
        this.price = price;
    }
}
