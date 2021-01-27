package Testcases.RailWay.railways;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_LoginSeveralTimes extends CommonTestBase {

    private String tmInvalidPassword = "Invalid Password";

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(dataProvider = "TC05")
    public void TC05(String expected){
        System.out.println("TC05 - System shows message when user enters wrong password several times");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login 3 times with invalid password");
        loginPage.loginMultiTimes(Constant.USERNAME,tmInvalidPassword, 3);

        System.out.println("Check message");
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = expected;
        Assert.assertEquals(actualMsg,expectedMsg);

    }
}
