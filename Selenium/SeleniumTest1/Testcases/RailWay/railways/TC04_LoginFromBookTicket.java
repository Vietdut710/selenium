package Testcases.RailWay.railways;

import PageObjects.Railway.*;
import Testcases.RailWay.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC04_LoginFromBookTicket extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getDataForTest")
    public void TC04(Hashtable<String, String> data){
        System.out.println("TC04 - Login page displays when un-logged User clicks on Book ticket tab");

        System.out.println("Go to Book ticket page");
        loginPage.gotoBookTicketPage();

        System.out.println("Check login page is displayed");
        String actualTitle = loginPage.getLoginPageTitle();
        String expectedTitle = data.get("loginPage");
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
