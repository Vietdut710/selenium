package PageObjects.Railway;

import org.openqa.selenium.By;

public class MyTicketPage extends GeneralPage {

    //Locator
    private final By _tabMyTicket = By.xpath("//div[@id='menu']//span[contains(text(),'My ticket')]");


    //Message
    public String MyTicketPageTitle() {
        return pageTitle("myTicketPage");
    }

    public String getMyTicketTitle() {
        return getTitle("My ticket");
    }


}

