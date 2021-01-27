package Testcases.RailWay.register;

import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class TC07_CreateAccount extends CommonTestBase {

    String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    private String tmEmail = "thanh" + time + "@register.com";
    private String tmPassword = "pass123456";
    private String tmPassport = "pp123456789";

    RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");

        System.out.println("Go to register page");
        registerPage.gotoRegisterPage();

        System.out.println("Register new account");
        registerPage.fillData(tmEmail, tmPassword, tmPassword, tmPassport);
        registerPage.saveNewAccount(tmEmail,tmPassword,tmPassport);
        registerPage.clickRegisterButton();

        System.out.println("Check message");
        String actualMsg = registerPage.getSuccessMsg();
        String expectedMsg = registerPage.registrationConfirmedMsg();
        Assert.assertEquals(actualMsg, expectedMsg);

    }
}
