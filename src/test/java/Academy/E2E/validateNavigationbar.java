package Academy.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.LandingPage;
import resources.base;


public class validateNavigationbar extends base {
	
	public static Logger Log = LogManager.getLogger(validateNavigationbar.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initalizeDriver();
    	driver.get(pro.getProperty("url"));
	}
    @Test
	public void validatingnavigationbar() throws IOException
	{
    	
    	LandingPage lp = new LandingPage(driver);
    	Assert.assertTrue(lp.getNavbar().isDisplayed());
    	Log.info("Navigation bar is displayed");
    	System.out.println("Navigation bar is displayed123");
    	
    }
    
    @AfterTest
    public void teardown()
    {
    	driver.close();
    }
	
}