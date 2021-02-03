package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.CommonObjects.GeneralPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //Locators
    private final By _txtUsername = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtRePassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPassport = By.xpath("//input[@id='pid']");
    private final By _lblSuccessMsg = By.xpath("//div[@id='content']//p");
    private final By _btnRegister = By.xpath("//input[@type='submit']");
    private final By _lblErrorMsg = By.xpath("//p[@class='message error']");

    //Elements
    public WebElement getTxtUsername() {
        Utilities.waitForControl(_txtUsername, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        Utilities.waitForControl(_txtPassword, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getTxtRePassword() {
        Utilities.waitForControl(_txtRePassword, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_txtRePassword);
    }

    public WebElement getTxtPassport() {
        Utilities.waitForControl(_txtPassport, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_txtPassport);
    }

    public WebElement getLblSuccessMsg() {
        Utilities.waitForControl(_lblSuccessMsg, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_lblSuccessMsg);
    }

    public WebElement getBtnRegister() {
        Utilities.waitForControl(_btnRegister, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    public WebElement getErrorMsg() {
        Utilities.waitForControl(_lblErrorMsg, Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_lblErrorMsg);
    }


    //Methods
    public void fillData(String email, String password, String repass, String passport) {
        getTxtUsername().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtRePassword().sendKeys(repass);
        getTxtPassport().sendKeys(passport);

    }

    public void createAccount(String email, String password, String repass, String passport) {
        Constant.account.setUsername(email);
        Constant.account.setPassword(password);
        Constant.account.setPassport(passport);

        fillData(email, password, repass, passport);
        clickRegisterButton();
    }



    public void clickRegisterButton() {
        getBtnRegister().sendKeys(Keys.ENTER);

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Message
    public String getSuccessMsg() {
        return getLblSuccessMsg().getText();
    }

    public String getErrorMessage() {
        return getErrorMsg().getText();
    }

    public String getPasswordFieldMsg() {
        return fieldMsg("Password");
    }

    public String getPassportFieldMsg() {
        return fieldMsg("PID");
    }


}
