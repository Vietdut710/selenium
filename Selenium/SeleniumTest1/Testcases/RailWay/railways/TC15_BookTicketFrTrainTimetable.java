package Testcases.RailWay.railways;

import Common.Constant.Constant;
import DataObject.Account;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import PageObjects.Railway.TimetablePage;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

public class TC15_BookTicketFrTrainTimetable extends CommonTestBase {

    String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    Account account = Constant.account;

    private final String tmEmail = "th" + time + "@tbl.com";
    private final String tmPassword = "pass123456";
    private final String tmPassport = "pp123456789";

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition : Create account");

        homePage.gotoRegisterPage();
        registerPage.createAccount(account, tmEmail, tmPassword, tmPassword, tmPassport);
    }

    @Test(dataProvider = "getDataForTest")
    public void TC15(Hashtable<String, String> data){
        System.out.println("TC15 - User can open Book ticket page by clicking on Book ticket link in Train timetable page");

        System.out.println("login");
        homePage.gotoLoginPage();
        loginPage.login(account.getUsername(),account.getPassword());

        System.out.println("Go to Timetable page");
        homePage.gotoTimetablePage();

        System.out.println("Click book ticket link");
        timetablePage.chooseTrip(data.get("departFrom"),data.get("departArrive"));

        System.out.println("Check info of ticket");
        boolean actualTicket = timetablePage.checkSelectedTicket(data.get("departFrom"),data.get("departArrive"));
        Assert.assertTrue(actualTicket);

    }
}
