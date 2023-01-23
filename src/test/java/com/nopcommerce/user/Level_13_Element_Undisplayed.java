package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.facebook.LoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_13_Element_Undisplayed extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		loginPage = PageGeneratorManager.getPageGeneratorManager().getLoginPage(driver);

	}

	@Test
	public void User_01_With_Email_Register_And_Correct_Password() {

		loginPage.clickToCreateNewAccountButton();

		loginPage.enterToEmailAddressTextbox("currypham@gmail.com");
		loginPage.sleepInSecond(3);

		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	}

	@Test
	public void User_02_Verify_Element_Undisplayed_In_Dom() {
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);

		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@Test
	public void User_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(3);

		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private LoginPageObject loginPage;

}
