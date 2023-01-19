package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.nopCommerce.UserHomePageObject;
import pageObjects.user.nopCommerce.UserRegisterPageObject;

public class Common_01_Register extends BaseTest {

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classed test")
	public void Register(String browserName) {

		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "curry";
		lastName = "pham";
		emailAddress = "curry" + generateFakeNumber() + "@gmail.com";
		password = "123456";

		log.info("Pre-Condition - Step 01: Navigate to 'Register page'");
		registerPage = homePage.clickToRegister();

		log.info("Pre-Condition - Step 02: Enter to First Name textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextBox(firstName);

		log.info("Pre-Condition - Step 03: Enter to Last name textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextBox(lastName);

		log.info("Pre-Condition - Step 04: Enter to Email Address textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextBox(emailAddress);

		log.info("Pre-Condition - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextBox(password);

		log.info("Pre-Condition - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextBox(password);

		log.info("Pre-Condition - Step 07: Click to Register button");
		homePage = registerPage.clickToRegisterButton();

		log.info("Pre-Condition - Step 08: Verify register success mesage is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName;
	public static String password, emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
