package main.java.page.pages.InıtıalPages;

import main.java.base.functions.AssertionFunctions;
import main.java.base.functions.BrowserController;
import main.java.base.functions.NavigationController;
import main.java.base.init.BrowserType;
import main.java.base.variables.Var;
import main.java.page.constants.InıtıalConstants.LoginPageConstants;

public class LoginPage implements BrowserController, NavigationController, AssertionFunctions, LoginPageConstants {

    BrowserType browserType =BrowserType.CHROME;
    public void Login() {

        info("open browser");
        openBrowser(browserType);

        info("Verify Login Page open");


        info("Enter User and Password");
        waitAndSendKeys(usernameTextBox, Var.userName);
        waitAndSendKeys(passwordTextBox, Var.password);

        info("Click login button");
        waitAndClick(loginButton);

        info("Verify, Login Successful");
       // waitForElementAppeared("//a[@title='Hesabım']//following::ul[1]//child::i[@title='Ahmey K.']");

    }

}
