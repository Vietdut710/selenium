package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class GeneralPage {

    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabHome = By.xpath("//div[@id='menu']//span[contains(text(),'Home')]");
    private final By tabFAQ = By.xpath("//div[@id='menu']//span[contains(text(),'FAQ')]");
    private final By tabContact = By.xpath("//div[@id='menu']//span[contains(text(),'Contact')]");
    private final By tabTimetable = By.xpath("//div[@id='menu']//span[contains(text(),'Timetable')]");
    private final By tabTicketPrice = By.xpath("//div[@id='menu']//span[contains(text(),'Ticket price')]");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//span[contains(text(),'Book ticket')]");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//span[contains(text(),'My ticket')]");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//span[contains(text(),'Change password')]");
    private final By tabRegister = By.xpath("//div[@id='menu']//span[contains(text(),'Register')]");
    private final By tabLogout = By.xpath("//div[@id='menu']//span[contains(text(),'Log out')]");

    private final String pageTitle = "//span[contains(text(),'%s')]//ancestor::div[@id='page']//h1";
    private final String fieldMsg ="//label[starts-with(text(),'%s')]//following-sibling::label";
    private final String selectBox = "//label[starts-with(text(),'%s')]//following-sibling::select";
    private final String selectinBox = "//label[starts-with(text(),'%s')]//following-sibling::*/select";


    //Elements
    protected WebElement getTabLogin() {
        Utilities.waiForControl(tabLogin,10);
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getLblWelcomeMessage() {
        Utilities.waiForControl(lblWelcomeMessage,10);
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabHomePage() {
        Utilities.waiForControl(tabHome,10);
        return Constant.WEBDRIVER.findElement(tabHome);
    }

    protected WebElement getTabFAQPage() {
        Utilities.waiForControl(tabFAQ,10);
        return Constant.WEBDRIVER.findElement(tabFAQ);
    }

    protected WebElement getTimetablePage() {
        Utilities.waiForControl(tabTimetable,10);
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    protected WebElement getContactPage() {
        Utilities.waiForControl(tabContact,10);
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    protected WebElement getTicketPricePage() {
        Utilities.waiForControl(tabTicketPrice,10);
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    protected WebElement getBookTicketPage() {
        Utilities.waiForControl(tabBookTicket,10);
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getRegisterPage() {
        Utilities.waiForControl(tabRegister,10);
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getMyTicketPage() {
        Utilities.waiForControl(tabMyTicket,10);
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getChangePasswordPage() {
        Utilities.waiForControl(tabChangePassword,10);
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getLogout() {
        Utilities.waiForControl(tabLogout,10);
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    //Dynamic Elements

    protected WebElement getTabTitle(String title) {
        Utilities.waiForControl(By.xpath(String.format(pageTitle, title)),10);
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(pageTitle, title)));
    }

    protected WebElement getFieldMsg(String fieldName) {
        By field = By.xpath(String.format(fieldMsg,fieldName));
        Utilities.waiForControl(field,10);
        return Constant.WEBDRIVER.findElement(field);
    }

    //Methods
    public String getWelcomeMassage() {
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        return this.getLblWelcomeMessage().getText();
    }



    public String fieldMsg(String fieldName) {
        return getFieldMsg(fieldName).getText();
    }

    public void selectComboBox(String boxName, String value) {
        By element = By.xpath(String.format(selectBox,boxName) +"|"+
                String.format(selectinBox,boxName));
        Select select = new Select(Constant.WEBDRIVER.findElement(element));
        select.selectByVisibleText(value);
    }


    public String getTitle(String title) {
        return getTabTitle(title).getText();
    }

    public void logout() { getLogout().click();}

    public void gotoLoginPage() { getTabLogin().click();}

    public void gotoHomePage() {
        getTabHomePage().click();
    }

    public void gotoFAQPage() {
        getTabFAQPage().click();
    }

    public void gotoTimetablePage() {
        getTimetablePage().click();
    }

    public void gotoContactPage() {
        getContactPage().click();
    }

    public void gotoTicketPricePage() {
        getTicketPricePage().click();
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
