package com.automationPractice.yourLogo;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateUserAccount;
import pageObjects.HomePage;
import utilities.BaseTest;
import utilities.GenericMethods;


public class MainClass extends BaseTest{
	
	@BeforeTest
	public void TC_ApplicationLaunch() throws IOException
	{
		driver = initializeBrowser();				
		LaunchApp();			
	}
	

	public void closeApp()
	{
		driver.close();
	}

	@Test
	public void TC_UserCreation() throws InterruptedException, IOException
	{	

		
	}
	


}
