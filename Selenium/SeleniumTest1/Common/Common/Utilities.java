package Common.Common;

import Common.Constant.Constant;
import com.google.gson.*;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Objects;

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

                break;

            case "Firefox":
                System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath()+"\\SeleniumTest1\\Executables\\geckodriver.exe");
                Constant.WEBDRIVER = new FirefoxDriver();

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

    public static void waitForControl(By element, int time)
    {
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER,time);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public static void waitForStep(By element ,int time)
    {
        try{
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER,time);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(element));}
        catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    public static Object[][] getData(String dataFilePath, String testCaseName) throws IOException {
        Object[][] data;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(dataFilePath));
        JsonElement jsonElement = new JsonParser().parse(bufferedReader);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonArray jsonArray = jsonObject.getAsJsonArray(testCaseName);
        data = convertJsonArrayToObjectArray(jsonArray);
        System.out.println(data);
        return data;

    }

    public static Object[][] convertJsonArrayToObjectArray(JsonArray jsonArray){
        Object[][] data = new Object[0][1];
        Gson gson = new Gson();
        int index = 0;

        if (jsonArray.size()>0){
            data = new Object[jsonArray.size()][1];
            for (Object obj : jsonArray){
                Hashtable<String, String> hashtable = new Hashtable<String, String>();
                data[index][0] = gson.fromJson((JsonElement) obj, hashtable.getClass());
                index++;
            }
        }
        return data;


    }

}
