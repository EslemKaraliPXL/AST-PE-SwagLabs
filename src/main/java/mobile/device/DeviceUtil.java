package mobile.device;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DeviceUtil {
    public static AppiumDriver createDevice() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", DeviceConfig.getPlatformName());
        capabilities.setCapability("automationName", DeviceConfig.getAutomationName());
        capabilities.setCapability("browserName", DeviceConfig.getBrowserName());

        return new AppiumDriver(AppiumUtil.startAppium(), capabilities);
    }
}
