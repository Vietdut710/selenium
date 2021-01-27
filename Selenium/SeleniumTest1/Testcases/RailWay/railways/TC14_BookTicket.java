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


public class TC14_BookTicket extends CommonTestBase {

    String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    Account account = Constant.account;

    private final String tmEmail = "th" + time + "@bt.com";
    private final String tmPassword = "pass123456";
    private final String tmPassport = "pp123456789";

    private final String departDate = bookTicketPage.departDate();
    private final String departFrom = bookTicketPage.departStation();
    private final String arriveAt = bookTicketPage.arriveStation();
    private final String seatType = bookTicketPage.seatType();
    private final String ticketAmount = bookTicketPage.ticketAmount();

    @BeforeMethod
    public void beforeTest(){
        System.out.println("Pre-condition: Create new account");
        homePage.gotoRegisterPage();
        registerPage.createAccount(account,tmEmail,tmPassword,tmPassword,tmPassport);
    }

    @Test
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with just created account");
        loginPage.login(account.getUsername(), account.getPassword());

        System.out.println("Go to Book ticket page");
        homePage.gotoBookTicketPage();

        System.out.println("Book ticket");
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);

        System.out.println("Check booked ticket");
        String actualMsg = bookTicketPage.getBookedTicketTitle();
        String expectedMsg = bookTicketPage.bookedTicketTitle();
        boolean actualTicket = bookTicketPage.checkTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);
        Assert.assertEquals(actualMsg, expectedMsg);
        Assert.assertTrue(actualTicket);
    }
}
