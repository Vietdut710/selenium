package Testcases.RailWay.base;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TestBase extends Utilities {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(@Optional("Firefox") String browser) {
        System.out.println("Pre-condition");
        System.out.println(browser);
        if("Chrome".equals(browser)) {
            Constant.randomUsername ="c"+ new SimpleDateFormat("yyyyMMddHHMMss").format(Calendar.getInstance().getTime());
        }else
            if ("Firefox".equals(browser)){
                Constant.randomUsername ="f"+ new SimpleDateFormat("yyyyMMddHHMMss").format(Calendar.getInstance().getTime());
            }
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
        data = getData(System.getProperty("user.dir")+"\\SeleniumTest1\\DataObject\\data.json", testCaseName);
        return data;
    }
}

