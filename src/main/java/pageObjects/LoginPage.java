package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By email = By.cssSelector("[id='user_email']");
	By pass = By.cssSelector("[id='user_password']");
	By login = By.cssSelector("[type='submit']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement getPass()
	{
		return driver.findElement(pass);
		
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
		
	}
}
