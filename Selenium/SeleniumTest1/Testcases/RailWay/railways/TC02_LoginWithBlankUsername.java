package Testcases.RailWay.railways;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class TC02_LoginWithBlankUsername extends CommonTestBase {

    private String tmBlankUsername = "";

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(dataProvider = "TC02")
    public void TC02(String expected){
        System.out.println("TC02 - User can't login with blank Username textbox");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with blank username textbox");
        loginPage.login(tmBlankUsername, Constant.PASSWORD);

        System.out.println("Check message");
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = expected;
        Assert.assertEquals(actualMsg,expectedMsg);

    }
}
