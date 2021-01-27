package Testcases.RailWay.login;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08_LoginWithNotActivatedAccount extends CommonTestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    String naUsername = loginPage.newAccountUsername();
    String naPassword = loginPage.newAccountPassword();

    @Test
    public void TC08() {
        System.out.println("TC08 - User can't login with an account hasn't been activated");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with just create account hasn't been activate");
        loginPage.login(naUsername, naPassword);

        System.out.println("Check login invalid");
        Boolean actualMsg = loginPage.checkLoginErrorMsg();
        Assert.assertTrue(actualMsg);

    }
}
