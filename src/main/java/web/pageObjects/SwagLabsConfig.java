package web.pageObjects;
import common.JSONUtil;

public class SwagLabsConfig {
    public static String getBaseUrl() {
        return JSONUtil.getValueFromJsonFile("src/main/java/web/pageObjects/swaglabsConfig.json", "baseUrlPROD");
    }
}
