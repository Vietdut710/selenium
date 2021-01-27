package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {

    //Locator
    private final By _tabMyTicket = By.xpath("//div[@id='menu']//span[contains(text(),'My ticket')]");
    private final By _tabChangePassword = By.xpath("//div[@id='menu']//span[contains(text(),'Change password')]");
    private final By _tabLogout = By.xpath("//div[@id='menu']//span[contains(text(),'Log out')]");

    //Methods

    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    //Check
    public boolean checkLoginHomePage() {
        if (checkElementExist(_tabMyTicket)
                && checkElementExist(_tabChangePassword)
                && checkElementExist(_tabLogout)) {

            return true;
        }

        return false;
    }

    public boolean checkNotLoginHomePage() {
        if (checkElementNotExist(_tabMyTicket)
                && checkElementNotExist(_tabChangePassword)
                && checkElementNotExist(_tabLogout)) {

            return true;
        }

        return false;
    }
}
