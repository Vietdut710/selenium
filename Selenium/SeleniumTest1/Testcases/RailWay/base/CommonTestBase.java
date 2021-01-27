package Testcases.RailWay.base;

import Common.Common.Utilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class CommonTestBase extends Utilities {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(@Optional("Chrome")String browser){
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

}
