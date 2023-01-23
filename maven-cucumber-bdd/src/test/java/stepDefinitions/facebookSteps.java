package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
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

    @When("^Input to Username Textbox$")
    public void inputToUsernameTextbox() {
       driver.findElement(By.id("email")).clear();
       driver.findElement(By.id("email")).sendKeys("autuomation@gmail.com");

    }

    @When("^Input to Password Textbox$")
    public void inputToPasswordTextbox() {
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("@123");
   
    }

    @When("^Input to Username Textbox with \"([^\"]*)\" and Password with \"([^\"]*)\"$")
    public void inputToUsernameTextboxWithAndPasswordWith(String username, String password)  {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
    }

    @When("^Input to Username Textbox with \"([^\"]*)\"$")
    public void inputToUsernameTextboxWith(String username) {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username);
    }

    @When("^Input to Password Textbox with \"([^\"]*)\"$")
    public void inputToPasswordTextboxWith(String password) {
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
    }

    @When("^Input to Username Textbox with ([^\"]*)$")
    public void inputToUsernameTextboxWithAutomationtestGmailCom(String username) {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username);
    }

    @When("^Input to Password Textbox with ([^\"]*)$")
    public void inputToPasswordTextbox(String password) {
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
    }

    @When("^Click to Submit button$")
    public void clickToSubmitButton() {
        driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
    }

    @And("^Close application$")
    public void closeApplication()  {
        //driver.quit();
    }
}
