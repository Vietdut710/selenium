package Testcases.RailWay.railways;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC05_LoginSeveralTimes extends TestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    private final String tmInvalidPassword = "Invalid Password";

    @Test(dataProvider = "getDataForTest")
    public void TC05(Hashtable<String, String> data) {
        System.out.println("TC05 - System shows message when user enters wrong password several times");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login 3 times with invalid password");
        loginPage.loginMultiTimes(Constant.USERNAME, tmInvalidPassword, 3);

        System.out.println("Check message");
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = data.get("msg_loginSeveralTimes");
        Assert.assertEquals(actualMsg, expectedMsg);

    }
}
