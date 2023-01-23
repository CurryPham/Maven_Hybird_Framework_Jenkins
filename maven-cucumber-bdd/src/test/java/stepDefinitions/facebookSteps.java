package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class facebookSteps {
    WebDriver driver;

    @Given("^Open facebook application$")
    public void openFacebookApplication()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Verify email textbox is displayed$")
    public void verifyEmailTextboxIsDisplayed()  {
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
    }

    @And("^Verify password textbox is displayed$")
    public void verifyPasswordTextboxIsDisplayed()  {
        Assert.assertTrue(driver.findElement(By.id("pass")).isDisplayed());
    }

    @And("^Close application$")
    public void closeApplication()  {
        driver.quit();
    }
}
