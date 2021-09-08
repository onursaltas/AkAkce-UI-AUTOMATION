package main.java.base.functions;

import main.java.base.config.Config;
import main.java.base.config.LogUtil;
import main.java.base.init.BrowserType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.testng.Assert.assertEquals;

/**
 * @author e00426240
 * @brief Navigation Controller functions. Powered by Selenium.
 */
public interface NavigationController extends TestResult, BrowserController {


    public default void waitAndClick(String xPATH) {
        waitAndClick(By.xpath(xPATH));
    }


    public default void waitAndClick(By by) {
        checkWebElementCount(by);
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        in.driver.findElement(by).click();

    }


    public default void containsTextClick(String text) {

        // Wait until upload button is visible
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), '" + text + "')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + text + "')]")));
        in.driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]")).click();
    }


    public default void startsWithTextClick(String text) {
        // Wait until upload button is enabled and clickable
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[starts-with(text(), '" + text + "')]")));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[starts-with(text(), '" + text + "')]")));
        in.driver.findElement(By.xpath("//*[starts-with(text(), '" + text + "')]")).click();
    }

    /**
     * @param text Takes the text of the WebElement.
     * @brief Finds the WebElement by it's text and clicks to it.
     */
    public default void findByTextClick(String text) {
        // Wait until upload button is enabled and clickable
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + text + "']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + text + "']")));
        in.driver.findElement(By.xpath("//*[text()='" + text + "']")).click();
    }


    public default void waitAndSendKeys(String xPATH, String input) {
        waitAndSendKeys(By.xpath(xPATH), input);
    }


    public default void waitAndSendKeys(By by, String input) {
        checkWebElementCount(by);
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        By webElem = by;
        // Wait until element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.presenceOfElementLocated(webElem));
        in.driver.findElement(webElem).sendKeys(input);
    }

    public default void acceptWindowAlert() {
        in.driver.switchTo().alert().accept();
        in.driver.switchTo().activeElement();
    }

    public default void selectWindow(String title) {
        for (String winHandle : in.driver.getWindowHandles()) {
            if (in.driver.switchTo().window(winHandle).getTitle().equals(title)) {
                return;
            }
        }
        Assert.fail("Window with title: " + title + "cannot be found.");
    }


    public default String getWindowHandle() {
        return in.driver.getWindowHandle();
    }


    public default void switchToWindow(String windowHandle) {
        in.driver.switchTo().window(windowHandle);
    }


    public default void switchToChildWindow() {

        for (String winHandle : in.driver.getWindowHandles()) {
            in.driver.switchTo().window(winHandle);
        }

    }

    public default String getText(By by) {
        checkWebElementCount(by);
        String text = "";

        // Wait until element is visible
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        text = in.driver.findElement(by).getText();

        return text;
    }

    public default String getText(String xPATH) {
        return getText(By.xpath(xPATH));
    }


    public default void hoverTo(By by) {
        checkWebElementCount(by);
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        // Wait until element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        in.actions = new Actions(in.driver);
        WebElement webelem = in.driver.findElement(by);
        in.actions.moveToElement(webelem).build().perform();

    }


    public default void hoverTo(String xPATH) {
        hoverTo(By.xpath(xPATH));
    }


    public default void hoverToWithTime(By by, long time) {
        checkWebElementCount(by);
        WebDriverWait wait = new WebDriverWait(in.driver, Config.wait);
        // Wait until element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        in.actions = new Actions(in.driver);
        WebElement webelem = in.driver.findElement(by);
        in.actions.moveToElement(webelem);
        in.actions.build().perform();
        LogUtil.logger.info("Succesfully performed hover action");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            LogUtil.logger.error(e.getMessage());
        }
        LogUtil.logger.info("It is waiting for given time");

    }


    public default void rightClick(String xPATH) {
        rightClick(By.xpath(xPATH));
    }


    public default void rightClick(By by) {
        checkWebElementCount(by);
        in.actions = new Actions(in.driver).contextClick(in.driver.findElement(by));
        in.actions.build().perform();

        LogUtil.logger.error("Sucessfully Right clicked on the element");
    }


    public default void doubleClick(String xPATH) {
        doubleClick(By.xpath(xPATH));
    }


    public default void doubleClick(By by) {
        checkWebElementCount(by);
        (new Actions(in.driver)).doubleClick(in.driver.findElement(by)).build().perform();
    }


    public default String getElementAttribute(String xPATH, String attribute) {
        return getElementAttribute(By.xpath(xPATH), attribute);
    }


    public default String getElementAttribute(By by, String attribute) {
        checkWebElementCount(by);
        return in.driver.findElement(by).getAttribute(attribute);
    }


    public default void setElementAttribute(String xPATH, String attributeName, String attributeValue) {
        setElementAttribute(By.xpath(xPATH), attributeName, attributeValue);
    }


    public default void setElementAttribute(By by, String attributeName, String attributeValue) {

        WebElement element = in.driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) in.driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName,
                attributeValue);

    }


    public default void getUrl(String url) {
        in.driver.get(url);
        waitForLoad();
    }


    public default void selectItemFromDropDown(String xPATH, String optionValue) {
        Select dropdown = new Select(in.driver.findElement(By.xpath(xPATH)));
        dropdown.selectByVisibleText(optionValue);
    }


}
