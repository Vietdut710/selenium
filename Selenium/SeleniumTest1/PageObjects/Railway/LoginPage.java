package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    private WebElement getLblLoginErrorMsg() {
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
        getBtnLogin().sendKeys(Keys.ENTER);
        try {
            Thread.sleep(1500);
        }catch (Exception e){
            e.printStackTrace();
        }

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
        if(Constant.WEBDRIVER.findElements(_lblLoginErrorMsg).size()!=0){
            return true;
        }
        return false;
    }

    public String getLoginPageTitle() {
        return getTitle("Login");
    }


    //check

}
