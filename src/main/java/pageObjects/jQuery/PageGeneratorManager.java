package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject geHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
