package FactoryEnviroment;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserStackFactory {
    private WebDriver driver;
    private  String browserName;
    private String osName;
    private String osVersion;


    public BrowserStackFactory(String browserName, String osName, String osVersion) {
        this.browserName = browserName;
        this.osName = osName;
        this.osVersion = osVersion;
    }
    public WebDriver createDriver() {
        DesiredCapabilities Capability = new DesiredCapabilities();
        Capability.setCapability("os", osName);
        Capability.setCapability("os_version", osVersion);
        Capability.setCapability("browser_version", "latest");
        Capability.setCapability("browserstack.debug", "true");
        Capability.setCapability("project", "NopCommerce");
        Capability.setCapability("resolution", "1920x1080");
        Capability.setCapability("name", "Run on" + osName + " | " + osVersion + " | " + browserName);


        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalInstance().getBrowserStackUrl()), Capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
