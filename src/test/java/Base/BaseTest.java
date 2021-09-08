package test.java.Base;

import main.java.base.functions.BrowserController;
import main.java.base.functions.TestResult;
import main.java.page.pages.InıtıalPages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends LoginPage implements BrowserController, TestResult {

    @BeforeTest
    public void beforeTest () {
        Login();
    }

    @AfterTest
    public void afterTest () {

        info("Close Browser");
        closeBrowser();
    }

}
