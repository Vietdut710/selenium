package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


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
        JavascriptExecutor js = (JavascriptExecutor)Constant.WEBDRIVER;
        js.executeScript("scrollBy(0, 4500)");
        linkBookTicket(departFrom,departArrive).click();
    }

    public boolean checkSelectedTicket(String departFrom, String departArrive) {

        JavascriptExecutor js = (JavascriptExecutor)Constant.WEBDRIVER;
        js.executeScript("scrollBy(0, 4500)");

        if (checkDepartFromSelectBox(departFrom)
                &&checkArriveSelectBox(departArrive))
        {

            return true;
        }

        return false;
    }

    //Method elements

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

}
