package PageObjects.Railway;

import Common.Constant.Constant;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;

public class RegisterPage extends GeneralPage {

    //Locators
    private final By _txtUsername = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtRePassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPassport = By.xpath("//input[@id='pid']");
    private final By _lblSuccessMsg = By.xpath("//div[@id='content']//p");
    private final By _btnRegister = By.xpath("//input[@type='submit']");
    private final By _lblErrorMsg = By.xpath("//p[@class='message error']");

    private final String _boxAlertMsg = "//label[starts-with(text(),'%s')]" +
            "//following-sibling::input[@class='error-field']" +
            "//following-sibling::label";

    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getTxtRePassword() {
        return Constant.WEBDRIVER.findElement(_txtRePassword);
    }

    public WebElement getTxtPassport() {
        return Constant.WEBDRIVER.findElement(_txtPassport);
    }

    public WebElement getLblSuccessMsg() {
        return Constant.WEBDRIVER.findElement(_lblSuccessMsg);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    public WebElement getErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblErrorMsg);
    }

    public WebElement getAlertBoxMsg(String boxname) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(_boxAlertMsg,boxname)));
    }

    //Methods
    public void fillData(String email, String password, String repass, String passport) {
        getTxtUsername().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtRePassword().sendKeys(repass);
        getTxtPassport().sendKeys(passport);
    }

    public void createAccount(String email, String password, String repass, String passport) {
        getTxtUsername().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtRePassword().sendKeys(repass);
        getTxtPassport().sendKeys(passport);
        clickRegisterButton();
    }

    public void clickRegisterButton() {
        getBtnRegister().sendKeys(Keys.ENTER);

        try {
            Thread.sleep(1500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Message
    public String getSuccessMsg() {
        return getLblSuccessMsg().getText();
    }

    public String registrationConfirmedMsg(){
        return getExpectedRegisterMsg("RegistrationConfirmed");
    }

    public String invalidRegisterMsg(){
        return getExpectedRegisterMsg("InvalidRegister");
    }

    public String invalidPasswordLengthMsg(){
        return getExpectedRegisterMsg("PasswordLength");
    }

    public String invalidUsernameLengthMsg(){
        return getExpectedRegisterMsg("UsernameLength");
    }

    public String invalidIDLengthMsg(){
        return getExpectedRegisterMsg("IDLength");
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

    @SuppressWarnings("unchecked")
    public void saveNewAccount(String Email, String Password, String Passport) {

        JSONObject obj = new JSONObject();
        obj.put("username", Email);
        obj.put("password", Password);
        obj.put("passport", Passport);

        try (FileWriter f = new FileWriter(System.getProperty("user.dir")
                + "\\SeleniumTest1\\DataObject\\NewAccount.json")) {
            f.write(obj.toString());
            f.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(obj);
    }


}
