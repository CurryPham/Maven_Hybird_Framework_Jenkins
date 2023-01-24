package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.UserHomePageObject;
import pageObjects.user.nopCommerce.UserLoginPageObject;
import pageObjects.user.nopCommerce.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_05_Generator_Manager_III extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, password, emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

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
	public void Login_01_With_Empty_Data() {
		System.out.println("Login_01 - Step 1: Click to Login link");
		loginPage = homePage.openLoginPage();

		System.out.println("Login_01 - Step 2: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_01 - Step 3: Verify error Email message");
		Assert.assertEquals(loginPage.getErrorMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_With_Invalid_Email() {
		System.out.println("Login_02 - Step 1: Click to Login link");
		loginPage = homePage.openLoginPage();

		System.out.println("Login_02 - Step 2: Input invalid Email");
		loginPage.inputToEmailTextbox("fewfwfwfwf");

		System.out.println("Login_02 - Step 3: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_02 - Step 4: Verify invalid Email  message");
		Assert.assertEquals(loginPage.getErrorMessage(), "Wrong email");
	}

	@Test
	public void Login_03_With_Email_Not_Register() {
		System.out.println("Login_03 - Step 1: Click to Login link");
		loginPage = homePage.openLoginPage();

		System.out.println("Login_03 - Step 2: Input  non register Email");
		loginPage.inputToEmailTextbox(emailAddress);

		System.out.println("Login_03 - Step 3: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_03 - Step 4: Verify invalid Email  message");
		Assert.assertEquals(loginPage.getIncorrectMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_04_With_Email_Register_And_Not_Enter_Password() {
		System.out.println("Login_04 - Step 1: Click to Login link");
		loginPage = homePage.openLoginPage();

		System.out.println("Login_04 - Step 2: Input Email");
		loginPage.inputToEmailTextbox(emailAddress);

		System.out.println("Login_04 - Step 3: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_04 - Step 4: Verify error blank Password message");
		Assert.assertEquals(loginPage.getIncorrectMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_With_Email_Register_And_Wrong_Password() {
		System.out.println("Login_05 - Step 1: Click to Login link");
		loginPage = homePage.openLoginPage();

		System.out.println("Login_05 - Step 2: Input Email");
		loginPage.inputToEmailTextbox(emailAddress);

		System.out.println("Login_05 - Step 3: Input wrong Password");
		loginPage.inputToPasswordTextbox("123");

		System.out.println("Login_05 - Step 4: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_05 - Step 5: Verify error wrong Password message");
		Assert.assertEquals(loginPage.getIncorrectMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_With_Email_Register_And_Correct_Password() {
		System.out.println("Login_06 - Step 1: Click to Login link");
		loginPage = homePage.openLoginPage();

		System.out.println("Login_06 - Step 2: Input Email");
		loginPage.inputToEmailTextbox(emailAddress);

		System.out.println("Login_06 - Step 3: Input Password");
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_06 - Step 4: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		System.out.println("Login_06 - Step 5: Verify error wrong Password message");
		Assert.assertEquals(homePage.getSuccessLogin(), "My account");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
