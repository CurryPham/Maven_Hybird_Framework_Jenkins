package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.admin.nopCommerce.AdminDashboardPageObject;
import pageObjects.admin.nopCommerce.AdminPageObject;
import pageObjects.user.nopCommerce.UserCustomerInforPageObject;
import pageObjects.user.nopCommerce.UserHomePageObject;
import pageObjects.user.nopCommerce.UserLoginPageObject;
import pageObjects.user.nopCommerce.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_07_Swtich_Role extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		userFirstName = "curry";
		userLastName = "pham";
		userEmailAddress = "curry" + generateFakeNumber() + "@gmail.com";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

		userHomePage = PageGeneratorManager.getPageGeneratorManager().getUserHomePage(driver);

		System.out.println("Pre_Conditon - Step 01: Click to Register link");
		userRegisterPage = userHomePage.clickToRegister();

		System.out.println("Pre_Conditon - Step 02: Input to required fields");
		userRegisterPage.inputToFirstnameTextBox(userFirstName);
		userRegisterPage.inputToLastnameTextBox(userLastName);
		userRegisterPage.inputToEmailTextBox(userEmailAddress);
		userRegisterPage.inputToPasswordTextBox(userPassword);
		userRegisterPage.inputToConfirmPasswordTextBox(userPassword);

		System.out.println("Pre_Conditon - Step 03: Click to Register button");
		userHomePage = userRegisterPage.clickToRegisterButton();

		System.out.println("Pre_Conditon - Step 04: Verify success message displayed");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();

		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertEquals(userHomePage.getSuccessLogin(), "My account");

		userCustomerInforPage = userHomePage.clickToCustomerInfor();

		userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);

		userHomePage.openUrl(driver, GlobalConstants.getGlobalInstance().getAdminPageUrl());
		adminLoginPage = PageGeneratorManager.getPageGeneratorManager().getAdminLoginPage(driver);

		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		adminLoginPage.openUrl(driver, GlobalConstants.getGlobalInstance().getUserPageUrl());
		userHomePage = PageGeneratorManager.getPageGeneratorManager().getUserHomePage(driver);

		userLoginPage = userHomePage.openLoginPage();

		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertEquals(userHomePage.getSuccessLogin(), "My account");

		userHomePage.clickToLogoutLinkAtUserPage(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String userFirstName, userLastName, userPassword, userEmailAddress, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private AdminPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

}
