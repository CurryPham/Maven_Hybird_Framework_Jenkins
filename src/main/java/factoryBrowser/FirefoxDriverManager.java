package factoryBrowser;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements IBrowserFactory {
    private String projectPath = GlobalConstants.getGlobalInstance().getProjectPath();
    private WebDriver driver;
    @Override
    public WebDriver getBrowserDriver() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.getGlobalInstance().getProjectPath() + "\\browserLogs\\FirefoxLog.log");

        options.addPreference("browser.dowload.folderList", 2);
        options.addPreference("browser.download.dir", GlobalConstants.getGlobalInstance().getDowloadFolderPath());
        options.addPreference("browser.download.useDownloadDir", true);
        options.addPreference("browser.helperApps.newAsk.saveToDisk", "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword," +
                "application/csv,text/csv,image/png,image/jpeg,application/pdf, text/html,text/plain, application/excel,application/vnd.ms-excel,application/x-msexcel,application/octet-stream");

        options.addPreference("pdfjs.disable", true);
//        options.addArguments("-private");
        return new FirefoxDriver(options);
    }
}
