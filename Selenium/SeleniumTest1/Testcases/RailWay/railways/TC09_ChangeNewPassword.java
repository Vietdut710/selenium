package Testcases.RailWay.railways;

import Common.Constant.Constant;
import Common.Object.Account;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC09_ChangeNewPassword extends TestBase {


    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    Account account = Constant.account;

    private final String tmPassword = "pass123456";
    private final String tmPassport = "pp123456789";
    private final String tmNewPassword = "newpass123";

    @BeforeMethod
    public void beforeTest(){
        String tmEmail = "th" + Constant.randomUsername + "@cp.com";
        System.out.println("Pre-condition: Create new account");

        homePage.gotoRegisterPage();
        registerPage.createAccount(tmEmail,tmPassword,tmPassword,tmPassport);
    }

    @Test(dataProvider = "getDataForTest")
    public void TC09(Hashtable<String, String> data){
        System.out.println("TC09 - User can change password");

        System.out.println("Go to login page");
        registerPage.gotoLoginPage();

        System.out.println("Login with just create account");
        loginPage.login(Constant.account.getUsername(),Constant.account.getPassword());

        System.out.println("Go to change password page");
        homePage.gotoChangePasswordPage();

        System.out.println("Change a new password replace current password");
        changePasswordPage.changePassword(account, account.getPassword(),tmNewPassword);

        System.out.println("Check message");
        String actualMsg = changePasswordPage.getMsgSuccess();
        String expectedMsg = data.get("passwordChanged");
        Assert.assertEquals(actualMsg,expectedMsg);

    }
}
