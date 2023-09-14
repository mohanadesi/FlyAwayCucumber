package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup {
    public static WebDriver initializeWebDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\BrowserDrivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        return new FirefoxDriver(options);
    }
}
