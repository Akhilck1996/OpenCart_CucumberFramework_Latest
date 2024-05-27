package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

	WebDriver driver;
	Properties pro;
	
	@Before
	public void setup() throws IOException
	{
		driver=BaseClass.intializeBrowser();
		
		pro=BaseClass.getProperties();
		
		driver.get(pro.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			
			byte[] screenshot= ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png", scenario.getName());
		}
		
	}
	
	
	
}
