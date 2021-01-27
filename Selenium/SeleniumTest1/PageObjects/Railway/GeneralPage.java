package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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


    //Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabHomePage() {
        return Constant.WEBDRIVER.findElement(tabHome);
    }

    protected WebElement getTabFAQPage() {
        return Constant.WEBDRIVER.findElement(tabFAQ);
    }

    protected WebElement getTimetablePage() {
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    protected WebElement getContactPage() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    protected WebElement getTicketPricePage() {
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    protected WebElement getBookTicketPage() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getRegisterPage() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getMyTicketPage() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getChangePasswordPage() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    //Dynamic Elements

    protected WebElement getTabTitle(String title) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(pageTitle, title)));
    }

    protected WebElement getFieldMsg(String fieldName) {
        By field = By.xpath(String.format(fieldMsg,fieldName));
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

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public String fieldMsg(String fieldName) {
        return getFieldMsg(fieldName).getText();
    }

    public void selectComboBox(String boxName, String value) {
        By element = By.xpath("//label[starts-with(text(),'" + boxName + "')]//following-sibling::select|" +
                "//label[starts-with(text(),'" + boxName + "')]//following-sibling::*/select");
        Utilities.waiForControl(element, 5);
        ((JavascriptExecutor)
                Constant.WEBDRIVER).executeScript ("arguments[0].scrollIntoView();", element);
        Select select = new Select(Constant.WEBDRIVER.findElement(element));
        select.selectByVisibleText(value);
    }


    public void logout() { getLogout().click();}

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

    //Dynamic Methods

    public static String getExpectedLoginMsg(String value) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "\\SeleniumTest1\\DataObject\\ExpectedLoginMsg.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getExpectedRegisterMsg(String value) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "\\SeleniumTest1\\DataObject\\ExpectedRegisterMsg.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getExpectedChangePasswordMsg(String value) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "\\SeleniumTest1\\DataObject\\ExpectedChangePasswordMsg.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getBookTicket(String value) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "\\SeleniumTest1\\DataObject\\BookTicket.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public  String getExpectedBookTicketMsg(String value) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "\\SeleniumTest1\\DataObject\\ExpectedBookTicketMsg.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //get obj
    public String getNewAccount(String value) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "\\SeleniumTest1\\DataObject\\NewAccount.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    //check
    public boolean checkElementExist(By element) {
        return Constant.WEBDRIVER.findElements(element).size() != 0;
    }

    public boolean checkElementNotExist(By element) {
        return Constant.WEBDRIVER.findElements(element).size() == 0;

    }

    public String getTitle(String title) {
        return getTabTitle(title).getText();
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

    //Message
    public String pageTitle(String value) {

        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "\\SeleniumTest1\\DataObject\\PageTitle.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
