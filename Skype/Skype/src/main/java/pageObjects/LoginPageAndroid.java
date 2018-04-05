package pageObjects;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Vinita Patil
 *
 */
public class LoginPageAndroid extends LoginPage
{
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;

	public LoginPageAndroid(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
		this.wait = new WebDriverWait(this.driver, 20);
		}

	  public By sign_in = By.xpath("//android.widget.Button[@text='Sign in']");
	  
	  public By create_Account= By.id("signup");
	
	  public By permission_allow_button = By.id("com.android.packageinstaller:id/permission_allow_button");
	 
	  public By user_name = By.xpath("//android.widget.EditText[@resource-id='i0116']");
	 
	  public By pass_word = By.xpath("//android.widget.EditText[@resource-id='i0118']");
		  
	  public By back_Button = By.xpath("//android.widget.Button[@resource-id='idBtn_Back']");
	  
	  public By next_button = By.xpath("//android.widget.Button[@resource-id='idSIButton9']");
	  
	  public By back_button_top = By.id("//android.widget.Button[@index='0']");
	  
	  public By user_image = By.xpath("//android.widget.Button[@index='0']");
	  
	  public By setting_button = By.xpath("//android.widget.Button[@index='2']");
	  
	  public By signout_button = By.xpath("//android.widget.LinearLayout[@index='4']");
	  
	  public By menuButton = By.xpath("//android.widget.ImageButton[@content-desc='Menu']");
	 
	  public By signout_buttonPopUpCancle = By.id("android:id/button2");
	  
	  public By skypeHeader = By.id("com.skype.m2:id/skypeLogoText");
	  
	  public boolean sign_in()
		{
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
	  
	 
	  
	  public boolean permission_allow_button()
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(permission_allow_button));
			try
			{
				WebElement permissionAllowButton = driver.findElement(permission_allow_button);
				permissionAllowButton.click();
				System.out.println("Permission Allow button has been clicked.");	

				return true;
			}
			catch (Exception e) 
			{
				System.out.println("Permission Allow button was not found");
				return false;
			}	
		}
	  
	  
	  /*Function to get username*/
	  @Override
	  public boolean UserName(String USERNAME)
	{
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
	/*Function to get password*/
	  @Override
	public boolean PassWord(String PASSWORD)
	{
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
	 public void HideKeyboard(){

		 driver.hideKeyboard();
	 }
	/*Function to login*/

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
		wait.until(ExpectedConditions.presenceOfElementLocated(menuButton));

		if (menuButton != null)
		{
			WebElement menuBtn = driver.findElement(menuButton);
			menuBtn.click();
			System.out.println("Hamburger Menu has been clicked");	
			return true;
		}
		else 
		{
			System.out.println("Hamburger Menu was not found");
		}
		return false;
		
	}
}
