package Testcases.RailWay.railways;

import Common.Constant.Constant;
import Common.Object.Account;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import PageObjects.Railway.TimetablePage;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC15_BookTicketFrTrainTimetable extends TestBase {


    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    Account account = Constant.account;

    private final String tmPassword = "pass123456";
    private final String tmPassport = "pp123456789";

    @BeforeMethod
    public void beforeMethod(){
        String tmEmail = "th" + Constant.randomUsername + "@tbl.com";
        System.out.println("Pre-condition : Create account");

        homePage.gotoRegisterPage();
        registerPage.createAccount(tmEmail, tmPassword, tmPassword, tmPassport);
    }

    @Test(dataProvider = "getDataForTest")
    public void TC15(Hashtable<String, String> data){
        System.out.println("TC15 - User can open Book ticket page by clicking on Book ticket link in Train timetable page");

        System.out.println("login");
        homePage.gotoLoginPage();
        loginPage.login(Constant.account.getUsername(),Constant.account.getPassword());

        System.out.println("Go to Timetable page");
        homePage.gotoTimetablePage();

        System.out.println("Click book ticket link");
        timetablePage.chooseTrip(data.get("departFrom"),data.get("departArrive"));

        System.out.println("Check info of ticket");
        boolean actualTicket = timetablePage.checkSelectedTicket();
        Assert.assertTrue(actualTicket);

    }
}
