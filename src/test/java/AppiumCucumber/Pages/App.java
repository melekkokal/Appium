package AppiumCucumber.Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class App {

    public App(AndroidDriver driver){
        PageFactory.initElements(driver, this);
    }
}
