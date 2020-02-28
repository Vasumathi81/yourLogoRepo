package com.yourLogo.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PageObjectsRepository;
import utilities.BaseTest;
import utilities.GenericMethods;

public class ExistingUserLoginTest extends BaseTest{
	
	static final Logger log = LogManager.getLogger(NewUserCreationTest.class.getName());

	@BeforeMethod
	public void TC_ApplicationLaunch() throws IOException
	{
		driver = initializeBrowser();				
		LaunchApp();			
	}
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.close();
//		driver=null;
//	}
	
	@Test
	public void TC_ExistingUserLogin() throws IOException
	{
		log.info("-------------------------------------------------------------------------------------");
		log.info("                        Existing User Login");
		log.info("-------------------------------------------------------------------------------------");
		
		GenericMethods gm = new GenericMethods();
		
		
		String retEmail = gm.getValuesFromExcel("Login", gm.getValueFromPropertiesFile("loginRow"), "Email");
		String retPwd = gm.getValuesFromExcel("Login", gm.getValueFromPropertiesFile("loginRow"), "Password");
		
		HomePage hp = new HomePage(driver);
		hp.existingUserLogin(retEmail, retPwd);
		
		
	}

}
