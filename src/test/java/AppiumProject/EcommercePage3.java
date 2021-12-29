package AppiumProject;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//for tap
import static io.appium.java_client.touch.TapOptions.tapOptions;
//for element
import static io.appium.java_client.touch.offset.ElementOption.element;
//for longpress
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//for duration
import static java.time.Duration.ofSeconds;

import java.io.IOException;

public class EcommercePage3 extends BaseClass {
	public static void main(String[] args) throws InterruptedException, IOException {
		AndroidDriver<AndroidElement>driver=capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByClassName("android.widget.EditText").sendKeys("lashya");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Afghanistan']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(4000);
		int count=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sum=0;
		for(int i=0;i<count;i++) {
			String amount1=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			double amount=getAmount(amount1);
			sum=sum+amount;
		}
		System.out.println("sum is"+sum);
		String total=driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		double amount=getAmount(total);
		System.out.println("totalValue is"+amount);
		Assert.assertEquals(sum, amount);
		//Mobile gestures
		WebElement checkBox=driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t= new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkBox))).perform();
		
		WebElement longPress = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
		t.longPress(longPressOptions().withElement(element(longPress)).withDuration(ofSeconds(2))).release().perform();
		driver.findElementById("android:id/button1").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
	}
	public static double getAmount(String value) {
	value= value.substring(1);
	double amount=Double.parseDouble(value);
	return amount;
	}
}
