package Testcases.RailWay.railways;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC06_HomeLogged extends CommonTestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(dataProvider = "getDataForTest")
    public void TC06(Hashtable<String, String> data){
        System.out.println("TC06 - Additional pages display once user logged in");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with valid account");
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Check home page the user logged");
        boolean actualHome = homePage.checkLoginHomePage();

        System.out.println("Check my ticket page is displayed");
        myTicketPage.gotoMyTicketPage();
        String actualMyTicketTitle = myTicketPage.getMyTicketTitle();
        String expectedMyTicketTitle = data.get("myTicketPage");

        System.out.println("Check change password page is displayed");
        changePasswordPage.gotoChangePasswordPage();
        String actualChangePasswordTitle = changePasswordPage.getChangePasswordTitle();
        String expectedChangePasswordTitle = data.get("changePassword");

        Assert.assertTrue(actualHome);
        Assert.assertEquals(actualMyTicketTitle,expectedMyTicketTitle);
        Assert.assertEquals(actualChangePasswordTitle,expectedChangePasswordTitle);

    }
}
