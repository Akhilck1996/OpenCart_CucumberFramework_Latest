package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourStore_HomePage extends BasePage{

	public YourStore_HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") private WebElement lnk_MyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") private WebElement lnk_Register;
	@FindBy(xpath="//a[normalize-space()='Login']") private WebElement lnk_Login;
	
	
	//action methods
	public void clickMyAccount()
	{
		lnk_MyAccount.click();
		
	}
	
	public void clickRegister()
	{
		lnk_Register.click();
		
	}
	
	public void clickLnkLogin()
	{
		lnk_Login.click();
	}
	

}
