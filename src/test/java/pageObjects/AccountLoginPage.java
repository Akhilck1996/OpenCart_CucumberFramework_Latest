package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage{

	public AccountLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//input[@id='input-email']") private WebElement input_EmailAdress;
	@FindBy(xpath="//input[@id='input-password']") private WebElement input_Password;
	
	
	@FindBy(xpath="//input[@value='Login']") private WebElement btn_Login;
	
	
	
	
	public void enterEmailAdress(String email)
	{
		input_EmailAdress.sendKeys(email);
		
	}
	
	public void enterPassword(String pwd)
	{
		input_Password.sendKeys(pwd);
	}
	
	public void clickLoginBtn()
	{
		btn_Login.click();
	}
	
	

}
