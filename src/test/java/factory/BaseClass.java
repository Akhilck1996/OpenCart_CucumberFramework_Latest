package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

	static WebDriver driver;
	static Properties pro;
	static Logger log;
	
	
	public static WebDriver intializeBrowser() throws IOException
	{
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capablities=new DesiredCapabilities();
			
			//first we are setting the desired os
			if(getProperties().getProperty("os").equalsIgnoreCase("windows"))
			{
				capablities.setPlatform(Platform.WIN10);
			}
			else if(getProperties().getProperty("os").equalsIgnoreCase("mac"))
			{
				capablities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching OS");
			}
			
			//setting the browser
			switch(getProperties().getProperty("browser").toLowerCase())
			{
			case "chrome":
				capablities.setBrowserName("chrome");break;
			case "edge":
				capablities.setBrowserName("edge");break;
			default: System.out.println("No matching browser");
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capablities);
		}
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(getProperties().getProperty("browser").toLowerCase())
			{
			case "chrome":
			driver=new ChromeDriver();break;
			case "edge":
			driver=new EdgeDriver();break;
			default:
				System.out.println("No matching browser");
				driver=null;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		
		return driver;
		
	}
	
	
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static Properties getProperties() throws IOException
	{
		FileReader fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		
		pro=new Properties();
		pro.load(fr);
		return pro;
	}
	
	public static Logger getLogger()
	{
		log=LogManager.getLogger();
		return log;
		
	}
	
	public static String generateRandomString()
	{
		String randomText=RandomStringUtils.randomAlphabetic(5);
		return randomText;
		
	}
	
	public static String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
		
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	 String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}
	
	
}
