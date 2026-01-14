//package mobile.screenObjects;
//
//import io.appium.java_client.AppiumDriver;
//import mobile.device.DeviceUtil;
//import testObjects.IAllObjects;
//import testObjects.ILoginObject;
//
//public class AllSwagLabsScreens implements IAllObjects {
//    private AppiumDriver driver;
//    public LoginScreen login;
//
//    private All(AppiumDriver driver) {
//        this.driver = driver;
//        this.login = new LoginScreen(driver);
//    }
//
//    @Override
//    public ILoginObject login() {
//        return login;
//    }
//
//    public static AllSwagLabsScreens init() {
//        AppiumDriver driver = DeviceUtil.createDevice();
//        return new AllSwagLabsScreens(driver);
//    }
//
//    public void close() {
//        driver.quit();
//    }
//}
