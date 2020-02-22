package pageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.Constants;
import utilities.GenericMethods;

public class CreateUserAccount {
	
	public WebDriver driver;
	GenericMethods gm = new GenericMethods();
	static final Logger log = LogManager.getLogger(CreateUserAccount.class.getName());
	
	// constructor to set the active driver[passed as class arg] to this class's local driver variable
	public CreateUserAccount(WebDriver driver)
	{
		this.driver = driver;
	}	

	public void createAnAccount() throws IOException
	{
		PageObjectsRepository por = new PageObjectsRepository(driver);
		Constants constant = new Constants();
		
		// set the title radio button
		String titleValue = gm.getValuesFromExcel("user", "usercreation", "title");
		if (titleValue.equalsIgnoreCase("Mr"))
		{
			por.mrRadioBtn.click();
			log.info("Mr Radio button clicked");
		}
		else if (titleValue.equalsIgnoreCase("Mrs"))
		{
			por.mrsRadioBtn.click();
			log.info("Mrs Radio button clicked");
		}
		else
		{
			System.out.println("The given title is not present in application.");
			log.error("No radio button is selected");
		}
		
		String firstNameValue = gm.getValuesFromExcel("user", "usercreation", "firstname");
		por.firstName.sendKeys(firstNameValue);
		log.info("Entered the firstname");
		
		String lastNameValue = gm.getValuesFromExcel("user", "usercreation", "lastname");
		por.lastName.sendKeys(lastNameValue);
		log.info("Entered the lastname");
		
		// check if the displayed email value is as given in the data sheet
		String emailValue = gm.getValuesFromExcel("user", "usercreation", "email");		
		Assert.assertEquals(por.email.getAttribute("value"), emailValue);
		
		String pwdValue = gm.getValuesFromExcel("user", "usercreation", "password");
		por.password.sendKeys(pwdValue);
		log.info("Entered the password");
		
		// create an object of Select class to select values from dropdowns
		String dateValue = gm.getValuesFromExcel("user", "usercreation", "date");
		Select selectObj = new Select(por.dateDOB);
		selectObj.selectByValue(dateValue);
		log.info("Selected the date");
		
		String monthValue = gm.getValuesFromExcel("user", "usercreation", "month");
		selectObj = new Select(por.monthDOB);
		//selectObj.selectByVisibleText(monthValue); - not selecting, as there is a trailing space with the options
		
		// select the value using partial text as unable to select the value normally
		List<WebElement> monthList = driver.findElements(By.xpath("//*[@id='months']/option"));
		Iterator<WebElement> i = monthList.iterator();
		while (i.hasNext())
		{			
			WebElement eleMonthValue = i.next();
			if (eleMonthValue.getText().contains(monthValue))
			{
				String optionIndex = eleMonthValue.getAttribute("index");
				selectObj.selectByIndex(Integer.parseInt(optionIndex));
				log.info("Selected the month");
				break;
			}
		}				
		
		String yearValue = gm.getValuesFromExcel("user", "usercreation", "year");
		selectObj = new Select(por.yearDOB);
		selectObj.selectByValue(yearValue);
		log.info("Selected the year");
		
		String addrValue = gm.getValuesFromExcel("user", "usercreation", "address");
		por.address.sendKeys(addrValue);
		log.info("Entered the address");
		
		String cityValue = gm.getValuesFromExcel("user", "usercreation", "city");
		por.city.sendKeys(cityValue);
		log.info("Entered the city");
		
		String stateValue = gm.getValuesFromExcel("user", "usercreation", "state");
		selectObj = new Select(por.state);
		selectObj.selectByVisibleText(stateValue);
		log.info("Selected the state");
		
		String zipValue = gm.getValuesFromExcel("user", "usercreation", "zipcode");
		por.zipCode.sendKeys(zipValue);
		log.info("Entered the zipcode");
		
		String mobileValue = gm.getValuesFromExcel("user", "usercreation", "mobile");
		por.mobile.sendKeys(mobileValue);
		log.info("Entered the mobile number");
		
		String aliasValue = gm.getValuesFromExcel("user", "usercreation", "Alias address");
		por.aliasAddress.clear();
		por.aliasAddress.sendKeys(aliasValue);
		log.info("Entered the alias address");
		
		por.btnRegister.click();
		
		if (por.msgLoginPage.isDisplayed())
		{
			log.info("User account created successfully");
		}
		else
		{
			Assert.fail("User account creation failed");
		}
		
		// Capture the login creation message and check if the expected
		String actLoginPageMsg = por.msgLoginPage.getText();			
		Assert.assertEquals(actLoginPageMsg, constant.expLoginPageMsg);
		
		// Signout of the application
		por.logout.click();
	}
	
}
