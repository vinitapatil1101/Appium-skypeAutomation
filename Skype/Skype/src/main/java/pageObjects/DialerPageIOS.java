package pageObjects;

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
import io.appium.java_client.ios.IOSDriver;

public class DialerPageIOS extends DialerPage {
	
	private IOSDriver<MobileElement> driver;
	private WebDriverWait wait;
	private TouchAction t;
	
	public DialerPageIOS(AppiumDriver<MobileElement> driver) {
		this.driver = (IOSDriver<MobileElement>) driver;
		this.wait = new WebDriverWait(this.driver, 10);
		t=new TouchAction(driver);
	}
private By addNewCall_Button = By.id("Calls");
	
	private By newCall_button = By.id("");
	
	private By dialpad_button = By.id("Use Dialpad");
		
	private By number_Zero = By.xpath("//XCUIElementTypeOther[@name='0']");
	
	private By number_One = By.xpath("//XCUIElementTypeOther[@name='1']");
	
	private By number_Two = By.xpath("//XCUIElementTypeOther[@name='2']");
	
	private By number_Three = By.xpath("//XCUIElementTypeOther[@name='3']");
	
	private By number_Four = By.xpath("//XCUIElementTypeOther[@name='4']");
	
	private By number_Five = By.xpath("//XCUIElementTypeOther[@name='5']");
	
	private By number_Six = By.xpath("//XCUIElementTypeOther[@name='6']");
	
	private By number_Seven = By.xpath("//XCUIElementTypeOther[@name='7']");
	
	private By number_Eight = By.xpath("//XCUIElementTypeOther[@name='8']");
	
	private By number_Nine = By.xpath("//XCUIElementTypeOther[@name='9']");
	
	private By dialledNumberText = By.id("(//XCUIElementTypeOther[@name='+91'])[4]");
	
	private By callBtn = By.id("//XCUIElementTypeOther[@name='Call'])");	
	
	private By okButton = By.id("");
		
	private By add_contact_btn = By.id("");
	
	private By name_add_contact = By.id("");
	
	private By phone_number_add_contact = By.id("");
	
	private By add_phone_number = By.id("");
	
	private By cancel_add_phone_number = By.id("");
	
	private By searchButton = By.id("");
	
	private By searchTextBox = By.id("");
	
	private By callLogCells = By.className("");
	
	private By backButton = By.xpath("");
	
	public boolean addnewButton() {
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

	@Override
	public boolean newCallButton() {
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

	@Override
	public boolean dialpadButton() {
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

	@Override
	public boolean callBtn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNewCallButton() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dialNumber(String number) {
		for(char digit : number.toCharArray()) {
		    pressNumber(digit);
		}
		
	}

	@Override
	public String getDialledNumber() {
		try {
			WebElement dialledNumberLabel = driver.findElement(dialledNumberText);
			return dialledNumberLabel.getText();
		} catch (NoSuchElementException e) {
			System.out.println("dialledNumberLabel is not found");
		}
		
		return null;
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

	@Override
	public boolean tapOnAddContactButton() {
		// wait.until(ExpectedConditions.presenceOfElementLocated(add_contact_btn));
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

	@Override
	public boolean tapOnOKButton() {

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

	@Override
	public boolean enterContactName() {
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

	@Override
	public boolean addContactNumber() {
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

	@Override
	public boolean tapOnSavePhoneNumber() {
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

	@Override
	public boolean canclePhoneNumber() {
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
	public boolean tapSearchButton() {
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

	@Override
	public boolean enterSearchText() {
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
	
	@Override
	public void swipeUp() {
		
		new TouchAction(driver).press(1600, 500).moveTo(600, 500).release().perform();
		System.out.println("Scroled UP");

		
	}

	@Override
	public void swipeDown() {
		new TouchAction(driver).press(500, 1500).moveTo(500, 600).release().perform();
		System.out.println("Scroled DOWN");
		
	}

	@Override
	public int getNumberOfRecords() {
List<MobileElement> callLog_Cells = driver.findElements(callLogCells);
		
		System.out.println("Total count of Active Chats are " + callLog_Cells.size());

		return callLog_Cells.size();
	}

}
