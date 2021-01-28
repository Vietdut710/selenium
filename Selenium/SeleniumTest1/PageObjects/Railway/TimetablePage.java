package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimetablePage extends GeneralPage{
    //Locator
    private String _linkBookTicket = "//table//tbody//td[2 and text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='book ticket']";
    private String _selectBox = "//label[starts-with(text(),'%s')]//following-sibling::select";
    private String _selectinBox = "//label[starts-with(text(),'%s')]//following-sibling::*/select";

    //Dynamic elements
    public WebElement linkBookTicket(String departStation,String arriveStation){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(_linkBookTicket,departStation,arriveStation)));
    }

    public WebElement selectBox(String boxName){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(_selectBox,boxName)+"|"+String.format(_selectinBox,boxName)));
    }

    //Methods
    public void chooseTrip(String departFrom, String departArrive) {
        linkBookTicket(departFrom,departArrive).click();
    }

    public boolean checkSelectedTicket(String departFrom, String departArrive) {
        String departDate = new SimpleDateFormat("M/D/YYYY").format( Calendar.getInstance().getTime());
        System.out.println(departDate);


        System.out.println(checkDepartDateSelectBox(departDate)
                +"&&"+checkDepartFromSelectBox(departFrom)
                +"&&"+checkArriveSelectBox(departArrive)
                +"&&"+checkSeatSelectBox("Hard seat")
                +"&&"+checkAmountSelectBox("1"));
        if (checkDepartDateSelectBox(departDate)
                &&checkDepartFromSelectBox(departFrom)
                &&checkArriveSelectBox(departArrive)
                &&checkSeatSelectBox("Hard seat")
                &&checkAmountSelectBox("1")
        )
        {

            return true;
        }

        return false;
    }

    //Method elements
    public boolean checkDepartDateSelectBox(String value){

        if (selectBox("Depart date").getText().contains(value)){
            return true;
        }
        return false;
    }

    public boolean checkDepartFromSelectBox(String value){

        if (selectBox("Depart from").getText().contains(value)){
            return true;
        }
        return false;
    }

    public boolean checkArriveSelectBox(String value){

        if (selectBox("Arrive at").getText().contains(value)){
            return true;
        }
        return false;
    }

    public boolean checkSeatSelectBox(String value){

        if (selectBox("Seat type").getText().contains(value)){
            return true;
        }
        return false;
    }

    public boolean checkAmountSelectBox(String value){

        if (selectBox("Ticket amount").getText().contains(value)){
            return true;
        }
        return false;
    }


}
