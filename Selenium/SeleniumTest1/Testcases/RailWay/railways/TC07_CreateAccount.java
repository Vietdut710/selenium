package Testcases.RailWay.railways;

import Common.Constant.Constant;
import Common.Object.Account;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Hashtable;

public class TC07_CreateAccount extends TestBase {



    private final String Password = "pass123456";
    private final String Passport = "pp123456789";
    Account account = Constant.account;

    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getDataForTest")
    public void TC07(Hashtable<String, String> data) {
        String tmEmail = "thanh" + Constant.randomUsername + "@rr.com";
        System.out.println("TC07 - User can create new account");

        System.out.println("Go to register page");
        registerPage.gotoRegisterPage();

        System.out.println("Register new account");
        registerPage.createAccount(tmEmail, Password, Password, Passport);

        System.out.println("Check message");
        String actualMsg = registerPage.getSuccessMsg();
        String expectedMsg = data.get("registrationConfirmed");
        Assert.assertEquals(actualMsg, expectedMsg);

    }
}
