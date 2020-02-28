package com.yourLogo.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PageObjectsRepository;
import utilities.BaseTest;
import utilities.Constants;
import utilities.GenericMethods;

public class EmailRegistrationTest extends BaseTest{
	
	static final Logger log = LogManager.getLogger(EmailRegistrationTest.class.getName());
	
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
	
	@Test(priority = 1)
	public void TC_emailCheck() throws IOException, InterruptedException
	{
		log.info("-------------------------------------------------------------------------------------");
		log.info("                        check email registration");
		log.info("-------------------------------------------------------------------------------------");
		HomePage hp = new HomePage(driver);
		GenericMethods gm = new GenericMethods();
		ArrayList<String> emailIDList = gm.getValuesFromExcel("Login", "Username");
		log.info("Email id is retrieved from the excel");
		String emailID = emailIDList.get(0);
		String retValue = hp.siginEmailCheck(emailID);
		if (retValue=="errorMsg")
		{
			log.info("The error message is displayed as needed");
		}
		else
		{
			Assert.fail("No error message is displayed");
		}
	}


}
