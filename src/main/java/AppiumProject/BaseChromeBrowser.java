package AppiumProject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseChromeBrowser {
public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

	
	DesiredCapabilities capabilities= new DesiredCapabilities();
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	//Here no need to use apk file because u r working on browsers
	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
	
	
	AndroidDriver<AndroidElement>driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	return driver;
}

}
