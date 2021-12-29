package appiumBasics;
import java.io.IOException;

import AppiumProject.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Uiautomator extends BaseClass {
	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement>driver=capabilities("ApiDemosApp");
       driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
       driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
       System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().clickable(false)").getSize());
      
	}
}
