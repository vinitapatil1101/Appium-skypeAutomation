package pageObjects;

public abstract class DialerPage {

	public abstract boolean addNewCallButton();

	public abstract boolean newCallButton();
	
	public abstract boolean dialpadButton();
	
	public abstract boolean callBtn();

	public abstract void dialNumber(String string);

	public abstract String getDialledNumber();
	
	public abstract boolean tapOnAddContactButton(); 

	public abstract boolean tapOnOKButton();
	
	public abstract boolean enterContactName(); 
	
	public abstract boolean addContactNumber(); 
	
	public abstract boolean tapOnSavePhoneNumber();

	public abstract boolean canclePhoneNumber();

	public abstract boolean backBtn();

	public abstract boolean tapSearchButton();
	
	public abstract boolean enterSearchText();

	public abstract void swipeUp();
	
	public abstract void swipeDown();

	public abstract int getNumberOfRecords();


	
}
