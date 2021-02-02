package Testcases.RailWay.railways;

import Common.Constant.Constant;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC10_RegisterWithInvalidAccount extends TestBase {

    private String tmPassword = "pass123456";
    private String tmPassport = "pp123456789";
    private String tmWrongPass = "Invalid pass";
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getDataForTest")
    public void TC10(Hashtable<String, String> data){
        String tmEmail = "thanh" + Constant.randomUsername + "@register.com";
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
