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

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_12_Assert_Verify extends BaseTest {

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
	public void User_01_With_Email_Register_And_Correct_Password() {
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
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");

		System.out.println("User_01 - Step 1: Click to Login link");
		loginPage = homePage.openLoginPage();

		System.out.println("User_01 - Step 2: Input Email");
		loginPage.inputToEmailTextbox(emailAddress);

		System.out.println("User_01 - Step 3: Input Password");
		loginPage.inputToPasswordTextbox(password);

		System.out.println("User_01 - Step 4: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		System.out.println("User_01 - Step 5: Verify error wrong Password message");
		verifyEquals(homePage.getSuccessLogin(), "My accountcwc");

		System.out.println("User_01 - Step 6: Click to Login button");
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
