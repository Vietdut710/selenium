package Testcases.RailWay.login;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.RailWay.base.CommonTestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TC01_LoginWithValidAccount extends CommonTestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    public void TC01(){
        System.out.println("TC01 - User can log into Railway with valid username and password");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with valid username and password");
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Check logged on account");
        String actualMsg = loginPage.getWelcomeMassage();
        String expectedMsg="Welcome "+Constant.USERNAME;
        Assert.assertEquals(actualMsg,expectedMsg);

    }
}
