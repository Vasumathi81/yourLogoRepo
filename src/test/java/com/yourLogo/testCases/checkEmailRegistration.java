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

public class checkEmailRegistration extends BaseTest{
	
	static final Logger log = LogManager.getLogger(checkEmailRegistration.class.getName());
	
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
	
	@Test
	public void TC_emailCheck() throws IOException, InterruptedException
	{
		HomePage hp = new HomePage(driver);
		GenericMethods gm = new GenericMethods();
		ArrayList<String> emailIDList = gm.getValuesFromExcel("Login", "Email ID");
		log.info("Email id is retrieved from the excel");
		String emailID = emailIDList.get(0);
		hp.siginEmailCheck(emailID);
	}


}
