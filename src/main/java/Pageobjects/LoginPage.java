package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	public WebDriver driver;
	
	By email = By.id("user_email");
	By passwd = By.id("user_password");
	By button = By.xpath("//input[@value='Log In']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getusername()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(passwd);
	}
	
	public WebElement getbutton()
	{
		return driver.findElement(button);
	}
}