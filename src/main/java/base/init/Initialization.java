package main.java.base.init;

import main.java.base.config.Config;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class Initialization {

    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement webElement;
    public String BrowType;
    public Actions actions;
    public boolean testResult = false;
    public Robot robot;

    public BrowserType browType = null;
    public String browTypeS = null;

    /**
     * @param browserType Can Take "Firefox", "Chrome" and "IE"
     * @brief Initializes WebDriver depending on WebDriver selection.
     */
    public void init(BrowserType browserType) {

        if (browserType == BrowserType.FIREFOX) {
            System.setProperty("webdriver.gecko.driver", Config.firefoxDriver);
            FirefoxOptions options = new FirefoxOptions();
            if (Config.headless.equals("1")) {
                options.setHeadless(true);
                driver = new FirefoxDriver(options);
            } else {
                driver = new FirefoxDriver(options);
            }
        } else if (browserType == BrowserType.CHROME) {
            System.setProperty("webdriver.chrome.driver", Config.chromeDriver);
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            if (Config.headless.equals("1")) {
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            } else {
                driver = new ChromeDriver(options);
            }
        } else if (browserType == BrowserType.IE) {
            System.setProperty("webdriver.ie.driver", Config.ieDriver);

            InternetExplorerOptions ieOptions = new InternetExplorerOptions();
            ieOptions.ignoreZoomSettings();
            ieOptions.introduceFlakinessByIgnoringSecurityDomains();
            driver = new InternetExplorerDriver(ieOptions);
        }
        browType = browserType;

    }

    public void init(String browserType) {

        if (browserType == "FIREFOX") {
            System.setProperty("webdriver.gecko.driver", Config.firefoxDriver);
            driver = new FirefoxDriver();
        } else if (browserType == "CHROME") {
            System.setProperty("webdriver.chrome.driver", Config.chromeDriver);
            driver = new ChromeDriver();
        } else if (browserType == "IE") {
            System.setProperty("webdriver.ie.driver", Config.ieDriver);

            InternetExplorerOptions ieOptions = new InternetExplorerOptions();
            ieOptions.ignoreZoomSettings();
            ieOptions.introduceFlakinessByIgnoringSecurityDomains();
            driver = new InternetExplorerDriver(ieOptions);
        }

        browTypeS = browserType;

    }
}
