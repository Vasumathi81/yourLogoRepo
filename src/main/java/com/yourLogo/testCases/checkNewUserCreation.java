package com.yourLogo.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateUserAccount;
import pageObjects.HomePage;
import utilities.BaseTest;
import utilities.GenericMethods;

public class checkNewUserCreation extends BaseTest{
	
	static final Logger log = LogManager.getLogger(checkNewUserCreation.class.getName());

	@BeforeTest
	public void TC_ApplicationLaunch() throws IOException
	{
		driver = initializeBrowser();				
		LaunchApp();			
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
	
	@Test(priority = 2)
	public void TC_newUserCreation() throws IOException, InterruptedException
	{
		log.info("-------------------------------------------------------------------------------------");
		log.info("                        New User Creation");
		log.info("-------------------------------------------------------------------------------------");
		
		GenericMethods gm = new GenericMethods();
		// retrieve the email id from excel and store it in the variable
		 String retEmail = gm.getValuesFromExcel("User", "UserCreation", "Email");
		 log.info("Successfully retrieved req details from excel");
		 
		
		HomePage hp = new HomePage(driver);
		String retValue = hp.siginEmailCheck(retEmail);
		if (retValue=="userPage")
		{
			log.info("User account creation page is displayed");
		}
		else
		{
			log.error("Error message is displayed instead of the account creation page");
			Assert.fail("User account creation page is not displayed");
		}
		
		CreateUserAccount cua = new CreateUserAccount(driver);
		cua.createAnAccount();
		
	}
		

}
