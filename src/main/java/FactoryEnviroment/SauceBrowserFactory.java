package FactoryEnviroment;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SauceBrowserFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;

    public SauceBrowserFactory(String browserName, String osName) {
        this.browserName = browserName;
        this.osName = osName;
    }

    public WebDriver createDriver() {
        DesiredCapabilities Capability = new DesiredCapabilities();
        Capability.setCapability("platformName", osName);
        Capability.setCapability("browserName", browserName);
        Capability.setCapability("browserVersion", "latest");
        Capability.setCapability("name", "Run on" + osName + " | " + browserName);

        Map<String, Object> sauceOptions = new HashMap<>();
        if (osName.contains("Windows")) {
            sauceOptions.put("screenResolution", "1920x1080");
        } else {
            sauceOptions.put("screenResolution", "1920x1440");
        }
        Capability.setCapability("sauce:options", sauceOptions);
        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_SOUCELABS_STACK_URL), Capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
