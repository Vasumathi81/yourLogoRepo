package com.yourLogo.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateUserAccount;
import pageObjects.HomePage;
import utilities.BaseTest;
import utilities.GenericMethods;

public class checkNewUserCreation extends BaseTest{

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
	public void TC_newUserCreation() throws IOException, InterruptedException
	{
		GenericMethods gm = new GenericMethods();
		// retrieve the email id from excel and store it in the variable
		 String retEmail = gm.getValuesFromExcel("User", "UserCreation", "Email");
		
		HomePage hp = new HomePage(driver);
		hp.siginEmailCheck(retEmail);
		
		CreateUserAccount cua = new CreateUserAccount(driver);
		cua.createAnAccount();
		
	}
		

}
