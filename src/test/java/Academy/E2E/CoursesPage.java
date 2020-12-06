package Academy.E2E;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.LandingPage;
import resources.base;

public class CoursesPage extends base {

	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initalizeDriver();
		driver.get(pro.getProperty("url"));
	}
	@Test
	public void validatingcourses()
	{
		LandingPage lp = new LandingPage(driver);
		lp.getcourses().click();
		
		
	}
	
	@AfterTest
    public void teardown()
    {
    	driver.close();
    }
	
}
