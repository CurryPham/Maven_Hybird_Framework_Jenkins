package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.UserAddressPageObject;
import pageObjects.user.nopCommerce.UserCustomerInforPageObject;
import pageObjects.user.nopCommerce.UserHomePageObject;
import pageObjects.user.nopCommerce.UserLoginPageObject;
import pageObjects.user.nopCommerce.UserMyProductReviewPageObject;
import pageObjects.user.nopCommerce.UserRegisterPageObject;
import pageObjects.user.nopCommerce.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Dynamic_Locator extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		firstName = "curry";
		lastName = "pham";
		emailAddress = "curry" + generateFakeNumber() + "@gmail.com";
		password = "123456";

		homePage = PageGeneratorManager.getPageGeneratorManager().getUserHomePage(driver);

		System.out.println("Pre_Conditon - Step 01: Click to Register link");
		registerPage = homePage.clickToRegister();

		System.out.println("Pre_Conditon - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextBox(firstName);
		registerPage.inputToLastnameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);

		System.out.println("Pre_Conditon - Step 03: Click to Register button");
		homePage = registerPage.clickToRegisterButton();

		System.out.println("Pre_Conditon - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void User_01_With_Email_Register_And_Correct_Password() {
		System.out.println("User_01 - Step 1: Click to Login link");
		loginPage = homePage.openLoginPage();

		System.out.println("User_01 - Step 2: Input Email");
		loginPage.inputToEmailTextbox(emailAddress);

		System.out.println("User_01 - Step 3: Input Password");
		loginPage.inputToPasswordTextbox(password);

		System.out.println("User_01 - Step 4: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		System.out.println("User_01 - Step 5: Verify error wrong Password message");
		Assert.assertEquals(homePage.getSuccessLogin(), "My account");

		System.out.println("User_01 - Step 6: Click to Login button");
		customerInforPage = homePage.clickToCustomerInfor();
	}

	@Test
	public void User_02_Switch_Page() {

		addressPage = customerInforPage.openAddressPage(driver);

		myProductReviewPage = addressPage.openMyProductReviewPage(driver);

		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);

		addressPage = rewardPointPage.openAddressPage(driver);

		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);

	}

	@Test
	public void User_03_Dynamic_Page_01() {

		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points");

		addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");

		rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountByName(driver, "Reward points");

		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");

		customerInforPage = (UserCustomerInforPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Customer info");

	}

	@Test
	public void User_03_Dynamic_Page_02() {

		customerInforPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getPageGeneratorManager().getUserRewaidPointPage(driver);

		rewardPointPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getPageGeneratorManager().getUserAddressPage(driver);

		addressPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getPageGeneratorManager().getUserRewaidPointPage(driver);

		rewardPointPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getPageGeneratorManager().getUserMyProductReview(driver);

		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getPageGeneratorManager().getUserCustomerInforPage(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, password, emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;

}
