package Testcases.RailWay.railways;

import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class TC10_TC11_RegisterWithInvalidAccount extends CommonTestBase{

    String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    private String tmEmail = "thanh" + time + "@register.com";
    private String tmPassword = "pass123456";
    private String tmPassport = "pp123456789";
    private String tmWrongPass = "Invalid pass";
    private String tmBlankBox = "";
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "TC10")
    public void TC10(String expected){
        System.out.println("TC10 - User can't create account with Confirm password is not the same with Password");

        System.out.println("Go to register page");
        registerPage.gotoRegisterPage();

        System.out.println("Register with confirm password is not the same with password");
        registerPage.fillData(tmEmail, tmPassword, tmWrongPass, tmPassport);
        registerPage.clickRegisterButton();

        System.out.println("Check message");
        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = expected;
        Assert.assertEquals(actualMsg, expectedMsg);

    }

    @Test(dataProvider = "TC11")
    public void TC11(String registerExpected,String pwdExpected,String idExpected){
        System.out.println("TC11 - User can't create account while password and PID fields are empty");

        System.out.println("Go to register page");
        registerPage.gotoRegisterPage();

        System.out.println("Register with PID field , password are empty");
        registerPage.fillData(tmEmail, tmBlankBox, tmPassword, tmBlankBox);
        registerPage.clickRegisterButton();

        System.out.println("Check message");
        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = registerExpected;
        String actualPasswordMsg =registerPage.getPasswordFieldMsg();
        String expectedPasswordMsg =pwdExpected;
        String actualPassportMsg = registerPage.getPassportFieldMsg();
        String expectedPassportMsg =idExpected;

        Assert.assertEquals(actualMsg, expectedMsg);
        Assert.assertEquals(actualPasswordMsg,expectedPasswordMsg);
        Assert.assertEquals(actualPassportMsg,expectedPassportMsg);

    }
}
