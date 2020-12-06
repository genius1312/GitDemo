package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class base {

	public WebDriver driver;
	public Properties pro;
	
	@Test
	public WebDriver initalizeDriver() throws IOException
	{
		
		 pro = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Ashish\\eclipse-workspace\\E2E\\src\\main\\java\\resources\\data.properties");
		pro.load(fis);
		String browsername = pro.getProperty("browser");
		
		
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ashish\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
		}
		
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ashish\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		
		   
	}

	public String getscreenshotpath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+"\\.png\\";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	
	
}
