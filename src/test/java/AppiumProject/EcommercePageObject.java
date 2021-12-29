package AppiumProject;



import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjectDemo.FormPage;
import pageObjectDemo.Utilities;

public class EcommercePageObject extends BaseClass {
	//public static void main(String[] args) throws InterruptedException, IOException 
	@Test
	public void complete() throws IOException, InterruptedException
	{
		AndroidDriver<AndroidElement>driver=capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		FormPage poh  = new FormPage(driver);
		poh.nameField.sendKeys("lashya");
		poh.genderOption.click();
		poh.shopOption.click();
		poh.country.click();
		Utilities u =new Utilities(driver);
		u.scrollToText("Algeria");//for scrolling 
//		driver.findElementByClassName("android.widget.EditText").sendKeys("lashya");
//		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
//		driver.findElementByXPath("//android.widget.TextView[@text='Afghanistan']").click();
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Algeria\"));").click();
//		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
//		
	
	}	
}
