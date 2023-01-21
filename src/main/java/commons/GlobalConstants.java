package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";
	public static final String USER_TESTING_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String OS_NAME = "os.name";
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWLOAD_FILE = PROJECT_PATH + File.separator + "dowloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropsHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
	public static final String BROWSER_USERNAME = "automation_kpN7twLsux";
	public static final String BROWSER_AUTOMATE_KEY = "yCiWTxExJk6JURrsQWmJ";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static final String BROWSER_SOUCELABS_USERNAME = "oauth-d3891340-042e7";
	public static final String BROWSER_SOUCELABS_AUTOMATE_KEY = "0088dcc6-5dc5-4085-8a90-8d4cf4c47a0f";
	public static final String BROWSER_SOUCELABS_STACK_URL = "https://" + BROWSER_SOUCELABS_USERNAME + ":" + BROWSER_SOUCELABS_AUTOMATE_KEY + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
	public static final String CROSS_USERNAME = "oauth-d3891340-042e7";
	public static final String CROSS_KEY = "0088dcc6-5dc5-4085-8a90-8d4cf4c47a0f";
	public static final String CROSS_URL = "https://" + CROSS_USERNAME + ":" + CROSS_KEY + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
	public static final String LAMBDA_USERNAME = "oauth-d3891340-042e7";
	public static final String LAMBDA_KEY = "0088dcc6-5dc5-4085-8a90-8d4cf4c47a0f";
	public static final String LAMBDA_URL = "https://" + LAMBDA_USERNAME + ":" + LAMBDA_KEY + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
	public static final String DB_DEV_URL = "31.34.324.444:3424";
	public static final String DB_DEV_USER = "curry";
	public static final String DB_DEV_PASS = "Pass@world1!";
	public static final String DB_TESTING_URL = "23.24.255.24:4242";
	public static final String DB_TESTING_USER = "currypham";
	public static final String DB_TESTING_PASS = "Pass@world1!";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;

}
