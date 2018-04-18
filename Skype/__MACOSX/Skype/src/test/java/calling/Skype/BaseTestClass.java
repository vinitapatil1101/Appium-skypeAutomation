package calling.Skype;

import org.testng.annotations.BeforeTest;

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
