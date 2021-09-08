package main.java.base.functions;

import main.java.base.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public interface AssertionFunctions extends TestResult, NavigationController, BrowserController {



    public default void waitForElementAppeared(String xPATH) {
        waitForElementAppeared(By.xpath(xPATH));
    }


    public default void waitForElementAppeared(By by) {
        checkWebElementCount(by);
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public default void waitForElementDisappeared(String xPATH) {
        waitForElementDisappeared(By.xpath(xPATH));
    }


    public default void waitForElementDisappeared(By by) {
        checkWebElementCount(by);
        waitForElementAppeared(by);
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public default void textToBePresentInElementLocated(String xPATH, String text) {
        textToBePresentInElementLocated(By.xpath(xPATH), text);
    }


    public default void textToBePresentInElementLocated(By by, String text) {
        checkWebElementCount(by);
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
        assertEquals(getText(by), text);
    }


    public default void assertAttribute(By by, String attributeName, String expectedAttribute) {
        assertEquals(getElementAttribute(by, attributeName), expectedAttribute);
    }


    public default void assertAttribute(String xPATH, String attributeName, String expectedAttribute) {
        assertAttribute(By.xpath(xPATH), attributeName, expectedAttribute);
    }


    public default void assertTextOfWebElement(By by, String expected) {
        assertEquals(getText(by), expected);
    }


    public default void assertTextOfWebElement(String xPATH, String expected) {
        assertTextOfWebElement(By.xpath(xPATH), expected);
    }


    public default boolean isElementClickable(By by) {
        return in.driver.findElement(by).isEnabled();
    }


    public default boolean isElementClickable(String xPATH) {
        return isElementClickable(By.xpath(xPATH));
    }


}
