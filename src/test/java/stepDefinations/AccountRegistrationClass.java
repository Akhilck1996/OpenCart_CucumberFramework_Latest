package stepDefinations;

import java.util.Map;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterAccount;
import pageObjects.YourStore_HomePage;

public class AccountRegistrationClass {

	YourStore_HomePage urStore_Hp;
	RegisterAccount reg;
	
	

	@Given("user is taken to Registration page on clicking on MyAccount and then on Register link")
	public void user_is_taken_to_registration_page_on_clicking_on_my_account_and_then_on_register_link() {
	   urStore_Hp=new YourStore_HomePage(BaseClass.getDriver());
	   
	   urStore_Hp.clickMyAccount();
	   urStore_Hp.clickRegister();
		
		
	}
	@When("user Enters all the below details")
	public void user_enters_all_the_below_details(io.cucumber.datatable.DataTable dataTable) {
	   
		Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
		
		reg=new RegisterAccount(BaseClass.getDriver());
		
		reg.fillPersonalDetails(dataMap.get("FrstName"),dataMap.get("LstName") , BaseClass.generateRandomString()+"@gmail.com",dataMap.get("Telphone"));
		reg.enterPassword(dataMap.get("Password"));	
		
	}
	@When("clicks on PrivacyPolicy CheckBox")
	public void clicks_on_privacy_policy_check_box() {
	   reg.clickCheckBox();	
	}
	@When("Clicks on Contiue button")
	public void clicks_on_contiue_button() {
	   reg.clickContinueBtn();
	}
	@Then("User account is Succesfully register")
	public void user_account_is_succesfully_register() {
	    String text=reg.getConfirmationMsgAccCreated();
	    
	    Assert.assertEquals(text, "Your Account Has Been Created!");
	    
	}



	
}
