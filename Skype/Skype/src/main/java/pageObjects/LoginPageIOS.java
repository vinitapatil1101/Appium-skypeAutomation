package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class LoginPageIOS extends LoginPage {

	private IOSDriver<MobileElement> driver;
	private WebDriverWait wait;
	
	public LoginPageIOS(AppiumDriver<MobileElement> driver) {
		this.driver = (IOSDriver<MobileElement>) driver;
		this.wait = new WebDriverWait(this.driver, 20);
	}
	  
	  public By sign_in = By.id("Sign In");
	  
	  public By create_Account= By.id("Create Account");
		 
	  public By user_name = By.name("i0116");
	 
	  public By pass_word = By.name("i0118");
		  	  
	  public By next_button = By.xpath("idSIButton9");
	  	  
	  public By user_image = By.xpath("");
	  
	  public By setting_button = By.xpath("");
	  
	  public By signout_button = By.xpath("Sign out");
	  
	  public By skypeHeader = By.id("My info");
	  
	@Override
	public boolean sign_in() {
		wait.until(ExpectedConditions.presenceOfElementLocated(sign_in));
		try
		{
			WebElement Sign_In = driver.findElement(sign_in);
			Sign_In.click();
			System.out.println("Sign In button has been clicked.");	
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("Sign In button was not found");
			return false;
		}	
	}

	@Override
	public boolean permission_allow_button() {
		try
		{
			
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
				
		}
			catch (InterruptedException e) {
				e.printStackTrace();
			} catch (NoAlertPresentException e ) {
				System.out.println("Notification permission alert is not displayed");
			
		}
		return false;	
	}
	
			
		
	@Override
	public boolean UserName(String USERNAME) {
		wait.until(ExpectedConditions.presenceOfElementLocated(user_name));
		try
		{
			WebElement usernameTextField = driver.findElement(user_name);
			System.out.println("username textfield is present");
			
			usernameTextField.clear();
			usernameTextField.sendKeys(USERNAME);
			System.out.println("username has been passed");				

			return true;
		}
		catch (Exception e) 
		{
			System.out.println("username textfield was not found");
			return false;
		}	
	}

	@Override
	public boolean PassWord(String PASSWORD) {
		//wait.until(ExpectedConditions.presenceOfElementLocated(pass_word));
				try
				{
					WebElement passwordTextField = driver.findElement(pass_word);
					System.out.println("password textfield is present");
					passwordTextField.clear();
					passwordTextField.sendKeys(PASSWORD);
					System.out.println("password  has been passed");				

					return true;
				}
				catch (Exception e) 
				{
					System.out.println("Password Text field was not found");
					return false;
				}	
	}

	
	@Override
	public void HideKeyboard() {
		 driver.hideKeyboard();

	}

	@Override
	public boolean LogIn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(next_button));
		try
		{
			WebElement log_In = driver.findElement(next_button);
			log_In.click();
			System.out.println("Login button has been clicked.");	
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("Login button was not found");
			return false;
		}	
	}

	@Override
	public String getSkypeHeaderIsPresent() {
		wait.until(ExpectedConditions.presenceOfElementLocated(skypeHeader));

		if (skypeHeader != null)
		{
			WebElement header = driver.findElement(skypeHeader);
			String skype_Header=header.getText();
			return skype_Header;
		}
		else 
		{
			System.out.println("Skype header cannot be located: User has not logged in");
		}
		return null;
		
	}

	@Override
	public boolean tapSignout() {
		wait.until(ExpectedConditions.presenceOfElementLocated(signout_button));

		if (signout_button != null)
		{
			WebElement signOut = driver.findElement(signout_button);
			signOut.click();
			System.out.println("User has been Signed Out Successfully!!!");	
			return true;
		}
		else 
		{
			System.out.println("User has not logged out");
		}
		return false;
		
	}

	@Override
	public boolean tapOnMenu() {
		// TODO Auto-generated method stub
		return false;
	}



	

}
