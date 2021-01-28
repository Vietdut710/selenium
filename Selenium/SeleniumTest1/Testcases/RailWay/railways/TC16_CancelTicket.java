package Testcases.RailWay.railways;

import Testcases.RailWay.base.CommonTestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TC16_CancelTicket  {



    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-Condition : Create account");
    }

    @Test
    public void TC16(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/D/YYYY");
        LocalDateTime now = LocalDateTime.now();
        
        System.out.println(dtf.format(now));

        System.out.println("TC16-User can cancel a ticket");

        System.out.println("Go to login page");

        System.out.println("Go to Book ticket page");

        System.out.println("Book ticket");

        System.out.println("Cancel just booked ticket");

        System.out.println("Check ticket not exist");
    }
}
