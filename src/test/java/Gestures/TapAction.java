package Gestures;

import Utils.CommonUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TapAction {

    @Test
    public void tapTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MyDevice");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                new File("src/test/resources/ApiDemos-debug-newVersion.apk").getAbsolutePath());
        URL appiumServer = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServer,desiredCapabilities);

        //tap action class
        AndroidElement contentButton =
                driver.findElement(By.xpath("//android.widget.TextView[@text='Content']"));
        TouchAction action = new TouchAction<>(driver);
        action.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(contentButton)))
                    .perform();

    }
    //Using tap action navigate to
    //Views -> Expandable List -> Custom Adaptor.
    @Test
    public void longPress(){
        AndroidDriver<AndroidElement> driver = CommonUtils.getDriver();
        AndroidElement views= driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        CommonUtils.elementTap(driver,views);
        AndroidElement expandableList= driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']"));
        CommonUtils.elementTap(driver,expandableList);
        AndroidElement customAdapter= driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));
        CommonUtils.elementTap(driver,customAdapter);

        //wild card ==*
        AndroidElement peopleName=driver.findElement(By.xpath("//*[@text='People Names']"));
        TouchAction touchAction=new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(peopleName))
                .withDuration(Duration.ofSeconds(2))).perform();

        //closes a pop up/goes back on the page.
        driver.pressKey(new KeyEvent(AndroidKey.BACK));


        AndroidElement fishNames = driver.findElement(By.xpath("//*[@text='Fish Names']"));
        CommonUtils.longPress(driver, fishNames,2);
    }

    @Test
    public void scrollTest(){
        AndroidDriver<AndroidElement> driver = CommonUtils.getDriver();
        AndroidElement viewsButton=driver.findElementByAccessibilityId("Views");
        CommonUtils.elementTap(driver,viewsButton);

        AndroidElement scrollBarsButton = driver. findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextClock\"))");
    }

}
