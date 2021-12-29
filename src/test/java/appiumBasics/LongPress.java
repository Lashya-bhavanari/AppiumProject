package appiumBasics;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

import AppiumProject.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import this package because these not available here
//for tap
import static io.appium.java_client.touch.TapOptions.tapOptions;
//for element
import static io.appium.java_client.touch.offset.ElementOption.element;
//for longpress
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//for duration
import static java.time.Duration.ofSeconds;

import java.io.IOException;


	public class LongPress extends BaseClass {
	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement>driver=capabilities("ApiDemosApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	  //Tap event
		TouchAction t= new TouchAction(driver);
        WebElement tapEvent= driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		t.tap(tapOptions().withElement(element(tapEvent))).perform();
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		//LongPress
		WebElement LongPressEvent=driver.findElementByAndroidUIAutomator("text(\"People Names\")");
		t.longPress(longPressOptions().withElement(element(LongPressEvent)).withDuration(ofSeconds(2))).release().perform();
		//to verify is it displayed r not
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		 
		}

}
