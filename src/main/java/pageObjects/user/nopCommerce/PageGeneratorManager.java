package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.nopCommerce.AdminDashboardPageObject;
import pageObjects.admin.nopCommerce.AdminPageObject;
import pageObjects.facebook.LoginPageObject;

public class PageGeneratorManager {

	public  static PageGeneratorManager getPageGeneratorManager() {
		return new PageGeneratorManager();
	}

	public  UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public  UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public  UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public  UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}

	public  UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public  UserRewardPointPageObject getUserRewaidPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public  UserMyProductReviewPageObject getUserMyProductReview(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}

	public  AdminPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminPageObject(driver);
	}

	public  AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public  LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

}
