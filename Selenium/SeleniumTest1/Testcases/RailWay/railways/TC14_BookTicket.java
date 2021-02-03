package Testcases.RailWay.railways;

import Common.Constant.Constant;
import Common.Object.Account;
import Common.Object.TicketInfo;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.Hashtable;


public class TC14_BookTicket extends TestBase {

    private final String tmPassword = "pass123456";
    private final String tmPassport = "pp123456789";
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();



    @BeforeMethod
    public void beforeTest() {
        String tmEmail = "th" + Constant.randomUsername + "@bt.com";
        System.out.println("Pre-condition: Create new account");
        homePage.gotoRegisterPage();
        registerPage.createAccount(tmEmail, tmPassword, tmPassword, tmPassport);
    }

    @Test(dataProvider = "getDataForTest")
    public void TC14(Hashtable<String, String> data) {
        System.out.println("TC14 - User can book 1 ticket at a time");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with just created account");
        loginPage.login(Constant.account.getUsername(), Constant.account.getPassword());

        System.out.println("Go to Book ticket page");
        homePage.gotoBookTicketPage();

        System.out.println("Book ticket");
        bookTicketPage.bookTicket(data.get("departDate"), data.get("departFrom"), data.get("arriveAt"), data.get("seatType"), data.get("ticketAmount"));

        System.out.println("Check booked ticket");
        String actualMsg = bookTicketPage.getBookedTicketTitle();
        String expectedMsg = data.get("bookedTicket");
        boolean actualTicket = bookTicketPage.checkTicket(Constant.ticketInfo);
        Assert.assertEquals(actualMsg, expectedMsg);
        Assert.assertTrue(actualTicket);
    }
}
