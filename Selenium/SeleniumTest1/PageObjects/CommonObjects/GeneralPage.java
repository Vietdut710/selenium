package PageObjects.CommonObjects;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class GeneralPage {

    //Locators
    private final By _tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By _lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By _tabTimetable = By.xpath("//div[@id='menu']//span[contains(text(),'Timetable')]");
    private final By _tabBookTicket = By.xpath("//div[@id='menu']//span[contains(text(),'Book ticket')]");
    private final By _tabMyTicket = By.xpath("//div[@id='menu']//span[contains(text(),'My ticket')]");
    private final By _tabChangePassword = By.xpath("//div[@id='menu']//span[contains(text(),'Change password')]");
    private final By _tabRegister = By.xpath("//div[@id='menu']//span[contains(text(),'Register')]");

    private final String pageTitle = "//span[contains(text(),'%s')]//ancestor::div[@id='page']//h1";
    private final String fieldMsg = "//label[starts-with(text(),'%s')]//following-sibling::label";
    private final String selectBox = "//label[starts-with(text(),'%s')]//following-sibling::select | //label[starts-with(text(),'%s')]//following-sibling::*/select";


    //Elements
    protected WebElement getTabLogin() {
        Utilities.waitForControl(_tabLogin, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_tabLogin);
    }

    protected WebElement getLblWelcomeMessage() {
        Utilities.waitForControl(_lblWelcomeMessage, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_lblWelcomeMessage);
    }

    protected WebElement getTimetablePage() {
        Utilities.waitForControl(_tabTimetable, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_tabTimetable);
    }

    protected WebElement getBookTicketPage() {
        Utilities.waitForControl(_tabBookTicket, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_tabBookTicket);
    }

    protected WebElement getRegisterPage() {
        Utilities.waitForControl(_tabRegister, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_tabRegister);
    }

    protected WebElement getMyTicketPage() {
        Utilities.waitForControl(_tabMyTicket, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_tabMyTicket);
    }

    protected WebElement getChangePasswordPage() {
        Utilities.waitForControl(_tabChangePassword, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_tabChangePassword);
    }


    //Dynamic Elements

    protected WebElement getTabTitle(String title) {
        Utilities.waitForControl(By.xpath(String.format(pageTitle, title)), Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(pageTitle, title)));
    }

    protected WebElement getFieldMsg(String fieldName) {
        By field = By.xpath(String.format(fieldMsg, fieldName));
        Utilities.waitForControl(field, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(field);
    }

    //Methods
    public String getWelcomeMassage() {

        return this.getLblWelcomeMessage().getText();
    }


    public String fieldMsg(String fieldName) {
        return getFieldMsg(fieldName).getText();
    }

    public void selectComboBox(String boxName, String value) {
        By element = By.xpath(String.format(selectBox, boxName, boxName));
        Utilities.waitForControl(element, Constant.SHORTTIME);
        Select select = new Select(Constant.WEBDRIVER.findElement(element));
        select.selectByVisibleText(value);
    }


    public String getTitle(String title) {
        return getTabTitle(title).getText();
    }

    public void gotoLoginPage() {
        getTabLogin().click();
    }

    public void gotoTimetablePage() {
        getTimetablePage().click();
    }

    public void gotoBookTicketPage() {
        getBookTicketPage().click();
    }

    public void gotoRegisterPage() {
        getRegisterPage().click();
    }

    public void gotoMyTicketPage() {
        getMyTicketPage().click();
    }

    public void gotoChangePasswordPage() {
        getChangePasswordPage().click();
    }

    //check
    public boolean checkElementExist(By element) {
        return Constant.WEBDRIVER.findElements(element).size() != 0;
    }


    //Message


}
