package FactoryEnviroment;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CrossBrowserFactory {

    private WebDriver driver;
    private String browserName;
    private String osName;

    public CrossBrowserFactory(String browserName, String osName) {
        this.browserName = browserName;
        this.osName = osName;
    }

    public WebDriver createDriver(){
        DesiredCapabilities Capability = new DesiredCapabilities();
        Capability.setCapability("platform", osName);
        Capability.setCapability("record_video", "true");
        if (osName.contains("Windows")) {
            Capability.setCapability("screenResolution", "1920x1080");
        } else {
            Capability.setCapability("screenResolution", "1920x1440");
        }
        Capability.setCapability("name", "Run on" + osName + " | " + browserName);
        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.CROSS_URL), Capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
