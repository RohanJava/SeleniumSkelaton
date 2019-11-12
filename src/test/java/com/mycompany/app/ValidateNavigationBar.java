package com.mycompany.app;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigationBar extends base{
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initialiseDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basePageNavigationBar() throws IOException
	{
		
		
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}

}
