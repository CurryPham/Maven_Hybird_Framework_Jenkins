package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject geHomePageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
