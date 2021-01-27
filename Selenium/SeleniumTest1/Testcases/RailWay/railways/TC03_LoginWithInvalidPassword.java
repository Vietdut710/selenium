package Testcases.RailWay.railways;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_LoginWithInvalidPassword extends CommonTestBase {

    private String tmInvalidPassword = "Invalid Password";
    private String tmBlankUsername = "";

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(dataProvider = "TC03")
    public void TC03(String expected){
        System.out.println("TC03 - User cannot log into Railway with invalid password");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with invalid password");
        loginPage.login(Constant.USERNAME,tmInvalidPassword);

        System.out.println("Check message");
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = expected;
        Assert.assertEquals(actualMsg,expectedMsg);

    }

}
