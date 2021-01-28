package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage{


    //Locator
    private final By _btnBookTicket = By.xpath("//input[@type='submit']");

    //Elements
    protected WebElement getBtnBookTicket(){ return Constant.WEBDRIVER.findElement(_btnBookTicket);}

    //Methods
    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {

        selectDepartDate(departDate);
        selectDepartFrom(departFrom);
        selectArriveAt(arriveAt);
        selectSeatType(seatType);
        selectTicketAmount(ticketAmount);
        clickBtnBookTicket();

    }

    private void clickBtnBookTicket() {

        getBtnBookTicket().sendKeys(Keys.ENTER);

        try {
            Thread.sleep(1500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void selectTicketAmount(String ticketAmount) {
        selectComboBox("Ticket amount",ticketAmount);
    }

    private void selectSeatType(String seatType) {
        selectComboBox("Seat type",seatType);
    }

    private void selectArriveAt(String arriveAt) {

        // I tried using Implicit Wait and Explicit Wait but it didn't work
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        selectComboBox("Arrive at", arriveAt);
    }

    private void selectDepartFrom(String departFrom) {
        selectComboBox("Depart from",departFrom);
    }

    private void selectDepartDate(String departDate) {
        selectComboBox("Depart date",departDate);
    }

    public boolean checkTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {

        if(checkTicketBooked("Depart Date",departDate)
                && checkTicketBooked("Depart Station",departFrom)
                && checkTicketBooked("Arrive Station",arriveAt)
                && checkTicketBooked("Seat Type",seatType)
                && checkTicketBooked("Amount",ticketAmount)){
            return true;
        }

        return false;
    }
    //Message
    public String getBookedTicketTitle(){
        return getTitle("Book ticket");
    }



}
