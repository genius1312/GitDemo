package Academy.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.Forgotpassword;
import Pageobjects.LandingPage;
import Pageobjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initalizeDriver();

	}
	
	
    @Test(dataProvider="getdata")
	public void basepagenavigation(String username, String password,String text) throws IOException
	{
    	driver.get(pro.getProperty("url"));
    	LandingPage lp = new LandingPage(driver);
    	lp.getlogin().click();
    	LoginPage l = new LoginPage(driver);
    	l.getusername().sendKeys(username);
    	l.getpassword().sendKeys(password);
    	l.getbutton().click();
    	Forgotpassword fp = new Forgotpassword(driver);
    	fp.forgotpasswd().click();
    	fp.emailaddress().sendKeys(username);
    	fp.sendmeinstruction().click();
    	
        System.out.println("this is for just git demo1");
        System.out.println("this is for just git demo2");
        
        
    	Log.info(text);
    	
    }
	@DataProvider
	public Object[][] getdata()
	{
		//rows stand for like how many types of data we are passing(here it is restricted & non-restricted user)
		// columns stand for like how many fields/values are there for that set of data
		Object[][] data  = new Object[2][3];
		
		//1st set 
		data[0][0] = "nonrestriceduser@qw.com";
		data[0][1] = "dgjsyyt6347678";
		data[0][2] = "Non-Restricted User";
		
		//2nd set
		data[1][0] = "restricteduser@qw.com";	
		data[1][1] = "dgjsyyt6347678";
		data[1][2] = "Restricted User";
		
		return data;
		
	}
	
	@AfterTest
    public void teardown()
    {
    	driver.close();
    }

}