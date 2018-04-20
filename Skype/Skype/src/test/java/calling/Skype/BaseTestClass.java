package calling.Skype;

import java.io.File;

import org.testng.annotations.BeforeTest;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import mobileBaseClasses.MobileBaseClass;
import mobileBaseClasses.MobileController;
import mobileLib.MobileConfigReader;
import mobileLib.MobileExcelDataConfig;
import pageObjects.*;

public class BaseTestClass extends MobileBaseClass{
	
	protected LoginPage loginPage;
	
	protected DialerPage dialerPage;

	protected MobileConfigReader config;
	
	protected MobileExcelDataConfig LoginDataSheet;
	
	protected MobileExcelDataConfig LoginReportSheet;
	
	
	@BeforeTest
	public void setUp() throws Exception {
		
		//String Appium_Node_Path="C:/Program Files/Appium/node.exe";
		//String Appium_JS_Path="C:/Program Files/Appium/node_modules/appium/bin/appium.js";

		String Appium_Node_Path="/usr/local/bin/node.exe";
		String Appium_JS_Path="/usr/local/lib/node_modules/appium/build/lib/main.js";
		
		AppiumDriverLocalService appiumService;

		appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withIPAddress("127.0.1.1").
				usingPort(4723).usingDriverExecutable(new File(Appium_Node_Path)).
			                withAppiumJS(new File(Appium_JS_Path)));
		appiumService.start();
		
		MobileController.instance.start();
		switch (MobileController.executionOS) {
        case ANDROID:
        	
        	loginPage = new LoginPageAndroid(driver());
        
        	dialerPage = new DialerPageAndroid(driver());
      
        	break;
       
       case IOS:
        	
    	   	loginPage = new LoginPageIOS(driver());
        
            dialerPage = new DialerPageIOS(driver());
  
            break;

		}
	}
	/*@AfterTest
    public void tearDown() {
        MobileController.instance.stop();
    }*/
}
