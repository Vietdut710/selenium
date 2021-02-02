package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage{


    //Locator
    private final By _btnBookTicket = By.xpath("//input[@type='submit']");

    //Elements
    protected WebElement getBtnBookTicket(){ return Constant.WEBDRIVER.findElement(_btnBookTicket);}

    //Methods
    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        JavascriptExecutor js = (JavascriptExecutor)Constant.WEBDRIVER;
        js.executeScript("scrollBy(0, 4500)");
        selectDepartFrom(departFrom);
        selectDepartDate(departDate);
        selectSeatType(seatType);
        selectTicketAmount(ticketAmount);
        selectArriveAt(arriveAt);
        clickBtnBookTicket();

    }

    private void clickBtnBookTicket() {
        getBtnBookTicket().click();

    }

    private void selectTicketAmount(String ticketAmount) {
        selectComboBox("Ticket amount",ticketAmount);
    }

    private void selectSeatType(String seatType) {
        selectComboBox("Seat type",seatType);
    }

    private void selectArriveAt(String arriveAt) {


        selectComboBox("Arrive at", arriveAt);

    }

    private void selectDepartFrom(String departFrom) {
        selectComboBox("Depart from",departFrom);
    }

    private void selectDepartDate(String departDate) {
        selectComboBox("Depart date",departDate);
    }

    public boolean checkTicketBooked(String col, String value) {
        By departStation = By.xpath("//tr[@class='OddRow']//td[1]");
        By arriveStation = By.xpath("//tr[@class='OddRow']//td[2]");
        By seatType = By.xpath("//tr[@class='OddRow']//td[3]");
        By departDate = By.xpath("//tr[@class='OddRow']//td[4]");
        By bookDate = By.xpath("//tr[@class='OddRow']//td[5]");
        By expiredDate = By.xpath("//tr[@class='OddRow']//td[6]");
        By amount = By.xpath("//tr[@class='OddRow']//td[7]");
        By totalPrice = By.xpath("//tr[@class='OddRow']//td[8]");

        switch (col) {
            case "Depart Station":
                if (Constant.WEBDRIVER.findElement(departStation).getText().equals(value)) {
                    return true;
                }
            case "Arrive Station":
                if (Constant.WEBDRIVER.findElement(arriveStation).getText().equals(value)) {
                    return true;
                }
            case "Seat Type":
                if (Constant.WEBDRIVER.findElement(seatType).getText().equals(value)) {
                    return true;
                }
            case "Depart Date":
                if (Constant.WEBDRIVER.findElement(departDate).getText().equals(value)) {
                    return true;
                }
            case "Book Date":
                if (Constant.WEBDRIVER.findElement(bookDate).getText().equals(value)) {
                    return true;
                }
            case "Expired Date":
                if (Constant.WEBDRIVER.findElement(expiredDate).getText().equals(value)) {
                    return true;
                }
            case "Amount":
                if (Constant.WEBDRIVER.findElement(amount).getText().equals(value)) {
                    return true;
                }
            case "Total Price":
                if (Constant.WEBDRIVER.findElement(totalPrice).getText().equals(value)) {
                    return true;
                }

            default:
                return false;
        }
    }

    public boolean checkTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {

        return checkTicketBooked("Depart Date", departDate)
                && checkTicketBooked("Depart Station", departFrom)
                && checkTicketBooked("Arrive Station", arriveAt)
                && checkTicketBooked("Seat Type", seatType)
                && checkTicketBooked("Amount", ticketAmount);
    }
    //Message
    public String getBookedTicketTitle(){
        return getTitle("Book ticket");
    }



}
