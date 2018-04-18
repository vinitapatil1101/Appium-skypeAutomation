package pageObjects;

public abstract class LoginPage {
	
	public abstract boolean sign_in();
	
	public abstract boolean permission_allow_button();
	
	public abstract void HideKeyboard();
	
	public abstract boolean LogIn();

	public abstract boolean UserName(String USERNAME);

	public abstract boolean PassWord(String PASSWORD);

	public abstract String getSkypeHeaderIsPresent();

	public abstract boolean tapSignout();
	
	public abstract boolean tapOnMenu();

	
	
}
