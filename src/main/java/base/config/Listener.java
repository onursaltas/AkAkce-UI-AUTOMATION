package main.java.base.config;

import io.qameta.allure.Attachment;
import main.java.base.functions.BrowserController;
import main.java.base.functions.GetClassName;
import main.java.base.variables.Var;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listener implements ITestListener, BrowserController, IInvokedMethodListener {

    @Override
    public void onTestStart(ITestResult result) {
        // LogUtil.logger.debug("Test Case " + result.getName() + " has been started.");
        GetClassName.setTestCaseName(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Var.testResult = "SUCCESS";
        // LogUtil.logger.debug("Test Case" + result.getName() + " has been
        // successful.");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Var.testResult = "FAILURE";
        printTestResults(result);
        in.testResult = false;
        LogUtil.logger.info("----testFailure operation begins----");
        final String testCaseName = GetClassName.getTestCaseName();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String snapShotPath = Config.failurelogPath + testCaseName + "//" + timeStamp + Config.failureScreenShotName;
        String logPath = Config.failurelogFilePath + testCaseName + "\\\\" + timeStamp + Config.failureLogName;
        LogUtil.logger.error("Log will be written as " + logPath);
        LogUtil.logger.error("Snapshot will be saved as " + snapShotPath);

//		try {
//			attachFailed();
//		} catch (NoSuchSessionException | NullPointerException e) {
//			LogUtil.logger.info("Cannot take screenshot due to driver has been called after quit.");
//			return;
//		}
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Var.testResult = "SKIPPED";
//		LogUtil.logger.debug("Test Case" + result.getName() + " has been skipped.");
        try {
            attachScreenshot();
        } catch (NoSuchSessionException | NullPointerException e) {
            LogUtil.logger.info("Cannot take screenshot due to driver has been called after quit.");
            return;
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Var.testResult = "PARTIAL SUCCESS";

    }

    @Override
    public void onStart(ITestContext context) {
     /*   // ---------CONFIG SETTINGS FOR CI---------------
        String configCIPath = "./configci.xml";
        Config.gridEnable = XmlFileParse.xmlFileParse("gridEnable", configCIPath);
        Config.gridPlatform = XmlFileParse.xmlFileParse("gridPlatform", configCIPath);
        Config.gridBrowserType = XmlFileParse.xmlFileParse("gridBrowserType", configCIPath);
        Config.gridNodeIP = XmlFileParse.xmlFileParse("gridNodeIP", configCIPath);
        // ---------CONFIG SETTINGS FOR CI END-----------
    */
        // ---------VARIABLES SETTINGS FOR CI------------
        String varCIPath = "./varci.xml";
        Var.downloadsFolder = XmlFileParse.xmlFileParse("downloadsFolder", varCIPath);
        Var.userName = XmlFileParse.xmlFileParse("userName", varCIPath);
        Var.password = XmlFileParse.xmlFileParse("password", varCIPath);
        Var.projectPath = XmlFileParse.xmlFileParse("projectPath", varCIPath);
        // ---------VARIABLES SETTINGS FOR CI END------------
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    private void printTestResults(ITestResult result) {

        LogUtil.logger.info("Test Method resides in " + result.getTestClass().getName(), true);

        if (result.getParameters().length != 0) {

            String params = null;

            for (Object parameter : result.getParameters()) {

                params += parameter.toString() + ",";

            }

            LogUtil.logger.error("Test Method had the following parameters : " + params, true);

        }

        String status = null;

        switch (result.getStatus()) {

            case ITestResult.SUCCESS:

                status = "Pass";

                break;

            case ITestResult.FAILURE:

                status = "Failed";
                LogUtil.logger
                        .error("Test " + result.getTestClass().getName() + " failed, error: " + result.getThrowable());
                StringWriter sw = new StringWriter();
                result.getThrowable().printStackTrace(new PrintWriter(sw));
                String exceptionDetails = sw.toString();
                LogUtil.logger.error("Test " + result.getTestClass().getName() + "\n failed, error:\n " + exceptionDetails);

                break;

            case ITestResult.SKIP:

                status = "Skipped";

        }

        LogUtil.logger.info("Test Status: " + status, true);

    }

    @Attachment(type = "image/png")
    private byte[] attachScreenshot() {
        System.out.println("Screenshot taken.");
        return ((TakesScreenshot) in.driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
        try {
            attachScreenshot();
        } catch (NoSuchSessionException | NullPointerException e) {
            LogUtil.logger.info("Cannot take screenshot due to driver has been called after quit.");
            return;
        } finally {

            if (arg1.getName() == "afterMethod") {
                String[] className = arg0.getTestMethod().toString().split("\\.");
                LogUtil.logger.info("ENDED: " + className[0] + " - " + Var.testResult);
                LogUtil.logger.info(
                        "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
            }
        }
    }

    @Override
    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
        if (arg1.getName() == "beforeMethod") {
            LogUtil.logger.info(
                    "+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + ");
            String[] className = arg0.getTestMethod().toString().split("\\.");
            LogUtil.logger.info("STARTED: " + className[0]);
        }
    }

}