package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.UserCustomerInforPageObject;
import pageObjects.user.nopCommerce.UserHomePageObject;
import pageObjects.user.nopCommerce.UserLoginPageObject;
import pageObjects.user.nopCommerce.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_15_ExtendV2_Screenshot extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		firstName = "curry";
		lastName = "pham";
		emailAddress = "curry" + generateFakeNumber() + "@gmail.com";
		password = "123456";

		homePage = PageGeneratorManager.getPageGeneratorManager().getUserHomePage(driver);

	}

	@Test
	public void User_01_Register(Method method) {
		// ExtentTestManager.startTest(method.getName(), "User_01_Register");
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register page'");
		// registerPage = homePage.clickToRegister();
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to First Name textbox with value is '" + firstName + "'");
		// registerPage.inputToFirstnameTextBox(firstName);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Last name textbox with value is '" + lastName + "'");
		// registerPage.inputToLastnameTextBox(lastName);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email Address textbox with value is '" + emailAddress + "'");
		// registerPage.inputToEmailTextBox(emailAddress);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		// registerPage.inputToPasswordTextBox(password);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
		// registerPage.inputToConfirmPasswordTextBox(password);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to Register button");
		// homePage = registerPage.clickToRegisterButton();
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success mesage is displayed");
		// Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "....Your registration completed");
		// ExtentTestManager.endTest();
	}

	@Test
	public void User_02_Login(Method method) {
		// ExtentTestManager.startTest(method.getName(), "User_02_Login");
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Home page'");
		// loginPage = homePage.openLoginPage();
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Email Address textbox with value is '" + emailAddress + "'");
		// loginPage.inputToEmailTextbox(emailAddress);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Password textbox with value is '" + password + "'");
		// loginPage.inputToPasswordTextbox(password);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 04: Click to Login button");
		// homePage = loginPage.clickToLoginButton();
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 05: Verify login success mesage is displayed");
		// Assert.assertEquals(homePage.getSuccessLogin(), "My account..");
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 06: Navigate to 'Customer infor page'");
		// customerInforPage = homePage.clickToCustomerInfor();
		// ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	String firstName, lastName, password, emailAddress;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInforPageObject customerInforPage;

}
