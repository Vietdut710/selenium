package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.CommonObjects.GeneralPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    //locators
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@type='submit']");
    private final By _lblLoginErrorMsg = By.xpath("//p[contains(@class,'message error LoginForm')]");

    //Elements
    private WebElement getTxtUsername() {

        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    private WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    private WebElement getBtnLogin() {
        Utilities.waitForControl(_btnLogin, Constant.MEDIUMTIME);
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    private WebElement getLblLoginErrorMsg() {
        Utilities.waitForControl(_lblLoginErrorMsg, Constant.MEDIUMTIME);
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }


    //Method Elements
    public void fillUsername(String username) {
        getTxtUsername().clear();
        getTxtUsername().sendKeys(username);

    }

    public void fillPassword(String password) {
        getTxtPassword().clear();
        getTxtPassword().sendKeys(password);

    }

    public void clickLoginButton() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("scrollBy(0, 4500)");
        getBtnLogin().click();

    }

    //Methods
    public void login(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLoginButton();

    }


    public void loginMultiTimes(String username, String password, int Times) {
        for (int i = 1; i <= Times; i++) {
            fillUsername(username);
            fillPassword(password);
            clickLoginButton();
        }


    }

    //Method get messages
    public String getLoginErrorMsg() {
        return getLblLoginErrorMsg().getText();
    }

    public Boolean checkLoginErrorMsg() {
        return Constant.WEBDRIVER.findElements(_lblLoginErrorMsg).size() != 0;
    }

    public String getLoginPageTitle() {
        return getTitle("Login");
    }

}
