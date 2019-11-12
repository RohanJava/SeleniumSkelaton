package com.mycompany.app;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initialiseDriver();
		
	}
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String username, String password, String text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPass().sendKeys(password);
		System.out.println(text);
		lp.getLogin().click();
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}

	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data=new Object[2][3];
		data[0][0]="nonrestricteduser@gmai.com";
		data[0][1]="12345";
		data[0][2]="non restricteduser";
		
		data[1][0]="restricteduser@gmai.com";
		data[1][1]="12345678";
		data[1][2]="restricted user";
		return data;
		
	}
	
	
	
	
	
}
