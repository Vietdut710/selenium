package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class TimetablePage extends GeneralPage {
    //Locator
    private final String _linkBookTicket = "//table//tbody//td[2 and text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='book ticket']";
    private final String _optionElement = "//label[starts-with(text(),'%s')]//following-sibling::select//option[@selected]|//label[starts-with(text(),'%s')]//following-sibling::*/select//option[@selected]";


    //Dynamic elements
    public WebElement linkBookTicket(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(_linkBookTicket, departStation, arriveStation)));
    }


    public WebElement optionElement(String boxName) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(_optionElement, boxName, boxName)));
    }

    //Methods
    public void chooseTrip(String departFrom, String departArrive) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("scrollBy(0, 4500)");
        linkBookTicket(departFrom, departArrive).click();
    }

    public boolean checkSelectedTicket() {

        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("scrollBy(0, 4500)");

        return checkDepartFromSelectBox() && checkArriveSelectBox();
    }

    //Method elements

    public boolean checkDepartFromSelectBox() {
        return optionElement("Depart from").isDisplayed();
    }

    public boolean checkArriveSelectBox() {

        return optionElement("Arrive at").isDisplayed();
    }

}
