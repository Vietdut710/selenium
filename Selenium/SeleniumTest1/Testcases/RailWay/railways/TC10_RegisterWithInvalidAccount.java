package Testcases.RailWay.railways;

import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Random;

public class TC10_RegisterWithInvalidAccount extends CommonTestBase{

    String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    private String tmEmail = "thanh" + time + "@register.com";
    private String tmPassword = "pass123456";
    private String tmPassport = "pp123456789";
    private String tmWrongPass = "Invalid pass";
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getDataForTest")
    public void TC10(Hashtable<String, String> data){
        System.out.println("TC10 - User can't create account with Confirm password is not the same with Password");

        System.out.println("Go to register page");
        registerPage.gotoRegisterPage();

        System.out.println("Register with confirm password is not the same with password");
        registerPage.fillData(tmEmail, tmPassword, tmWrongPass, tmPassport);
        registerPage.clickRegisterButton();

        System.out.println("Check message");
        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = data.get("InvalidRegister");
        Assert.assertEquals(actualMsg, expectedMsg);

    }
}
