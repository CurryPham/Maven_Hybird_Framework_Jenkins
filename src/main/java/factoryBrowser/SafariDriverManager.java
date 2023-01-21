package factoryBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;


public class SafariDriverManager implements IBrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {

        if (!IS_OS_WINDOWS || !IS_OS_MAC) {
            throw new UnreachableBrowserException("Edge is not supported on" + System.getProperty("os.name"));
        }
        SafariOptions options = new SafariOptions();
        options.setCapability("safari.cleanSession", true);
        return new SafariDriver(options);
    }
}
