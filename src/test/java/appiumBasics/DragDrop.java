package appiumBasics;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import AppiumProject.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//for element
import static io.appium.java_client.touch.offset.ElementOption.element;
//for longpress
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//for duration
import static java.time.Duration.ofSeconds;

import java.io.IOException;

public class DragDrop extends BaseClass {
	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement>driver=capabilities("ApiDemosApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
       driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
       TouchAction t= new TouchAction(driver);
       WebElement sourse= driver.findElementsByClassName("android.view.View").get(0);
       WebElement destination= driver.findElementsByClassName("android.view.View").get(1);
      t.longPress(longPressOptions().withElement(element(sourse)).withDuration(ofSeconds(2))).moveTo(element(destination)).release().perform();
       //t.longPress(element(sourse)).moveTo(element(destination)).release().perform();

	}
	
}
