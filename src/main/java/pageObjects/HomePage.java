
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.yourLogo.testCases.EmailRegistrationTest;

import utilities.BaseTest;
import utilities.Constants;
import utilities.GenericMethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage {
	
	public WebDriver driver;
	Constants constant = new Constants();
	GenericMethods gm = new GenericMethods();
	//PageObjectsRepository por = new PageObjectsRepository(driver); - null exception error if declared here
	static final Logger log = LogManager.getLogger(HomePage.class.getName());
	

	// constructor to set the active driver[passed as class arg] to this class's local driver variable
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public String siginEmailCheck(String emailID) throws InterruptedException
	{
		PageObjectsRepository por = new PageObjectsRepository(driver);	
		por.signinButton.click();
		log.info("Signin button is clicked");
		por.newEmail.sendKeys(emailID);		
		log.info("The email address " + emailID + " has been entered");
		por.createAccountButton.click();
		log.info("Create account button is clicked");
		Thread.sleep(3000);
		
		
		if (gm.isElementPresent(por.errorMsg))
		{
			Assert.assertEquals(por.errorMsg.getText(), constant.expErr);
			log.info("The error message is as expected");
			String returnVal = "errorMsg";
			return returnVal;
		}
		else
		{
			log.info("No error message displayed");			
			String returnVal = "userPage";
			return returnVal;
		}
						
	}
	
	public void existingUserLogin(String email, String password)
	{
		PageObjectsRepository por = new PageObjectsRepository(driver);
		por.signinButton.click();
		log.info("Signin button is clicked");
		
		por.txtEmail.sendKeys(email);
		log.info("Email address entered");
		por.txtPwd.sendKeys(password);
		log.info("Password entered");
		por.btnSignin.click();
		log.info("Signin button is clicked");
		
		if (gm.isElementPresent(por.logout))
		{
			log.info("Able to login with existing user details");
		}
		else
		{
			Assert.fail("Unable to login with existing user details");
		}
		
	}
	
	public void userLogout()
	{
		PageObjectsRepository por = new PageObjectsRepository(driver);
		por.logout.click();
		log.info("Logout button clicked");
	}

}
