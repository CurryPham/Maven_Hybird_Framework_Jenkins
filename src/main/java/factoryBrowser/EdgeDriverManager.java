package factoryBrowser;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.Collections;
import java.util.HashMap;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;


public class EdgeDriverManager implements IBrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {

        if (!IS_OS_WINDOWS || !IS_OS_MAC) {
            throw new UnreachableBrowserException("Edge is not supported on" + System.getProperty("os.name"));
        }
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        return new EdgeDriver(options);
    }
}
