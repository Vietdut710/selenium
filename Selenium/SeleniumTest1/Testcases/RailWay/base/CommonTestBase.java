package Testcases.RailWay.base;

import Common.Common.Utilities;
import PageObjects.Railway.GeneralPage;
import org.testng.annotations.*;

import java.io.IOException;


public class CommonTestBase extends Utilities {

    GeneralPage generalPage = new GeneralPage();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(@Optional("Firefox") String browser) {
        System.out.println("Pre-condition");

        Utilities.chooseBrowserDriver(browser);
        Utilities.setupMaximumScreen();
        Utilities.gotoRailway();

    }

    @AfterClass
    public void afterClass() {
        System.out.println("Post-condition");

        Utilities.closeBrowser();
    }

    @DataProvider(name = "getDataForTest")
    public Object[][] getDataForTest() throws IOException {
        Object[][] data;
        String testCaseName = this.getClass().getSimpleName();
        data = getData("C:\\Users\\SATTDN20.03.08\\Desktop\\myProject\\selenium\\Selenium\\SeleniumTest1\\DataObject\\data.json", testCaseName);
        return data;
    }
}

