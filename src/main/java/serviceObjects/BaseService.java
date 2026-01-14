package serviceObjects;

public class BaseService {
    protected final String baseUrl = "https://dummyjson.com/";
    protected String endpoint = "";

    protected BaseService(String endpoint) {
        this.endpoint = endpoint;
    }
}
