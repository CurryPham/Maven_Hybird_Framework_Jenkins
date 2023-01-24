package FactoryEnviroment;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LambdaBrowserFactory {

    private WebDriver driver;
    private String browserName;
    private String osName;

    public LambdaBrowserFactory(String browserName, String osName) {
        this.browserName = browserName;
        this.osName = osName;
    }

    public WebDriver createDriver(){
        DesiredCapabilities Capability = new DesiredCapabilities();
        Capability.setCapability("browserName", browserName);
        Capability.setCapability("platform", osName);
        Capability.setCapability("version", "latest");
        Capability.setCapability("video", true);
        Capability.setCapability("visual", true);
        if (osName.contains("Windows")) {
            Capability.setCapability("screenResolution", "1920x1080");
        } else {
            Capability.setCapability("screenResolution", "2560x1600");
        }
        Capability.setCapability("name", "Run on" + osName + " | " + browserName);
        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalInstance().getLambaUrl()), Capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
