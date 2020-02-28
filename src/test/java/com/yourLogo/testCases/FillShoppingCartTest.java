package com.yourLogo.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.UserHomeScreen;
import utilities.BaseTest;

public class FillShoppingCartTest extends BaseTest {
	
	static final Logger log = LogManager.getLogger(NewUserCreationTest.class.getName());
	
	@Test
	public void TC_AddItemsInCart() throws IOException, InterruptedException {
		
		UserHomeScreen home = new UserHomeScreen(driver);
		home.SearchAnItem();
		home.SelectingValueFromList();
	}

}
