package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


public class DialerPageAndroid extends DialerPage{
	
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;
	private TouchAction t;
	
	public DialerPageAndroid(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
		this.wait = new WebDriverWait(this.driver, 10);
		t=new TouchAction(driver);
		}
	
	private By addNewCall_Button = By.id("com.skype.m2:id/hub_fab_main");
	
	private By newCall_button = By.id("com.skype.m2:id/hub_fab_new_call");
	
	private By dialpad_button = By.xpath("//android.widget.TextView[@text='Dial pad']");
		
	private By number_Zero = By.xpath("//android.widget.TextView[@text='0']");
	
	private By number_One = By.xpath("//android.widget.TextView[@text='1']");
	
	private By number_Two = By.xpath("//android.widget.TextView[@text='2']");
	
	private By number_Three = By.xpath("//android.widget.TextView[@text='3']");
	
	private By number_Four = By.xpath("//android.widget.TextView[@text='4']");
	
	private By number_Five = By.xpath("//android.widget.TextView[@text='5']");
	
	private By number_Six = By.xpath("//android.widget.TextView[@text='6']");
	
	private By number_Seven = By.xpath("//android.widget.TextView[@text='7']");
	
	private By number_Eight = By.xpath("//android.widget.TextView[@text='8']");
	
	private By number_Nine = By.xpath("//android.widget.TextView[@text='9']");
	
	private By plus_button = By.xpath("//android.widget.TextView[@index='0']");
	
	private By dialledNumberText = By.id("com.skype.m2:id/dialpad_edit_text");
	
	private By callBtn = By.id("com.skype.m2:id/dialpad_call_button");	
	
	private By okButton = By.id("android:id/button1");
		
	private By add_contact_btn = By.id("com.skype.m2:id/add_contact_btn");
	
	private By name_add_contact = By.id("com.skype.m2:id/name_add_contact");
	
	private By phone_number_add_contact = By.id("com.skype.m2:id/phone_number_add_contact");
	
	private By add_phone_number = By.id("android:id/button1");
	
	private By cancel_add_phone_number = By.id("android:id/button2");
	
	private By searchButton = By.id("com.skype.m2:id/menu_chat_symbol");
	
	private By searchTextBox = By.id("com.skype.m2:id/search_edit_text");
	
	private By callLogCells = By.className("android.widget.RelativeLayout");
	
	private By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	
	public boolean addNewCallButton() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(addNewCall_Button));
		try 
		{
			WebElement hubtab_header_title = driver.findElement(addNewCall_Button);
			hubtab_header_title.click();
			System.out.println("Add New Button has been clicked");
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("Add New button was not found");
			return false;
		}
	}
	
	public boolean newCallButton() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(newCall_button));
		try 
		{
			WebElement hubfab_main = driver.findElement(newCall_button);
			hubfab_main.click();
			System.out.println("New Call button has been clicked");
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("New Call button was not found");
			return false;
		}
	}
	public boolean dialpadButton() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(dialpad_button));
		try 
		{
			WebElement hub_fabdialpad = driver.findElement(dialpad_button);
			hub_fabdialpad.click();
			System.out.println("Dialpad button has been clicked");
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("Dialpad button was not found");
			return false;
		}
	}
	
public String getDialledNumber() {
		
		try {
			WebElement dialledNumberLabel = driver.findElement(dialledNumberText);
			return dialledNumberLabel.getText();
		} catch (NoSuchElementException e) {
			System.out.println("dialledNumberLabel is not found");
		}
		
		return null;
	}
	
	public void dialNumber(String number) {
		for(char digit : number.toCharArray()) {
		    pressNumber(digit);
		}
	}
	
public void pressNumber(char digit) {
		
		switch (digit) {
		case '1':
			WebElement number_1 = driver.findElement(number_One);
			number_1.click();
			break;
		case '2':
			WebElement number_2 = driver.findElement(number_Two);
			number_2.click();
			break;
		case '3':
			WebElement number_3 = driver.findElement(number_Three);
			number_3.click();
			break;
		case '4':
			WebElement number_4 = driver.findElement(number_Four);
			number_4.click();
			break;
		case '5':
			WebElement number_5 = driver.findElement(number_Five);
			number_5.click();
			break;
		case '6':
			WebElement number_6 = driver.findElement(number_Six);
			number_6.click();
			break;
		case '7':
			WebElement number_7 = driver.findElement(number_Seven);
			number_7.click();
			break;
		case '8':
			WebElement number_8 = driver.findElement(number_Eight);
			number_8.click();
			break;
		case '9':
			WebElement number_9 = driver.findElement(number_Nine);
			number_9.click();
			break;
		case '0':
			WebElement number_0 = driver.findElement(number_Zero);
			number_0.click();
			break;
		case '+':
			WebElement number_Plus = driver.findElement(number_Zero);
			new TouchAction(driver).longPress(number_Plus).perform();
			break;
		case '*':
			WebElement number_Star = driver.findElement(number_One);
			number_Star.click();
			break;
		case '#':
			WebElement number_Hash = driver.findElement(number_One);
			number_Hash.click();
			break;
		}
	}

	public boolean tapOnOKButton() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
		try 
			{
				WebElement ok_btn = driver.findElement(okButton);
				ok_btn.click();
				System.out.println("OK button has been clicked.");
				return true;
		
			}
		catch (Exception e) 
		{
			System.out.println("OK button was not found.");
		}
	return false;
}
	public boolean tapOnAddContactButton() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(add_contact_btn));
		try 
		{
			WebElement add_contactButton = driver.findElement(add_contact_btn);
			add_contactButton.click();
			System.out.println("ADD Contact button has been clicked.");
			return true;
			
		}
		catch (Exception e) 
		{
			System.out.println("ADD Contact button was not found.");
		}
		return false;
	}
	 
	public boolean enterContactName() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(name_add_contact));
		try 
		{
			WebElement name_addContact = driver.findElement(name_add_contact);
			name_addContact.sendKeys("TestContact");
			System.out.println("New Contact Name is added.");
			return true;
			
		}
		catch (Exception e) 
		{
			System.out.println("Contact Name textbox was not found.");
		}
		return false;
	}
	
	public boolean addContactNumber() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(phone_number_add_contact));
		try 
		{
			WebElement phone_number = driver.findElement(phone_number_add_contact);
			phone_number.sendKeys("1234567890");
			System.out.println("New Contact Number is added.");
			return true;
			
		}
		catch (Exception e) 
		{
			System.out.println("Contact Number textbox was not found.");
		}
		return false;
	}
	
	public boolean tapOnSavePhoneNumber() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(add_phone_number));
		try 
		{
			WebElement save_phone_number = driver.findElement(add_phone_number);
			save_phone_number.click();
			System.out.println("ADD button has been clicked.");
			return true;
			
		}
		catch (Exception e) 
		{
			System.out.println("ADD button was not found.");
		}
		return false;
	}
	
	public boolean canclePhoneNumber() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(cancel_add_phone_number));
		try 
		{
			WebElement cancelphone_number = driver.findElement(cancel_add_phone_number);
			cancelphone_number.click();
			System.out.println("Cancel button has been clicked.");
			return true;
			
		}
		catch (Exception e) 
		{
			System.out.println("Cancel button was not found.");
		}
		return false;
	}
	@Override
	public boolean callBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(callBtn));
		try 
		{
			WebElement call_Btn = driver.findElement(callBtn);
			call_Btn.click();
			System.out.println("Call button has been clicked.");
			return true;
			
		}
		catch (Exception e) 
		{
			System.out.println("Call button was not found.");
		}
		return false;
	}
	
	public boolean tapSearchButton() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(searchButton));
		try 
		{
			WebElement search_Button = driver.findElement(searchButton);
			search_Button.click();
			System.out.println("Search button has been clicked");
			return true;
			
		}
		catch (Exception e) 
		{
			System.out.println("Search button was not found.");
		}
		return false;
	}
	
	public boolean enterSearchText() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(searchTextBox));
		try 
		{
			WebElement search_TextBox = driver.findElement(searchTextBox);
			search_TextBox.sendKeys("TestContact");
			System.out.println("Search Text has been Entered");
			return true;
			
		}
		catch (Exception e) 
		{
			System.out.println("Search TextBox was not found.");
		}
		return false;
	}
	@Override
	public boolean backBtn() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(backButton));
		try 
		{
			WebElement back_Button = driver.findElement(backButton);
			back_Button.click();
			System.out.println("Back button has been clicked.");
			return true;
			
		}
		catch (Exception e) 
		{
			System.out.println("Back button has been clicked.");
		}
		return false;

	}

	
	/*public int getNumberOfRecords() {
		
		List<MobileElement> getCount= (List<MobileElement>) driver.findElement(chatListCell);
		
		return ((List<MobileElement>) chatListCell).size();
		
		
	}*/
	
	public int getNumberOfRecords() {
		
		List<MobileElement> callLog_Cells = driver.findElements(callLogCells);
		
		System.out.println("Total count of Active Chats are " + callLog_Cells.size());

		return callLog_Cells.size();
		
		
	}

	
	public void horizontalScroll() {
		
		new TouchAction(driver).longPress(930, 1200, Duration.ofSeconds(4)).moveTo(100, 1300).release().perform();

		new TouchAction(driver).longPress(100, 1300, Duration.ofSeconds(4)).moveTo(930, 1200).release().perform();

	}
	
	public void swipeUp() {
		
		new TouchAction(driver).press(1600, 500).moveTo(600, 500).release().perform();
		System.out.println("Scroled UP");

	}
	
	public void swipeDown() {
		new TouchAction(driver).press(500, 1500).moveTo(500, 600).release().perform();
		System.out.println("Scroled DOWN");

	}
}
