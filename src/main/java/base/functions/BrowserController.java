package main.java.base.functions;

import main.java.base.config.Config;
import main.java.base.config.LogUtil;
import main.java.base.init.BrowserType;
import main.java.base.init.Initialization;
import main.java.base.variables.Var;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public interface BrowserController {

    Initialization in = new Initialization();


    public default void openBrowser(BrowserType browserType) {
        if (Config.gridEnable.equals("0")) {
            LogUtil.logger.debug(browserType + " has been initiated.");
            in.init(browserType);
            in.driver.get(Var.baseURL);
            in.driver.manage().window().maximize();
//			in.driver.findElement(By.id("overridelink")).click();

        } else if (Config.gridEnable.equals("1")) {
            if (browserType == BrowserType.CHROME) {
                openBrowser("CHROME");
            } else if (browserType == BrowserType.FIREFOX) {
                openBrowser("FIREFOX");
            } else if (browserType == BrowserType.IE) {
                openBrowser("INTERNET EXPLORER");


            }


        } else {
            org.testng.Assert.fail("gridEnable setting at config.XML has not been set.");
        }

    }


    public default void closeBrowser() {
        LogUtil.logger.debug("Browser has been closed.");
        in.driver.quit();

    }

    public default void openBrowser(String browserType, String platform, String nodeIP) {
        String browType = browserType.toUpperCase();
        if (Config.gridEnable.equals("0")) {
            openBrowser(BrowserType.valueOf(browserType.toUpperCase()));
            LogUtil.logger.info("Selenium Grid has been Disabled.");
        } else if (Config.gridEnable.equals("1")) {
            DesiredCapabilities capability = null;
            if (browType.equals("CHROME")) {
                capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            } else if (browType.equals("INTERNET EXPLORER") || browType.equals("IE")) {
                capability = DesiredCapabilities.internetExplorer();
                capability.setBrowserName("internet explorer");
                capability.setCapability("ie.ensureCleanSession", true);
                capability.setCapability("nativeEvents", true);
                if (Config.acceptSSL.equals("1")) {
                    capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    in.driver.navigate().to("javascript:document.getElementById('overridelink').click()");

                }
            } else if (browType.equals("FIREFOX")) {
                capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            }

            if (capability != null) {
                capability.setPlatform(Platform.valueOf(platform));

                try {
                    in.driver = new RemoteWebDriver(new URL(nodeIP), capability);
                } catch (MalformedURLException e) {
                    LogUtil.logger.error(e.getMessage());
                }
            } else {
                org.testng.Assert.fail("Browser Capabilities has not been set.");
            }

            in.driver.get(Var.baseURL);
            in.driver.manage().window().maximize();
        } else {
            org.testng.Assert.fail("gridEnable setting at config.XML has not been set.");
        }


    }

    public default void openBrowser(String browserType) {
        if (Config.gridEnable.equals("0")) {
            if (browserType.equals("internet explorer") || browserType.equals("INTERNET EXPLORER")) {
                openBrowser(BrowserType.IE);
            } else {
                openBrowser(BrowserType.valueOf(browserType.toUpperCase()));
            }
        } else if (Config.gridEnable.equals("1")) {
            openBrowser(browserType, Config.gridPlatform, Config.gridNodeIP);
            LogUtil.logger.info("Selenium Grid has been Enabled.");
        } else {
            org.testng.Assert.fail("gridEnable setting at config.XML has not been set.");
        }


    }

    public default void openBrowser() {
        if (Config.gridEnable.equals("1")) {
            openBrowser(Config.gridBrowserType, Config.gridPlatform, Config.gridNodeIP);
        } else if (Config.gridEnable.equals("0")) {
            openBrowser(Config.gridBrowserType);
        } else {
            org.testng.Assert.fail("gridEnable setting at config.XML has not been set.");
        }
    }




    public default void waitForLoad() {

        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(in.driver, 30);
        wait.until(pageLoadCondition);
        LogUtil.logger.debug("Browser (" + in.driver.getWindowHandle() + ") has waited for the page to load.");

    }


}