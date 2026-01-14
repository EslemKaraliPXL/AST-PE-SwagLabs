package api.hooks;

import org.testng.annotations.BeforeClass;
import serviceObjects.AllServices;

public class ApiTestBase {
    protected AllServices services;

    @BeforeClass
    public void setup() {
        services = new AllServices();
    }
}
