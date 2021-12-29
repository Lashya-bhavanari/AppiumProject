package pageObjectDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
 public FormPage(AndroidDriver<AndroidElement> driver)
 {
	 PageFactory.initElements(new AppiumFieldDecorator(driver),this);
 }
 //driver.findElementByClassName("android.widget.EditText").sendKeys("lashya");
 @AndroidFindBy(className="android.widget.EditText")
 public WebElement nameField;
 //driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
 @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
 public WebElement genderOption;
 //driver.findElementByXPath("//android.widget.TextView[@text='Afghanistan']").click();
 @AndroidFindBy(xpath="//android.widget.TextView[@text='Afghanistan']")
 public WebElement country;
 //driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
 @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
 public WebElement shopOption;
}
