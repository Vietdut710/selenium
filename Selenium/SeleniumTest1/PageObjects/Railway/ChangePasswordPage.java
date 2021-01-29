package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import DataObject.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        Utilities.waiForControl(_currentPass,10);
        return Constant.WEBDRIVER.findElement(_currentPass);
    }

    private WebElement getNewPass() {
        Utilities.waiForControl(_newPass,10);
        return Constant.WEBDRIVER.findElement(_newPass);
    }

    private WebElement getConfirmPass() {
        Utilities.waiForControl(_confirmPass,10);
        return Constant.WEBDRIVER.findElement(_confirmPass);
    }

    private WebElement getBtnChangePass() {
        Utilities.waiForControl(_btnChangePass,10);
        return Constant.WEBDRIVER.findElement(_btnChangePass);
    }

    private WebElement getSuccessMsg() {
        Utilities.waiForControl(_successMsg,10);
        return Constant.WEBDRIVER.findElement(_successMsg);
    }

    public void changePassword(Account account, String currentpass, String newPassword) {
        fillCurrentPass(currentpass);
        fillNewPass(newPassword);
        fillConfirmPass(newPassword);
        account.setPassword(newPassword);
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

    //Message
    public String getMsgSuccess() {

        return getSuccessMsg().getText();
    }

    public String getChangePasswordTitle() {
        return getTitle("Change password");
    }
}
