package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {

    //Locator
    private final By _tabMyTicket = By.xpath("//div[@id='menu']//span[contains(text(),'My ticket')]");
    private final By _tabChangePassword = By.xpath("//div[@id='menu']//span[contains(text(),'Change password')]");
    private final By _tabLogout = By.xpath("//div[@id='menu']//span[contains(text(),'Log out')]");


    //Check
    public boolean checkLoginHomePage() {
        if (checkElementExist(_tabMyTicket)
                && checkElementExist(_tabChangePassword)
                && checkElementExist(_tabLogout)) {

            return true;
        }

        return false;
    }

}
