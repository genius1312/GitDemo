package Academy.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.LandingPage;
import resources.base;


public class validateTitle extends base {
	
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(validateTitle.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initalizeDriver();
		Log.info("Driver is initialized");
    	driver.get(pro.getProperty("url"));
    	Log.info("Navigate to qaclickacademy site");
	}
	
    @Test
	public void validatinghomepagetitle() throws IOException
	{
    	
    	LandingPage lp = new LandingPage(driver);
    	Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
        System.out.println("demo demo demo");    	
    	Log.info("Title is displayed");
    	
    	
    }
    
    @AfterTest
    public void teardown()
    {
    	driver.close();
    }
	
}