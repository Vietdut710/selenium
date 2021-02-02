package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Object.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Locator
    private final By _currentPass = By.xpath("//input[@id='currentPassword']");
    private final By _newPass = By.xpath("//input[@id='newPassword']");
    private final By _confirmPass = By.xpath("//input[@id='confirmPassword']");
    private final By _btnChangePass = By.xpath("//input[@type='submit']");
    private final By _successMsg = By.xpath("//p[contains(@class,'message success')]");

    //Elements
    private WebElement getCurrentPass() {
        Utilities.waitForControl(_currentPass,Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_currentPass);
    }

    private WebElement getNewPass() {
        Utilities.waitForControl(_newPass,Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_newPass);
    }

    private WebElement getConfirmPass() {
        Utilities.waitForControl(_confirmPass,Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_confirmPass);
    }

    private WebElement getBtnChangePass() {
        Utilities.waitForControl(_btnChangePass,Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_btnChangePass);
    }

    private WebElement getSuccessMsg() {
        Utilities.waitForControl(_successMsg,Constant.SHORTTIME);
        return Constant.WEBDRIVER.findElement(_successMsg);
    }

    public void changePassword(Account account, String currentPwd, String newPassword) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("scrollBy(0, 4500)");
        fillCurrentPass(currentPwd);
        fillNewPass(newPassword);
        fillConfirmPass(newPassword);
        account.setPassword(newPassword);
        clickBtnChangePassword();
    }

    private void clickBtnChangePassword() {


        getBtnChangePass().click();

    }

    private void fillConfirmPass(String tmNewPassword) {
        getConfirmPass().clear();
        getConfirmPass().sendKeys(tmNewPassword);
    }

    private void fillNewPass(String tmNewPassword) {
        getNewPass().clear();
        getNewPass().sendKeys(tmNewPassword);
    }

    private void fillCurrentPass(String currentPwd) {
        getCurrentPass().clear();
        getCurrentPass().sendKeys(currentPwd);
    }

    //Message
    public String getMsgSuccess() {

        return getSuccessMsg().getText();
    }

    public String getChangePasswordTitle() {
        return getTitle("Change password");
    }
}
