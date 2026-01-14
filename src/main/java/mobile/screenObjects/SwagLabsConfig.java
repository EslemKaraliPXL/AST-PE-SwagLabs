package mobile.screenObjects;

import common.JSONUtil;

public class SwagLabsConfig {
    public static String getBaseUrl() {
        return JSONUtil.getValueFromJsonFile("src/main/java/strategy/mobile/screenObjects/herokuConfig.json", "baseUrlPROD");
    }
}
