package Testcases.RailWay.railways;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_LoginWithValidAccount extends CommonTestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(dataProvider = "login")
    public void TC01(String email,String password){
        System.out.println("TC01 - User can log into Railway with valid username and password");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with valid username and password");
        loginPage.login(email,password);

        System.out.println("Check logged on account");
        String actualMsg = loginPage.getWelcomeMassage();
        String expectedMsg="Welcome "+email;
        Assert.assertEquals(actualMsg,expectedMsg);

    }
}
