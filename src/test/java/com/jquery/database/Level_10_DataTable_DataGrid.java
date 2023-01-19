package com.jquery.database;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.geHomePageObject(driver);
	}

	public void Table_01_Paging() {

		homePage.openPagingPageNumber("5");
		Assert.assertTrue(homePage.isNumberActived("5"));

		homePage.openPagingPageNumber("7");
		Assert.assertTrue(homePage.isNumberActived("7"));

		homePage.openPagingPageNumber("9");
		Assert.assertTrue(homePage.isNumberActived("9"));

		homePage.openPagingPageNumber("11");
		Assert.assertTrue(homePage.isNumberActived("11"));

		homePage.openPagingPageNumber("14");
		Assert.assertTrue(homePage.isNumberActived("14"));

	}

	public void Table_02_Enter_To_Header() {
		homePage.refeshToPage(driver);

		homePage.enterToHEaderTextboxByLabel("Country", "Argentina");

		homePage.enterToHEaderTextboxByLabel("Females", "338282");

		homePage.enterToHEaderTextboxByLabel("Males", "349238");

		homePage.enterToHEaderTextboxByLabel("Total", "687522");
	}

	public void Table_03_Enter_To_Header() {

		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, false);
	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();

		// homePage.enterToTextboxByColumnNameAtRowNumber("Company", "2", "Cbum");
		//
		// homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "3", "Chris");
		//
		// homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "1", "Heria");
		//
		// homePage.enterToDropdownByColumnNameAtRowNumber("Country", "1", "Japan");
		//
		// homePage.enterToDropdownByColumnNameAtRowNumber("Country", "2", "Germany");
		//
		// homePage.enterToDropdownByColumnNameAtRowNumber("Country", "3", "Hong Kong");
		//
		// homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
		//
		// homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		//
		// homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		//
		// homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "4");

		homePage.clickToButtonByRowNumber("1", "Insert Row Above");

		homePage.clickToButtonByRowNumber("9", "Remove Current Row");

		homePage.clickToButtonByRowNumber("4", "Move Up");

		homePage.clickToButtonByRowNumber("1", "Move Down");

		homePage.clickToButtonByRowNumber("1", "Remove Current Row");

		homePage.clickToButtonByRowNumber("2", "Remove Current Row");

		homePage.clickToButtonByRowNumber("3", "Remove Current Row");

		homePage.clickToButtonByRowNumber("4", "Remove Current Row");

		homePage.clickToButtonByRowNumber("5", "Remove Current Row");

		homePage.clickToButtonByRowNumber("6", "Remove Current Row");

		homePage.clickToButtonByRowNumber("7", "Remove Current Row");

		homePage.clickToButtonByRowNumber("8", "Remove Current Row");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
