package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUls.nopCommerce.user.HomePageUI;

public class UserCustomerInforPageObject extends BasePage {

	private WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify Login success")
	public String getSuccessLogin() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return getElementText(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

}
