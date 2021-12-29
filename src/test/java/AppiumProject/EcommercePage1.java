package AppiumProject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class EcommercePage1 extends BaseClass {
	@Test
	public void page1() throws IOException
	//public static void main(String[] args) throws MalformedURLException, IOException 
	{
		AndroidDriver<AndroidElement>driver=capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByClassName("android.widget.EditText").sendKeys("lashya");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Afghanistan']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Denmark\"));").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
//		String toastMessage=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
//		System.out.println(toastMessage);
	}
}
