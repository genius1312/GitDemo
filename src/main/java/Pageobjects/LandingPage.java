package Pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {

	
	public WebDriver driver;
	
		
		By login = By.linkText("Login");
		By title = By.cssSelector("div[class='text-center'] h2");
		By navbar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
		By courses = By.partialLinkText("Selenium Webdriver with Java Basics");
		
		
		public LandingPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}


		public  WebElement getlogin()
		{
			return driver.findElement(login);
			 
		}
		
		public WebElement getTitle()
		{
			return driver.findElement(title);
		}
		public WebElement getNavbar()
		{
			return driver.findElement(navbar);
		}
		public WebElement getcourses()
		{
			return driver.findElement(courses);
		}
		
	}
	
	
