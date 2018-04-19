package mobileBaseClasses;
/**
 * @author Vinita Patil
 */
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import mobileBaseClasses.MobileController;
import mobileBaseClasses.MobileController.OS;

public class MobileController {
	//public static OS executionOS = OS.IOS;
	public static OS executionOS = OS.ANDROID;

	public enum OS {   
        ANDROID,
        IOS
    }
	public static MobileController instance = new MobileController();
    public AppiumDriver<MobileElement> driver;

    @SuppressWarnings("unchecked")
	public void start() throws MalformedURLException {
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
    	if (driver != null) {
            return;
        }
        switch(executionOS){
        case ANDROID:
            File classpathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classpathRoot, "/app/Android");
            File app = new File (appDir, "com.skype.m2.apk");
  
            capabilities.setCapability("automationName", "uiautomator2");    
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "NotUsed");
            capabilities.setCapability("app", app.getAbsolutePath());    
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.skype.m2");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.skype.m2.views.AppEntry");
        
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.1.1:4723/wd/hub"), capabilities);
          
            break;
        case IOS:
        	  capabilities.setCapability("platformName", "iOS");
        	  capabilities.setCapability("platformVersion" ,"10.3.3");
        	  capabilities.setCapability("deviceName", "Mandar Vaidya’s iPhone");
        	  capabilities.setCapability("udid", "79676db3d75f819ab96a6877d64ab476f5228961");
        	  capabilities.setCapability("automationName","XCUITest");
        	  capabilities.setCapability("bundleId", "com.skype.skype");
        	  capabilities.setCapability("showXcodeLog", "true");
        	  //capabilities.setCapability("autoWebview" , "true");
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            break;
    }
        
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
}

/*public void stop() {
    if (driver != null) {
        driver.quit();
        driver = null;
    }
} */
}
