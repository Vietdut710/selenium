package Testcases.RailWay.bookticket;

import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import Testcases.RailWay.base.CommonTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC14_BookTicket extends CommonTestBase {


    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    private final String departDate = bookTicketPage.departDate();
    private final String departFrom = bookTicketPage.departStation();
    private final String arriveAt = bookTicketPage.arriveStation();
    private final String seatType = bookTicketPage.seatType();
    private final String ticketAmount = bookTicketPage.ticketAmount();
    private final String naUsername = loginPage.newAccountUsername();
    private final String naPassword = loginPage.newAccountPassword();

    @Test
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");

        System.out.println("Go to login page");
        homePage.gotoLoginPage();

        System.out.println("Login with just created account");
        loginPage.login(naUsername, naPassword);

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
