package factoryBrowser;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.HashMap;

public class ChromeDriverManager implements IBrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwotches", Collections.singletonList("enable-automation"));
        options.addArguments("--disable notifications");
        options.addArguments("--disable-geolocation");
        options.addArguments("--lang==vi");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_setting.popups", 0);
        chromePrefs.put("dowload.default_diretory", GlobalConstants.getGlobalInstance().getDowloadFolderPath());
        options.setExperimentalOption("prefs", chromePrefs);

//        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }
}
