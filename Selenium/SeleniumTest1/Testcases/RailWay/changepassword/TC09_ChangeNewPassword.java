package Testcases.RailWay.changepassword;

import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TC09_ChangeNewPassword extends CommonTestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    private String naUsername = loginPage.newAccountUsername();
    private String naPassword = loginPage.newAccountPassword();
    private String tmNewPassword = changePasswordPage.newPassword();

    @Test
    public void TC09(){
        System.out.println("TC09 - User can change password");

        System.out.println("Go to login page");
        registerPage.gotoLoginPage();

        System.out.println("Login with just create account");
        loginPage.login(naUsername,naPassword);

        System.out.println("Go to change password page");
        homePage.gotoChangePasswordPage();

        System.out.println("Change a new password replace current password");
        changePasswordPage.changePassword(naPassword,tmNewPassword);
        changePasswordPage.changeJsonPassword(tmNewPassword);

        System.out.println("Check message");
        String actualMsg = changePasswordPage.getMsgSuccess();
        String expectedMsg = changePasswordPage.changePasswordSuccessfully();
        Assert.assertEquals(actualMsg,expectedMsg);

    }
}
