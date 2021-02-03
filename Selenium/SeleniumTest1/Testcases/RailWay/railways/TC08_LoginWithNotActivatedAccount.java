package Testcases.RailWay.railways;

import Common.Constant.Constant;
import Common.Object.Account;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC08_LoginWithNotActivatedAccount extends TestBase {

    private final String tmPassword = "pass123456";
    private final String tmPassport = "pp123456789";
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    Account account = Constant.account;

    @BeforeMethod
    public void beforeTest() {
        String tmEmail = "th" + Constant.randomUsername + "@rg.com";
        System.out.println("Pre-condition: Create new account");

        homePage.gotoRegisterPage();
        registerPage.createAccount(tmEmail, tmPassword, tmPassword, tmPassport);
    }

    @Test(dataProvider = "getDataForTest")
    public void TC08(Hashtable<String, String> data) {
        System.out.println("TC08 - User can't login with an account hasn't been activated");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with just create account hasn't been activate");
        loginPage.login(Constant.account.getUsername(), Constant.account.getPassword());

        System.out.println("Check login invalid");
        Boolean actualMsg = loginPage.checkLoginErrorMsg();
        Assert.assertTrue(actualMsg);

    }
}
