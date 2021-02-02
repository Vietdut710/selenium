package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {

    //Locator
    private final By _tabMyTicket = By.xpath("//div[@id='menu']//span[contains(text(),'My ticket')]");
    private final By _tabChangePassword = By.xpath("//div[@id='menu']//span[contains(text(),'Change password')]");
    private final By _tabLogout = By.xpath("//div[@id='menu']//span[contains(text(),'Log out')]");


    //Check
    public boolean checkLoginHomePage() {
        Utilities.waitForControl(_tabMyTicket, Constant.SHORTTIME);
        Utilities.waitForControl(_tabChangePassword, Constant.SHORTTIME);
        Utilities.waitForControl(_tabLogout, Constant.SHORTTIME);
        return checkElementExist(_tabMyTicket)
                && checkElementExist(_tabChangePassword)
                && checkElementExist(_tabLogout);
    }

}
