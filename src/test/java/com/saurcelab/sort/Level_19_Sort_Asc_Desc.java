package com.saurcelab.sort;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.sourcelab.LoginPageObject;
import pageObject.sourcelab.PageGeneratorManager;
import pageObject.sourcelab.ProductPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_19_Sort_Asc_Desc extends BaseTest {

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String saucelabUrl) {
		driver = getBrowserDriver(browserName, saucelabUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToUsernameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_Name() {

		productPage.selectItemInProductSortDropDown("Name (A to Z)");

		Assert.assertTrue(productPage.isProductNameSortByAscending());

		productPage.selectItemInProductSortDropDown("Name (Z to A)");

		Assert.assertTrue(productPage.isProductNameSortByDescending());

	}

	@Test
	public void TC_02_Price() {

		productPage.selectItemInProductSortDropDown("Price (low to high)");

		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		productPage.selectItemInProductSortDropDown("Price (high to low)");

		Assert.assertTrue(productPage.isProductPriceSortByDescending());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	WebDriver driver;
	ProductPageObject productPage;
	LoginPageObject loginPage;

}
