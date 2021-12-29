package appiumBasics;

import AppiumProject.BaseClass;

import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics extends BaseClass {
	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement>driver=capabilities("ApiDemosApp");
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		//Using Uiautomator finding element
		 driver.findElementByAndroidUIAutomator("text(\"Preference\")").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		
		
	}
}
