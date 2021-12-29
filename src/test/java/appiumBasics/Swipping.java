package appiumBasics;

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

public class Swipping extends BaseClass {
	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement>driver=capabilities("ApiDemosApp");
       driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
       driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
       driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
       driver.findElementByXPath("//*[@content-desc='6']").click();
//       driver.findElementByXPath("//*[@content-desc='40']").click();
              TouchAction t= new TouchAction(driver);
       WebElement first=  driver.findElementByXPath("//*[@content-desc='15']");
       WebElement second=driver.findElementByXPath("//*[@content-desc='40']");
       t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
	}
}
