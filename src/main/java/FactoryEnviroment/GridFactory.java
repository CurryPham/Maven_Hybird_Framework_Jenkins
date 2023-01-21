package FactoryEnviroment;

import org.openqa.selenium.WebDriver;

public class GridFactory {
        private  String browserName;
        private String  ipAddress;
        private String portNumber;
        private WebDriver driver;

    public GridFactory(String browserName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public WebDriver createDriver(){

        return driver;
    }
}
