package Testcases.RailWay.changepassword;

import Common.Constant.Constant;
import DataObject.Account;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TC09_ChangeNewPassword extends CommonTestBase {

    String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    Account account = Constant.account;

    private final String tmEmail = "th" + time + "@cp.com";
    private final String tmPassword = "pass123456";
    private final String tmPassport = "pp123456789";
    private final String tmNewPassword = "newpass123";

    @BeforeMethod
    public void beforeTest(){
        System.out.println("Pre-condition: Create new account");
        homePage.gotoRegisterPage();
        registerPage.createAccount(account,tmEmail,tmPassword,tmPassword,tmPassport);
    }

    @Test
    public void TC09(){
        System.out.println("TC09 - User can change password");

        System.out.println("Go to login page");
        registerPage.gotoLoginPage();

        System.out.println("Login with just create account");
        loginPage.login(account.getUsername(),account.getPassword());

        System.out.println(account.getUsername());
        System.out.println(account.getPassword());
        System.out.println(account.getPassport());

        System.out.println("Go to change password page");
        homePage.gotoChangePasswordPage();

        System.out.println("Change a new password replace current password");
        changePasswordPage.changePassword(account, account.getPassword(),tmNewPassword);




        System.out.println("Check message");
        String actualMsg = changePasswordPage.getMsgSuccess();
        String expectedMsg = changePasswordPage.changePasswordSuccessfully();
        Assert.assertEquals(actualMsg,expectedMsg);

    }
}
