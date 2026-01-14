package testObjects;

import web.pageObjects.AllSwagLabsPages;

public class TestObjectFactory {
    public static IAllObjects init() {
        String type = TestObjectConfig.GetTestObject();

        switch (type) {
//            case "web":
//                return AllSwagLabsPages.init();
//            case "mobile":
//                return AllSwagLabsScreens.init();
            default:
                throw new IllegalArgumentException("Invalid test object type: " + type);
        }
    }
}
