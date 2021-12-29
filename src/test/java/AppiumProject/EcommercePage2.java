package AppiumProject;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommercePage2 extends BaseClass {
	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement>driver=capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByClassName("android.widget.EditText").sendKeys("lashya");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Afghanistan']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\"Jordan Lift Off\"));");
		//to click add to cart
		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
		for(int i=0;i<count;i++) {
			String text=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			  if(text.equalsIgnoreCase("Jordan Lift Off"))
			  {
				  driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click(); 
				  break;
			  }
		} 
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		String cartProducts=driver.findElementById("com.androidsample.generalstore:id/productName").getText();
		//Assert.assertEquals("Jordan Lift Off", cartProducts);//for validating
	}
	
}
