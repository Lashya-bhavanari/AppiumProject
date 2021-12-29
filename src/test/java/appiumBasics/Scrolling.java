package appiumBasics;
import java.io.IOException;


import AppiumProject.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scrolling extends BaseClass {
	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement>driver=capabilities("ApiDemosApp");
       driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
       driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView3\"));");
       
	}
}
