package factoryBrowser;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.HashMap;

public class HeadlessChromeDriverManager implements IBrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("window-size=1920x1080");

        return new ChromeDriver(options);
    }
}
