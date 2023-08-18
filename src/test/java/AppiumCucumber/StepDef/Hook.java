package AppiumCucumber.StepDef;

import Utils.BrowserUtils;
import Utils.CommonUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Hook {
    private static WebDriver driver;


    @Before("@web")
    public void setup(){

        driver.get(ConfigReader.readProperty("QA_smartbear_url"));
    }

    @Before("@appium")
    public void setUpAppium() {
        CommonUtils.getDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        //BrowserUtils.getScreenShotForCucumber(driver, scenario);
        //driver.quit();
    }
}
