package factoryBrowser;

import commons.BrowserList;
import commons.EnviromentList;
import commons.GlobalConstants;
import commons.VerificationFailures;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static commons.BrowserList.CHROME;

public class LocalFactory {

	private String projectPath = GlobalConstants.getGlobalInstance().getProjectPath();
	private WebDriver driver;
	private String browserName;


	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
			case CHROME:
                driver = new ChromeDriverManager().getBrowserDriver();
			break;
			case H_CHROME:
                driver = new HeadlessChromeDriverManager().getBrowserDriver();
			break;
			case FIREFOX:
                driver = new FirefoxDriverManager().getBrowserDriver();
			break;
			case H_FIREFOX:
                driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
			break;
			case EDGE:
                driver = new EdgeDriverManager().getBrowserDriver();
			break;
			case SAFARI:
                driver = new SafariDriverManager().getBrowserDriver();
			break;

			default:
				throw new UnreachableBrowserException(browserName);
		}

		return driver;
	}

}
