package mobileBaseClasses;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
/**
 * @author Vinita Patil
 */
public abstract class MobileBaseClass {
	
	
	protected AppiumDriver<MobileElement> driver() {
        return MobileController.instance.driver;
    }
	
}
