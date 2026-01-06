package mobile.device;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AppiumUtil {
    public static URL startAppium() {
        try {
            URI uri = new URI("http://127.0.0.1:4723/");
            return uri.toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
