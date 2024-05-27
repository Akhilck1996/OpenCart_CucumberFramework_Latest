package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//h2[normalize-space()='My Account']") private WebElement status_MyAccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") private WebElement lnk_Logout;
	
	public boolean isMyAccountDisplayed()
	{
		try {
		boolean status=status_MyAccount.isDisplayed();
		return status;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void clickLogout()
	{
		lnk_Logout.click();
		
	}
	
	
	
	
	
}
