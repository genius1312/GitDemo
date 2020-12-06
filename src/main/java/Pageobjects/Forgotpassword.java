package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpassword {

	
public WebDriver driver;
	
	By forgotpassword = By.linkText("Forgot Password?");
	By email = By.id("user_email");
	By sendinstructions = By.name("commit");
	
	
	public Forgotpassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement forgotpasswd()
	{
		return driver.findElement(forgotpassword);
	}
	
	public WebElement emailaddress()
	{
		return driver.findElement(email);
	}
	
	public WebElement sendmeinstruction()
	{
		return driver.findElement(sendinstructions);
	}
}
