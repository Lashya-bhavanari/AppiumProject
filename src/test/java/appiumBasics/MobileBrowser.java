package appiumBasics;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import AppiumProject.BaseChromeBrowser;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBrowser extends BaseChromeBrowser {
	public static void main(String args[]) throws MalformedURLException {
		AndroidDriver<AndroidElement>driver=capabilities();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElementByCssSelector(".navbar-toggler").click();
		driver.findElementByCssSelector("a[href*='products']").click();
		JavascriptExecutor js= (JavascriptExecutor)driver;//to execute javascript we are depending on JavascriptExecutor
		js.executeScript("window.scrollBy(0,1000)", "");//for scrolling in windows//browser is developed using javascript,so we are using javascript here

		String text =driver.findElementByXPath("(//li[@class='list-group-item'])[3]/div/div/a").getText();
		Assert.assertEquals(text, "Devops");
	}

}
