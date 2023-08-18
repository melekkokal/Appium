package AppiumIntro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.aspectj.weaver.ast.And;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServerConnection {

    @Test
    public void connectServer() throws MalformedURLException, InterruptedException {
    File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "MyDevice");
        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());
        URL appiumServerUrl = new URL ("http://0.0.0.0:4723/wd/hub");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(appiumServerUrl, desiredCapabilities);

        AndroidElement appButton = driver.findElement(By.xpath("//android.widget.TextView[@text='App']"));
        appButton.click();
        AndroidElement alarmButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']"));
        alarmButton.click();
        AndroidElement alarmControllerButton= driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm Controller']"));
        alarmControllerButton.click();
        AndroidElement firstOption=driver.findElement(By.xpath("//android.widget.Button[@text='ONE SHOT ALARM']"));
        Assert.assertEquals("ONE SHOT ALARM", firstOption.getText());

        //another option:
        List<AndroidElement> listOfButtons =driver.findElements(By.className("android.widget.button"));
        AndroidElement firstButton=listOfButtons.get(0);
        Assert.assertEquals("ONE SHOT ALARM", firstButton.getText());

    }

//    @Test
//    public void connectServer(){
//        File apkFile=new File()
//    }
}
