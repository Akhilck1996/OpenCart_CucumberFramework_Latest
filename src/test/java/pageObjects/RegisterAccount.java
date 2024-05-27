package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccount extends BasePage{

	public RegisterAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//input[@id='input-firstname']") private WebElement input_FirstName;
	@FindBy(xpath="//input[@id='input-lastname']") private WebElement input_LastName;
	@FindBy(xpath="//input[@id='input-email']") private WebElement input_Email;
	@FindBy(xpath="//input[@id='input-telephone']") private WebElement input_telephone;
	
	@FindBy(xpath="//input[@id='input-password']") private WebElement input_Password;
	@FindBy(xpath="//input[@id='input-confirm']") private WebElement input_ConfirmPassword;
	@FindBy(xpath="//input[@name='agree']") private WebElement chk_PrivacyPolicy;
	@FindBy(xpath="//input[@value='Continue']") private WebElement btn_Continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") private WebElement confirmationMSG;
	
	public void fillPersonalDetails(String fname,String lname,String email, String telephone)
	{
		input_FirstName.sendKeys(fname);
		input_LastName.sendKeys(lname);
		input_Email.sendKeys(email);
		input_telephone.sendKeys(telephone);
	}
	
	public void enterPassword(String pwd)
	{
		input_Password.sendKeys(pwd);
		input_ConfirmPassword.sendKeys(pwd);
		
	}
	
	public void clickCheckBox()
	{
		chk_PrivacyPolicy.click();
	}
	
	public void clickContinueBtn()
	{
		btn_Continue.click();
		
	}
	
	public String getConfirmationMsgAccCreated()
	{
		String msg=confirmationMSG.getText();
		return msg;
	}
	
	
	
}
