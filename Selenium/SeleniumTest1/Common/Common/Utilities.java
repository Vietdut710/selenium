package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

    public static String getProjectPath()
    {
        return System.getProperty("user.dir");
    }

    public static void setupMaximumScreen(){
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void gotoRailway(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public static void closeBrowser(){
        Constant.WEBDRIVER.quit();
    }

    public static void chooseBrowserDriver(String browserName){

        switch (browserName){

            case "Chrome" :
                System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()+"\\SeleniumTest1\\Executables\\chromedriver.exe");
                Constant.WEBDRIVER = new ChromeDriver();
                Constant.ACTIONS = new Actions(Constant.WEBDRIVER);
                break;

            case "Firefox":
                System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath()+"\\SeleniumTest1\\Executables\\geckodriver.exe");
                Constant.WEBDRIVER = new FirefoxDriver();
                Constant.ACTIONS = new Actions(Constant.WEBDRIVER);
                break;

            case "Edge":
                Constant.WEBDRIVER = new EdgeDriver();
                break;

            case "Opera":
                Constant.WEBDRIVER = new OperaDriver();
                break;

            case "Internet Explorer":
                Constant.WEBDRIVER = new InternetExplorerDriver();
                break;

        }



    }

    public static void waiForControl(By element, int time)
    {
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER,time);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


}