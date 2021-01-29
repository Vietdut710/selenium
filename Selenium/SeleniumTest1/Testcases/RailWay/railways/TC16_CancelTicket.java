package Testcases.RailWay.railways;

import Common.Constant.Constant;
import DataObject.Account;
import PageObjects.Railway.*;

import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

public class TC16_CancelTicket extends CommonTestBase {

    String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    Account account = Constant.account;

    private final String tmEmail = "th" + time + "@cc.com";
    private final String tmPassword = "pass123456";
    private final String tmPassport = "pp123456789";


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition : Create account");

        homePage.gotoRegisterPage();
        registerPage.createAccount(account, tmEmail, tmPassword, tmPassword, tmPassport);
    }

    @Test(dataProvider = "getDataForTest")
    public void TC16(Hashtable<String, String> data){
        System.out.println("TC16-User can cancel a ticket");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with just create account");
        loginPage.login(account.getUsername(),account.getPassword());

        System.out.println("Go to Book ticket page");
        homePage.gotoBookTicketPage();

        System.out.println("Book ticket");
        bookTicketPage.bookTicket(data.get("departDate"), data.get("departFrom"), data.get("arriveAt"), data.get("seatType"),data.get("ticketAmount") );

        System.out.println("Go to my ticket page");
        bookTicketPage.gotoMyTicketPage();

        System.out.println("Cancel just booked ticket");
        myTicketPage.cancelTicket(data.get("departDate"), data.get("departFrom"), data.get("arriveAt"), data.get("seatType"),data.get("ticketAmount"));

        System.out.println("Check ticket not exist");
        Boolean actualResult = myTicketPage.checkTicketExist(data.get("departDate"), data.get("departFrom"), data.get("arriveAt"), data.get("seatType"),data.get("ticketAmount") );

        Assert.assertFalse(actualResult);
    }
}
