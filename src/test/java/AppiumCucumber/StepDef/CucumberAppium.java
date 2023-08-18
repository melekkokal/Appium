package AppiumCucumber.StepDef;

import Utils.CommonUtils;
import Utils.DriverHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CucumberAppium {


    AndroidDriver driver = CommonUtils.getDriver();

    @Given("I open the application")
    public void iOpenTheApplication() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Accessibility']")).isDisplayed());

    }

    @When("I tap on accesibility")
    public void iTapOnAccesibility() {
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();

    }

    @Then("I validate Custom View")
    public void iValidateCustomView() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue("Custom View is not displayed."
                        , driver.findElement(By.xpath("//android.widget.TextView[@text='Custom View']")).isDisplayed());
    }

}
