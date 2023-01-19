package com.jquery.database;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	String beachFileName = "Beach.jpg";
	String computerFileName = "Computer.jpg";
	String mountainFileName = "Mountain.jpg";

	String[] multipleFileName = { beachFileName, computerFileName, mountainFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.geHomePageObject(driver);
	}

	@Test
	public void Table_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, beachFileName);

		Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(beachFileName));

		Assert.assertTrue(homePage.isFileImageUpLoadedByName(beachFileName));

	}

	@Test
	public void Table_02_Multiple_File_Per_Time() {
		homePage.refeshToPage(driver);

		homePage.uploadMultipleFiles(driver, multipleFileName);

		Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(computerFileName));

		Assert.assertTrue(homePage.isFileImageUpLoadedByName(mountainFileName));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
