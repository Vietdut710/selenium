package Testcases.RailWay.railways;

import PageObjects.Railway.*;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC01_LoginWithValidAccount extends TestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(dataProvider = "getDataForTest")
    public void TC01(Hashtable<String, String> data){
        System.out.println("TC01 - User can log into Railway with valid username and password");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with valid username and password");
        loginPage.login(data.get("username"), data.get("password"));

        System.out.println("Check logged on account");
        String actualMsg = loginPage.getWelcomeMassage();
        String expectedMsg="Welcome "+ data.get("username");
        Assert.assertEquals(actualMsg,expectedMsg);

    }
}
