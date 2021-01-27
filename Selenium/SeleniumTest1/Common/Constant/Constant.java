package Common.Constant;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Constant {
    public static final String RAILWAY_URL = "http://www.railwayqa.somee.com/";
    public static final String USERNAME = getAdmin("username");
    public static final String PASSWORD = getAdmin("password");
    public static WebDriver WEBDRIVER;
    public static Actions ACTIONS ;

    private static String getAdmin(String value) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "\\SeleniumTest1\\DataObject\\AdminAccount.json"));
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
