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
}
