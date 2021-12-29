package AppiumProject;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class EcommerceWebview extends BaseClass {
	//public static void main(String[] args) throws InterruptedException, IOException 
	@Test
	public void ecommerce() throws IOException, InterruptedException
	{
		AndroidDriver<AndroidElement>driver=capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByClassName("android.widget.EditText").sendKeys("lashya");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Afghanistan']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Algeria\"));").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(4000);
		//Mobile gestures
				WebElement checkBox=driver.findElementByClassName("android.widget.CheckBox");
				TouchAction t= new TouchAction(driver);
				t.tap(tapOptions().withElement(element(checkBox))).perform();
				
				driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
				Thread.sleep(3000);
		   Set<String> contextNames  = driver.getContextHandles();
		for(String contextName:contextNames) {
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElementByName("q").sendKeys("Hi Lashya");
		driver.findElementByName("q").sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");//By this we can get back to native app
		
	}	
}
