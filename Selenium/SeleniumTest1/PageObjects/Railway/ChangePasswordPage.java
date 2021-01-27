package PageObjects.Railway;

import Common.Constant.Constant;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChangePasswordPage extends GeneralPage {

    //Locator
    private final By _currentPass = By.xpath("//input[@id='currentPassword']");
    private final By _newPass = By.xpath("//input[@id='newPassword']");
    private final By _confirmPass = By.xpath("//input[@id='confirmPassword']");
    private final By _btnChangePass = By.xpath("//input[@type='submit']");
    private final By _successMsg = By.xpath("//p[contains(@class,'message success')]");

    //Methods
    public static void waiForControl(By element, int time) {
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER, time);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //Elements
    private WebElement getCurrentPass() {
        return Constant.WEBDRIVER.findElement(_currentPass);
    }

    private WebElement getNewPass() {
        return Constant.WEBDRIVER.findElement(_newPass);
    }

    private WebElement getConfirmPass() {
        return Constant.WEBDRIVER.findElement(_confirmPass);
    }

    private WebElement getBtnChangePass() {
        return Constant.WEBDRIVER.findElement(_btnChangePass);
    }

    private WebElement getSuccessMsg() {
        return Constant.WEBDRIVER.findElement(_successMsg);
    }

    public void changePassword(String currentpass, String NewPassword) {
        fillCurrentPass(currentpass);
        fillNewPass(NewPassword);
        fillConfirmPass(NewPassword);
        changeJsonPassword(NewPassword);
        clickBtnChangePassword();
    }

    private void clickBtnChangePassword() {
        getBtnChangePass().sendKeys(Keys.ENTER);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fillConfirmPass(String tmNewPassword) {
        getConfirmPass().clear();
        getConfirmPass().sendKeys(tmNewPassword);
    }

    private void fillNewPass(String tmNewPassword) {
        getNewPass().clear();
        getNewPass().sendKeys(tmNewPassword);
    }

    private void fillCurrentPass(String currentpass) {
        getCurrentPass().clear();
        getCurrentPass().sendKeys(currentpass);
    }

    public void changeJsonPassword(String password) {
        JSONParser  jsonParser = new JSONParser();


        try (FileWriter f = new FileWriter(System.getProperty("user.dir") + "\\SeleniumTest1\\DataObject\\NewAccount.json")) {
            Object obj =  jsonParser.parse();
            obj.replace("password", password);

            f.write(obj.toString());
            f.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(obj);
    }

    public String newPassword() {

        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "\\SeleniumTest1\\DataObject\\ChangePassword.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get("newPassword");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Message
    public String getMsgSuccess() {

        return getSuccessMsg().getText();
    }

    public String getChangePasswordTitle() {
        return getTitle("Change password");
    }

    public String changePasswordTitle() {
        return pageTitle("changePassword");
    }

    public String changePasswordSuccessfully() {
        return getExpectedChangePasswordMsg("passwordChanged");
    }
}
