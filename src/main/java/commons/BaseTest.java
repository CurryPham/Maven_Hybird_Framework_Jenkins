package commons;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import FactoryEnviroment.*;
import factoryBrowser.LocalFactory;
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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    private String projectPath = GlobalConstants.PROJECT_PATH;
    private WebDriver driver;
    protected final Log log;

    @BeforeSuite
    public void initBeforeSuite() {
        deleteAllureReport();
    }

    protected BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    protected WebDriver getBrowserDriver(String envName, String serverName, String browserName, String ipAddress, String portNumber,  String osName, String osVersion ) {
        switch (envName) {
            case "local":
                driver =  new LocalFactory(browserName).createDriver();
            break;
            case "grid":
                driver =  new GridFactory(browserName, ipAddress, portNumber).createDriver();
            break;
            case "browserstack":
                driver =  new BrowserStackFactory(browserName, osName, osVersion).createDriver();
            break;
            case "saucelab":
                driver =  new SauceBrowserFactory(browserName, osName).createDriver();
                break;
            case "crossbrowser":
                driver =  new CrossBrowserFactory(browserName, osName).createDriver();
                break;
            case "lambda":
                driver =  new LambdaBrowserFactory(browserName, osName).createDriver();
            break;
            default:
                break;
        }

        this.driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get(getEnviromentValue(serverName));

        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        if (browserList == BrowserList.FIREFOX) {
            // WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
                    GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLog.log");

            // Add extention to Firefox
            FirefoxProfile profile = new FirefoxProfile();
            File translate = new File(
                    GlobalConstants.PROJECT_PATH + "\\browserExtenstions\\to_google_translate-4.2.0.xpi");
            profile.addExtension(translate);
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            options.addArguments("--disable_notifications");
            options.addArguments("--disable-geolocation");
            options.addArguments("intl.accept_languages", "vi-vn, vi, en-us, en");

            options.setProfile(profile);
            driver = new FirefoxDriver(options);

        } else if (browserList == BrowserList.H_FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
        } else if (browserList == BrowserList.CHROME) {
            WebDriverManager.chromedriver().setup();

            // Add extention to Chrome
            File file = new File(GlobalConstants.PROJECT_PATH + "\\browserExtenstions\\extension_2_0_12_0.crx");
            ChromeOptions options = new ChromeOptions();
            options.addExtensions(file);
            // options.addArguments("--disable notifications");
            // options.addArguments("--disable-geolocation");
            // options.addArguments("--lang==vi");
            Map<String, Object> prefs = new HashMap<String, Object>();

            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("download.default_directory", GlobalConstants.PROJECT_PATH + "\\downloadFiles");
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            options.addArguments("--incognito");
            options.setExperimentalOption("prefs", prefs);
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

            System.setProperty("webdriver.chrome.args", "--disable-logging");
            System.setProperty("webdriver.chrome.args", "--disable-logging");

            driver = new ChromeDriver(options);
        } else if (browserList == BrowserList.H_CHROME) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if (browserList == BrowserList.EDGE) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Please Import Browser Driver");
        }

        this.driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get(GlobalConstants.USER_PAGE_URL);
        return this.driver;
    }

    protected WebDriver getBrowserDriverBrowserstack(String browserName, String appUrl, String osName, String osVersion) {
        DesiredCapabilities Capability = new DesiredCapabilities();
        Capability.setCapability("os", osName);
        Capability.setCapability("os_version", osVersion);
        Capability.setCapability("browser_version", "latest");
        Capability.setCapability("browserstack.debug", "true");
        Capability.setCapability("project", "NopCommerce");
        Capability.setCapability("resolution", "1920x1080");
        Capability.setCapability("name", "Run on" + osName + " | " + osVersion + " | " + browserName);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), Capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appUrl);
        return driver;
    }

    protected WebDriver getSauceDriverSoucelab(String browserName, String appUrl, String osName) {
        DesiredCapabilities Capability = new DesiredCapabilities();
        Capability.setCapability("platformName", osName);
        Capability.setCapability("browserName", browserName);
        Capability.setCapability("browserVersion", "latest");
        Capability.setCapability("name", "Run on" + osName + " | " + browserName);

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("screenResolution", "1920x1080");
        Capability.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_SOUCELABS_STACK_URL), Capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appUrl);
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String appUrl) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

        if (browserList == BrowserList.FIREFOX) {
            // WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

            // Add extention to Firefox
            // FirefoxProfile profile = new FirefoxProfile();
            // File translate = new File(GlobalConstants.PROJECT_PATH +
            // "\\browserExtenstions\\to_google_translate-4.2.0.xpi");
            // profile.addExtension(translate);
            // profile.setAcceptUntrustedCertificates(true);
            // profile.setAssumeUntrustedCertificateIssuer(false);
            FirefoxOptions options = new FirefoxOptions();
            // options.setProfile(profile);
            options.setAcceptInsecureCerts(false);
            driver = new FirefoxDriver(options);

        } else if (browserList == BrowserList.H_FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);

        } else if (browserList == BrowserList.CHROME) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Add extention to Chrome
            File file = new File(GlobalConstants.PROJECT_PATH + "\\browserExtenstions\\extension_2_0_12_0.crx");
            ChromeOptions options = new ChromeOptions();
            options.addExtensions(file);
            driver = new ChromeDriver(options);

        } else if (browserList == BrowserList.H_CHROME) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if (browserList == BrowserList.EDGE) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Please Import Browser Driver");
        }

        this.driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get(appUrl);
        return this.driver;
    }

    public WebDriver getDriverInstance() {
        return this.driver;
    }

    protected String getEnviromentUrl(String enviromentName) {
        String url = null;
        switch (enviromentName) {
            case "DEV":
                url = GlobalConstants.USER_PAGE_URL;
                break;
            case "TEST":
                url = GlobalConstants.ADMIN_PAGE_URL;
                break;
        }
        return url;
    }

    private String getEnviromentValue(String severName) {
        String envUrl = null;
        EnviromentList enviroment = EnviromentList.valueOf(severName.toUpperCase());
        if (enviroment == EnviromentList.DEV) {
            envUrl = "https://demo.nopcommerce.com/";
        }
        else if (enviroment == EnviromentList.TESTING) {
            envUrl = "https://admin-demo.nopcommerce.com";

        }
        else if (enviroment == EnviromentList.STAGING) {
            envUrl = "https://staging..nopcommerce.com";

        }
        else if (enviroment == EnviromentList.PRODUCTION) {
            envUrl = "https://production.nopcommerce.com";
        }
        return envUrl;
    }

    public void sleepInSecond(long timeinsecond) {
        try {
            Thread.sleep(timeinsecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            if (condition == false) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            System.out.println(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            System.out.println(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public void deleteAllureReport() {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void closeBrowserDriver() {
       // if (envName.equals("local") || envName.equals("grid")){
            String cmd = null;
            try {
                String osName = System.getProperty("os.name").toLowerCase();
                log.info("OS name = " + osName);

                String driverInstanceName = driver.toString().toLowerCase();
                log.info("Driver instance name = " + driverInstanceName);

                if (driverInstanceName.contains("chrome")) {
                    if (osName.contains("window")) {
                        cmd = "taskkill /F   /FI \"IMAGENAME eq chromedriver*\"";
                    } else {
                        cmd = "pkill chromedriver";
                    }
                } else if (driverInstanceName.contains("internetexplorer")) {
                    if (osName.contains("window")) {
                        cmd = "taskkill /F   /FI \"IMAGENAME eq IEDriverSever*\"";
                    }
                } else if (driverInstanceName.contains("firefox")) {
                    if (osName.contains("window")) {
                        cmd = "taskkill /F   /FI \"IMAGENAME eq geckodriver*\"";
                    } else {
                        cmd = "pkill geckodriver";
                    }
                } else if (driverInstanceName.contains("edge")) {
                    if (osName.contains("window")) {
                        cmd = "taskkill /F   /FI \"IMAGENAME eq msededriver*\"";
                    } else {
                        cmd = "pkill msededriver";
                    }
                } else if (driverInstanceName.contains("opera")) {
                    if (osName.contains("window")) {
                        cmd = "taskkill /F   /FI \"IMAGENAME eq operadriver*\"";
                    } else {
                        cmd = "pkill operadriver";
                    }
                } else if (driverInstanceName.contains("safari")) {
                    if (osName.contains("mac")) {
                        cmd = "pkill safaridriver";
                    }
                }

                if (driver != null) {
                    driver.manage().deleteAllCookies();
                    driver.quit();
                }
            } catch (Exception e) {
                log.info(e.getMessage());
            } finally {
                try {
                    Process process = Runtime.getRuntime().exec(cmd);
                    process.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
       // }

    }

    protected void showBrowserConsoleLogs(WebDriver driver) {
        if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
            LogEntries logs = driver.manage().logs().get("browser");
            List<LogEntry> logList = logs.getAll();
            for (LogEntry logging : logList) {
                if (logging.getLevel().toString().toLowerCase().contains("error")) {
                    log.info("----------------" + logging.getLevel().toString() + "----------------------\n"
                            + logging.getMessage());
                }
            }

        }
    }
}
