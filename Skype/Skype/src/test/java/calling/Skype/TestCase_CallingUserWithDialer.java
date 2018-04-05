package calling.Skype;

import org.testng.Assert;
import calling.Skype.BaseTestClass;
import pageObjects.DialerPage;
import pageObjects.DialerPageAndroid;
import pageObjects.LoginPage;
import pageObjects.LoginPageAndroid;

import org.testng.annotations.Test;

public class TestCase_CallingUserWithDialer extends BaseTestClass{

	protected LoginPage loginPage;

	protected DialerPage dialerPage;

	@Test(priority=3)
 
	public void makingACallThroughDialer() {
		
    	loginPage = new LoginPageAndroid(driver());
		
    	dialerPage = new DialerPageAndroid(driver());
		
		dialerPage.addNewCallButton();
		
		dialerPage.newCallButton();
		
		dialerPage.dialpadButton();
	}
		@Test(priority=4)
		
		public void dialNumber() {

		dialerPage.dialNumber("1234567890");
		
		String dialledNumber = dialerPage.getDialledNumber();
		
		Assert.assertEquals(dialledNumber, "1234567890"); 
		
		dialerPage.callBtn();
		
		loginPage.permission_allow_button();
		
		loginPage.permission_allow_button();

		loginPage.permission_allow_button();
		
		dialerPage.tapOnOKButton();

	  
  }
	@Test(priority=5)
	
	public void saveContact() {
		
		dialerPage.tapOnAddContactButton();
		
		dialerPage.enterContactName();
		
		dialerPage.tapOnSavePhoneNumber();
		
		dialerPage.backBtn();
		
		dialerPage.backBtn();
	
	}

	@Test(priority=6)
	
	public void searchContact() {
		
		dialerPage.tapSearchButton();
	
		dialerPage.enterSearchText();
		
		loginPage.HideKeyboard(); 
		
		dialerPage.backBtn();	
		
	}
		
	@Test(priority=7)
	
	public void scrollUp() {
		
		dialerPage.swipeUp();
		
	}
	
	@Test(priority=8)
	
	public void scrollDown() {
		
		dialerPage.swipeDown();
		
	}
	
	@Test(priority=9)

	public void getNumberOfRecords() {
		
		dialerPage.getNumberOfRecords();
		
	}
	
	@Test(priority=10)

	public void horizontalScroll() {
		
		dialerPage.getNumberOfRecords();
		
	}
	
	
	@Test(priority=11)
	
	public void signout() {
		
		loginPage.tapOnMenu();
		
		loginPage.tapSignout();
		
	}
	
}
