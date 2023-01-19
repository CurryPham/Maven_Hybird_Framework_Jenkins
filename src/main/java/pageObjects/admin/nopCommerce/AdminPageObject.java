package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;
import com.nopcommerce.data.AdminData;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminPageUI;

public class AdminPageObject extends BasePage {
	private WebDriver driver;

	public AdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextBox(String emailAddress) {
		waitForElementVisible(driver, AdminPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextBox(String passWord) {
		waitForElementVisible(driver, AdminPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminPageUI.PASSWORD_TEXTBOX, passWord);
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String passWord) {
		inputToUsernameTextBox(emailAddress);
		inputToPasswordTextBox(passWord);
		return clickToLoginButton();
	}
}
