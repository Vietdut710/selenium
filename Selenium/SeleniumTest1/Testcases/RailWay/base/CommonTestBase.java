package Testcases.RailWay.base;

import Common.Common.Utilities;
import PageObjects.Railway.GeneralPage;
import org.testng.annotations.*;


public class CommonTestBase extends Utilities {

    GeneralPage generalPage = new GeneralPage();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(@Optional("Firefox")String browser){
        System.out.println("Pre-condition");

        Utilities.chooseBrowserDriver(browser);
        Utilities.setupMaximumScreen();
        Utilities.gotoRailway();

    }

    @AfterClass
    public void afterClass(){
        System.out.println("Post-condition");

        Utilities.closeBrowser();
    }

    @DataProvider(name = "TC01")
    public Object[][] getDataTC01(){
        Object[][] data = {
                {
                    generalPage.readJson("TC01","username"),
                    generalPage.readJson("TC01","password")
                }
        };
        return data;
    }

    @DataProvider(name = "TC02")
    public Object[][] getDataTC02(){
        Object[][] data = {
                {
                        generalPage.readJson("TC02","msg_BlankLogin")
                }
        };
        return data;
    }

    @DataProvider(name = "TC03")
    public Object[][] getDataTC03(){
        Object[][] data = {
                {
                        generalPage.readJson("TC03","msg_InvalidLogin")
                }
        };
        return data;
    }

    @DataProvider(name = "TC04")
    public Object[][] getDataTC04(){
        Object[][] data = {
                {
                        generalPage.readJson("TC04","loginPage")
                }
        };
        return data;
    }

    @DataProvider(name = "TC05")
    public Object[][] getDataTC05(){
        Object[][] data = {
                {
                        generalPage.readJson("TC05","msg_loginSeveralTimes")
                }
        };
        return data;
    }

    @DataProvider(name = "TC06")
    public Object[][] getDataTC06(){
        Object[][] data = {
                {
                        generalPage.readJson("TC06","myTicketPage"),
                        generalPage.readJson("TC06","changePassword"),
                }
        };
        return data;
    }

    @DataProvider(name = "TC07")
    public Object[][] getDataTC07(){
        Object[][] data = {
                {
                        generalPage.readJson("TC07","registrationConfirmed")
                }
        };
        return data;
    }

    @DataProvider(name = "TC09")
    public Object[][] getDataTC09(){
        Object[][] data = {
                {
                        generalPage.readJson("TC09","passwordChanged")
                }
        };
        return data;
    }

    @DataProvider(name = "TC10")
    public Object[][] getDataTC10(){
        Object[][] data = {
                {
                        generalPage.readJson("TC10","InvalidRegister")
                }
        };
        return data;
    }

    @DataProvider(name = "TC11")
    public Object[][] getDataTC11(){
        Object[][] data = {
                {
                        generalPage.readJson("TC11","InvalidRegister"),
                        generalPage.readJson("TC11","PasswordLength"),
                        generalPage.readJson("TC11","IDLength")
                }
        };
        return data;
    }

    @DataProvider(name = "TC14")
    public Object[][] getDataTC14(){
        Object[][] data = {
                {
                        generalPage.readJson("TC14","departDate"),
                        generalPage.readJson("TC14","departFrom"),
                        generalPage.readJson("TC14","arriveAt"),
                        generalPage.readJson("TC14","seatType"),
                        generalPage.readJson("TC14","ticketAmount"),
                        generalPage.readJson("TC14","bookedTicket")
                }
        };
        return data;
    }




}

