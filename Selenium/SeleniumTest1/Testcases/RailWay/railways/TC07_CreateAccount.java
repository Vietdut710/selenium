package Testcases.RailWay.railways;

import Common.Constant.Constant;
import DataObject.Account;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TC07_CreateAccount extends CommonTestBase {

    String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    private final String tmEmail = "thanh" + time + "@register.com";
    private final String Password = "pass123456";
    private final String Passport = "pp123456789";
    Account account = Constant.account;

    RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");

        System.out.println("Go to register page");
        registerPage.gotoRegisterPage();

        System.out.println("Register new account");
        registerPage.createAccount(account ,tmEmail, Password, Password, Passport);

        System.out.println(account.getUsername());
        System.out.println(account.getPassword());
        System.out.println(account.getPassport());

        System.out.println("Check message");
        String actualMsg = registerPage.getSuccessMsg();
        String expectedMsg = registerPage.registrationConfirmedMsg();
        Assert.assertEquals(actualMsg, expectedMsg);

    }
}
