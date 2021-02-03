package Testcases.RailWay.railways;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC02_LoginWithBlankUsername extends TestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    private String tmBlankUsername = "";

    @Test(dataProvider = "getDataForTest")
    public void TC02(Hashtable<String, String> data) {
        System.out.println("TC02 - User can't login with blank Username textbox");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with blank username textbox");
        loginPage.login(tmBlankUsername, Constant.PASSWORD);

        System.out.println("Check message");
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = data.get("msg_BlankLogin");
        Assert.assertEquals(actualMsg, expectedMsg);

    }
}
