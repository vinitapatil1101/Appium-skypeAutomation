package calling.Skype;

import java.util.Map;

import org.testng.annotations.Test;

import calling.Skype.BaseTestClass;
import mobileLib.MobileConfigReader;
import mobileLib.MobileExcelDataConfig;

/**
 * Vinita patil Date: 11/03/2017.
 */
public class Testcase_Login extends BaseTestClass{
	
	protected MobileConfigReader config;
	protected MobileExcelDataConfig LoginDataSheet;
		
	@Test(priority=1)
	
	public void tapOnSignIn(){
		
		loginPage.sign_in();
		
		loginPage.permission_allow_button();
		
		loginPage.permission_allow_button();
		
	}
	
	@Test(dataProvider = "LoginData", dataProviderClass = dataProvider_Component.Dataprovider_Login.class,priority=2)

	public void loginSkype (Map cart)  throws Exception{
		
		config = new MobileConfigReader();
		
		LoginDataSheet= new MobileExcelDataConfig(config.LoginInputData(), "LoginData");
		//LoginReportSheet = new MobileExcelDataConfig(config.LoginReport(), "LoginReport");
		
		String SerialNo=cart.get("SerialNo").toString();
		String USERNAME=cart.get("USERNAME").toString();
		String PASSWORD=cart.get("PASSWORD").toString();
		Integer rowNo = Integer.valueOf(SerialNo); 
		
		System.out.println("The value of row no is "+rowNo);

		System.out.println("Executing the serial number "+SerialNo);
		
		loginPage.UserName(USERNAME); //Enter your Skype username password in LoginData Excelin Mobile Test Data Folder
		
		loginPage.LogIn();
		
		loginPage.PassWord(PASSWORD);
		
		loginPage.LogIn();
			
		if(loginPage.getSkypeHeaderIsPresent().equalsIgnoreCase("Skype Lite")) {
			System.out.println("User has logged in Successfully !!!!!");

		}
		
		else {
			System.out.println("User is not logged In...");

		}
		/*boolean flag = false;
		if(loginPage.Profile())	
		{
			flag = true;
		}
	//	if(logIn.Profile())	
		if(flag == true)
		{
			
			
			Thread.sleep(2000);
			loginPage.Setting();
			Thread.sleep(2000);

			loginPage.swipeUp();
			loginPage.swipeUp();

			loginPage.SignOut();
			System.out.println("inside loginTest... if condition");
			System.out.println("valid credentials");
			System.out.println("credentials accepted");
			
		}
		if(flag == false)
		{
			String Comment =loginPage.Error();
			System.out.println("The error message is... "+Comment);
			System.out.println("not able to login");      

		}	*/
	}

    }