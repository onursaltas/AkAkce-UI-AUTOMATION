package main.java.base.functions;

import io.qameta.allure.Step;
import junit.framework.ComparisonFailure;
import main.java.base.config.Config;
import main.java.base.config.LogUtil;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface TestResult extends BrowserController {


    @Deprecated
    public default void testFailure(Object error) {
        in.testResult = false;
        LogUtil.logger.info("----testFailure operation begins----");
        final String testCaseName = GetClassName.getTestCaseName();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String snapShotPath = Config.failurelogPath + testCaseName + "//" + timeStamp + Config.failureScreenShotName;
        String logPath = Config.failurelogFilePath + testCaseName + "//" + timeStamp + Config.failureLogName;
        LogUtil.logger.info("Log will be written as " + logPath);
        LogUtil.logger.info("Snapshot will be saved as " + snapShotPath);

        // -----Take Screen shot of failure window-----
        try {
            Common.takeSnapShot(in.driver, snapShotPath);
        } catch (Exception e1) {
            LogUtil.logger.error(e1.getStackTrace());
        }


        if (error instanceof AssertionError) {
            LogUtil.logger.error(((AssertionError) error).getMessage());
        } else if (error instanceof TimeoutException) {
            LogUtil.logger.error(((WebDriverException) error).getMessage());
        } else if (error instanceof ElementNotVisibleException) {
            LogUtil.logger.error(((ElementNotVisibleException) error).getMessage());
        } else if (error instanceof ElementNotSelectableException) {
            LogUtil.logger.error(((ElementNotSelectableException) error).getMessage());
        } else if (error instanceof StaleElementReferenceException) {
            LogUtil.logger.error(((StaleElementReferenceException) error).getMessage());
        } else if (error instanceof NoSuchElementException) {
            LogUtil.logger.error(((NoSuchElementException) error).getMessage());
        } else if (error instanceof NullPointerException) {
            LogUtil.logger.error(((NullPointerException) error).getStackTrace());
        } else if (error instanceof NoSuchWindowException) {
            LogUtil.logger.error(((NoSuchWindowException) error).getMessage());
        } else if (error instanceof AWTException) {
            LogUtil.logger.error(((AWTException) error).getMessage());
        } else if (error instanceof SQLException) {
            LogUtil.logger.error(((SQLException) error).getMessage());
        } else if (error instanceof ComparisonFailure) {
            LogUtil.logger.error(((ComparisonFailure) error).getMessage());
        } else if (error instanceof IOException) {
            LogUtil.logger.error(((IOException) error).getMessage());
        } else if (error instanceof InvalidSelectorException) {
            LogUtil.logger.error(((InvalidSelectorException) error).getMessage());
        } else if (error instanceof NoSuchFrameException) {
            LogUtil.logger.error(((NoSuchFrameException) error).getMessage());
        }

        try {
            Assert.fail();
        } catch (AssertionError e) {
            String stackTrace = Common.throwablesToString(e);
            Common.writeFile(logPath, stackTrace);
            Assert.fail();
        }
        LogUtil.logger.info("----testFailure operation ends----");
    }

    @Step("{log}")
    public default void info(String log) {
        LogUtil.logger.info(log);
        Reporter.log(log);
    }

    @Deprecated
    public default void takeScreenShot(String filePath) {
        try {
            in.robot = new Robot();
            String fileName = filePath;
            String format = "jpg";

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = in.robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(fileName));

            LogUtil.logger.debug("A full screenshot saved!");
        } catch (AWTException | IOException ex) {
            testFailure(ex);
        }
    }

    public default void checkWebElementCount(By by) {
        try {
            if (in.driver.findElements(by).size() > 1) {
                Assert.fail("There are more than one WebElement of " + by.toString() + " . There has to be one.");

            }
        } catch (InvalidSelectorException e) {
            Assert.fail(e.getMessage());
        }
    }
}
