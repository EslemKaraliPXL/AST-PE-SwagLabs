package testObjects;

public class TestObjectConfig {
    public static String GetTestObject() {
        return System.getProperty("testobject", "web");
    }
}
