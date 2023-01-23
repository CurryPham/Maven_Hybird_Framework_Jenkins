package commons;

import lombok.Getter;

import java.io.File;
import java.util.Objects;


@Getter
public class GlobalConstants {
	private static GlobalConstants globalInstance;
	private GlobalConstants() {

    }

    public static synchronized GlobalConstants getGlobalInstance() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstants();
		}
//		if (Objects.isNull(globalInstance)) {
//			globalInstance = new GlobalConstants();
//		}
		return  globalInstance;
	}

	private final String userPageUrl = "https://demo.nopcommerce.com/";
	private final String adminPageUrl = "https://admin-demo.nopcommerce.com";
	private final String getTestAppUserUrl = "https://demo.nopcommerce.com/";
	private final String testAppAdminUrl = "https://admin-demo.nopcommerce.com";
	private final String projectPath = System.getProperty("user.dir");
	private final String javaVersion = System.getProperty("java.version");
	private final String osName = "os.name";
	private final String uploadFolderPath = projectPath + File.separator + "uploadFiles" + File.separator;
	private final String dowloadFolderPath = projectPath + File.separator + "dowloadFiles";
	private final String browserLogPath = projectPath + File.separator + "browserLogs";
	private final String dragAndDrogHTML5 = projectPath + File.separator + "dragDropsHTML5";
	private final String autoITScript = projectPath + File.separator + "autoIT";
	private final String reportingScreenshot = projectPath + File.separator + "reportNGImages" + File.separator;
	private final String browserStackUsername = "automation_kpN7twLsux";
	private final String browserStackKey = "yCiWTxExJk6JURrsQWmJ";
	private final String browserStackUrl = "https://" + browserStackUsername + ":" + browserStackKey + "@hub-cloud.browserstack.com/wd/hub";
	private final String saucelabUsername = "oauth-d3891340-042e7";
	private final String saucelabKey = "0088dcc6-5dc5-4085-8a90-8d4cf4c47a0f";
	private final String saucelabUrl = "https://" + saucelabUsername + ":" + saucelabKey + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
	private final String crossBrowserUsername = "oauth-d3891340-042e7";
	private final String crossBrowserKey = "0088dcc6-5dc5-4085-8a90-8d4cf4c47a0f";
	private final String crossBrowserUrl = "https://" + crossBrowserUsername + ":" + crossBrowserKey + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
	private final String lambaUsername = "oauth-d3891340-042e7";
	private final String lambaKey = "0088dcc6-5dc5-4085-8a90-8d4cf4c47a0f";
	private final String lambaUrl = "https://" + lambaUsername + ":" + lambaKey + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
	private final String databaseDevUrl = "31.34.324.444:3424";
	private final String databaseDevUsername = "curry";
	private final String databaseDevPass = "Pass@world1!";
	private final String databaseTestingUrl = "23.24.255.24:4242";
	private final String databaseTestingUsername = "currypham";
	private final String databaseTestingPass = "Pass@world1!";
	private final long shortTimeOut = 5;
	private final long longTimeOut = 30;
	private final long retryTestRail = 3;

}
