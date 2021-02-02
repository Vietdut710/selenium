package PageObjects.Railway;


import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class MyTicketPage extends GeneralPage {

    //locator
    String _ticketInfo = "//tr//td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']";
    String _btnCancel = "//tr//td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::input[@value='Cancel']";


    //Dynamic Elements

    //Methods
    public String getMyTicketTitle() {
        return getTitle("My ticket");
    }

    public void cancelTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        By _ctrlBtnCancel = By.xpath(String.format(_btnCancel, departFrom, arriveAt, seatType, departDate, ticketAmount));
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("scrollBy(0, 4500)");


        if (Constant.WEBDRIVER.findElements(_ctrlBtnCancel).size() != 0) {
            Constant.WEBDRIVER.findElement(_ctrlBtnCancel).click();
            Constant.WEBDRIVER.switchTo().alert().accept();
        }

    }

    public boolean checkTicketExist(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        By _ctrlTicketInfo = By.xpath(String.format(_ticketInfo, departFrom, arriveAt, seatType, departDate, ticketAmount));

        Utilities.waitForStep(_ctrlTicketInfo, Constant.SHORTTIME);

        return !Constant.WEBDRIVER.findElements(_ctrlTicketInfo).isEmpty();
    }
}

