package factoryBrowser;

import org.openqa.selenium.WebDriver;

public interface IBrowserFactory {
        abstract WebDriver getBrowserDriver();
}
