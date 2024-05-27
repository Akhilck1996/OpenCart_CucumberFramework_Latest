package stepDefinations;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.AccountLoginPage;
import pageObjects.MyAccountPage;
import pageObjects.YourStore_HomePage;
import utilities.DataReader;

public class LoginStepDefinationclass {

	WebDriver driver;
	YourStore_HomePage ur_HP;
	AccountLoginPage alp;
	MyAccountPage map;
	
	List<HashMap<String,String>> datamap; //DataDriven
	
	@Given("User is taken to login page by clicking on my account and then on login")
	public void user_is_taken_to_login_page_by_clicking_on_my_account_and_then_on_login() {
	   ur_HP=new YourStore_HomePage(BaseClass.getDriver());
	   ur_HP.clickMyAccount();
	   ur_HP.clickLnkLogin();
	   BaseClass.getLogger().info("clicked on login");
	}

	@When("user enter email as {string} and pwd as {string}")
	public void user_enter_email_as_and_pwd_as(String email, String pwd) {
	   alp=new AccountLoginPage(BaseClass.getDriver());
	   alp.enterEmailAdress(email);
	   alp.enterPassword(pwd);
	   BaseClass.getLogger().info("entered email and pwd");
	}

	@When("then clicks on login button")
	public void then_clicks_on_login_button() {
	   alp.clickLoginBtn();
	   BaseClass.getLogger().info("clicked on login button");
	}

	@Then("user is taken to MyAccount page")
	public void user_is_taken_to_my_account_page() {
	   
		map=new MyAccountPage(BaseClass.getDriver());
		boolean status=map.isMyAccountDisplayed();
		Assert.assertEquals(status, true);
		BaseClass.getLogger().info("Completed the LogintoOpenCart.feature file Test Case");
		
	}


	@Then("user is taken to MyAccount page by entering the email and pwd from the excel file with excel row {string}")
	public void user_is_taken_to_my_account_page_by_entering_the_email_and_pwd_from_the_excel_file_with_excel_row(String rowNum) {
	    
		datamap=DataReader.data(".\\testData\\Opencart_LoginData.xlsx", "Sheet1");
		
		int index=Integer.parseInt(rowNum)-1;
		String email=datamap.get(index).get("username"); //username is the header name in excel sheet
		String pwd=datamap.get(index).get("password");
		String exp_res=datamap.get(index).get("res");
		
		AccountLoginPage alp= new AccountLoginPage(BaseClass.getDriver());
		alp.enterEmailAdress(email);
		alp.enterPassword(pwd);
		alp.clickLoginBtn();
		
		map=new MyAccountPage(BaseClass.getDriver());
		
		
		try {
		boolean status=map.isMyAccountDisplayed();
		
		
		if(exp_res.equals("Valid"))
		{
			if(status==true)
			{
				MyAccountPage map=new MyAccountPage(BaseClass.getDriver());
				map.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp_res.equals("Invalid"))
		{
			if(status==true)
			{
				map.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			Assert.assertTrue(false);
		}
		
	}






	
}
