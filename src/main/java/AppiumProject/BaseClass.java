package AppiumProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	public static AndroidDriver<AndroidElement> driver;	
public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException
{
	
	//for changing native to web use below hashmap
	HashMap <String,Boolean> map=new HashMap<String,Boolean>();
			map.put("w3c", false);
	//by this we can get the current project path dynamically by this method		
	//System.getProperty("user.dir");
	//declaring the file
    FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");	
    Properties prop=new Properties();
    prop.load(fis);//gobal properties file path
   
	
	File appDir= new File("src");
	File app= new File(appDir, (String) prop.get(appName));// prop.get("appName");//it will retrive the value present in that key
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	String device=(String) prop.get("device");
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
	capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
	capabilities.setCapability("appium:chromeOptions",Map.of("w3c",false));
	driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
return driver;
}
//for getting screenshot of failed testcases
public static void getScreenShot(String screenshot) throws IOException
{
 File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//by this TakesScreenshot driver will changes its mode to take screenshot
 FileHandler.copy(srcfile, new File(System.getProperty("user.dir")+"\\"+screenshot+".png"));//copyFile(srcfile,new File("C:\\Users\\Dell\\eclipse-workspac\\AppiumProject\\src\\test\\java\\screenshot.png");
}

}
