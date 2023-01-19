package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.nopCommerce.UserCustomerInforPageObject;
import pageObjects.user.nopCommerce.UserHomePageObject;
import pageObjects.user.nopCommerce.UserLoginPageObject;
import pageObjects.user.nopCommerce.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_15_ReportNG_Screenshot extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		firstName = "curry";
		lastName = "pham";
		emailAddress = "curry" + generateFakeNumber() + "@gmail.com";
		password = "123456";

		homePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register page'");
		registerPage = homePage.clickToRegister();

		log.info("Register - Step 02: Enter to First Name textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextBox(firstName);
		log.info("Register - Step 03: Enter to Last name textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextBox(lastName);
		log.info("Register - Step 04: Enter to Email Address textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextBox(emailAddress);
		log.info("Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextBox(password);
		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextBox(password);

		log.info("Register - Step 07: Click to Register button");
		homePage = registerPage.clickToRegisterButton();

		log.info("Register - Step 08: Verify register success mesage is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "....Your registration completed");

	}

	@Test
	public void User_02_Login() {
		log.info("Register - Step 01: Navigate to 'Home page'");
		loginPage = homePage.openLoginPage();

		log.info("Register - Step 02: Enter to  Email Address textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Register - Step 03: Enter to Password textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Register - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Register - Step 05: Verify login success mesage is displayed");
		Assert.assertEquals(homePage.getSuccessLogin(), "My account....");

		log.info("Register - Step 06: Navigate to 'Customer infor page'");
		customerInforPage = homePage.clickToCustomerInfor();

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

}
