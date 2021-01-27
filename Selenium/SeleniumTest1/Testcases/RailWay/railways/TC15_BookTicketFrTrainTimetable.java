package Testcases.RailWay.railways;

import Testcases.RailWay.base.CommonTestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC15_BookTicketFrTrainTimetable extends CommonTestBase {



    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition : Create account");
    }

    @Test
    public void TC15(){

        System.out.println("Go to login page");

        System.out.println("Go to Timetable page");

        System.out.println("Click book ticket link");

        System.out.println("Check info of ticket");

    }
}
