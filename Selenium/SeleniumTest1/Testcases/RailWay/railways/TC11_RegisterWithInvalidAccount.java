package Testcases.RailWay.railways;

import Common.Constant.Constant;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC11_RegisterWithInvalidAccount extends TestBase {

    private String tmPassword = "pass123456";
    private String tmBlankBox = "";
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getDataForTest")
    public void TC11(Hashtable<String, String> data){
        String tmEmail = "thanh" + Constant.randomUsername + "@register.com";
        System.out.println("TC11 - User can't create account while password and PID fields are empty");

        System.out.println("Go to register page");
        registerPage.gotoRegisterPage();

        System.out.println("Register with PID field , password are empty");
        registerPage.fillData(tmEmail, tmBlankBox, tmPassword, tmBlankBox);
        registerPage.clickRegisterButton();

        System.out.println("Check message");
        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = data.get("InvalidRegister");
        String actualPasswordMsg =registerPage.getPasswordFieldMsg();
        String expectedPasswordMsg =data.get("PasswordLength");
        String actualPassportMsg = registerPage.getPassportFieldMsg();
        String expectedPassportMsg =data.get("IDLength");

        Assert.assertEquals(actualMsg, expectedMsg);
        Assert.assertEquals(actualPasswordMsg,expectedPasswordMsg);
        Assert.assertEquals(actualPassportMsg,expectedPassportMsg);

    }
}
