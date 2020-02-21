package pageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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
		}
		else if (titleValue.equalsIgnoreCase("Mrs"))
		{
			por.mrsRadioBtn.click();
		}
		else
		{
			System.out.println("The given title is not present in application.");
		}
		
		String firstNameValue = gm.getValuesFromExcel("user", "usercreation", "firstname");
		por.firstName.sendKeys(firstNameValue);
		
		String lastNameValue = gm.getValuesFromExcel("user", "usercreation", "lastname");
		por.lastName.sendKeys(lastNameValue);
		
		// check if the displayed email value is as given in the data sheet
		String emailValue = gm.getValuesFromExcel("user", "usercreation", "email");		
		Assert.assertEquals(por.email.getAttribute("value"), emailValue);
		
		String pwdValue = gm.getValuesFromExcel("user", "usercreation", "password");
		por.password.sendKeys(pwdValue);
		
		// create an object of Select class to select values from dropdowns
		String dateValue = gm.getValuesFromExcel("user", "usercreation", "date");
		Select selectObj = new Select(por.dateDOB);
		selectObj.selectByValue(dateValue);
		
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
				break;
			}
		}				
		
		String yearValue = gm.getValuesFromExcel("user", "usercreation", "year");
		selectObj = new Select(por.yearDOB);
		selectObj.selectByValue(yearValue);
		
		String addrValue = gm.getValuesFromExcel("user", "usercreation", "address");
		por.address.sendKeys(addrValue);
		
		String cityValue = gm.getValuesFromExcel("user", "usercreation", "city");
		por.city.sendKeys(cityValue);
		
		String stateValue = gm.getValuesFromExcel("user", "usercreation", "state");
		selectObj = new Select(por.state);
		selectObj.selectByVisibleText(stateValue);
		
		String zipValue = gm.getValuesFromExcel("user", "usercreation", "zipcode");
		por.zipCode.sendKeys(zipValue);
		
		String mobileValue = gm.getValuesFromExcel("user", "usercreation", "mobile");
		por.mobile.sendKeys(mobileValue);
		
		String aliasValue = gm.getValuesFromExcel("user", "usercreation", "Alias address");
		por.aliasAddress.clear();
		por.aliasAddress.sendKeys(aliasValue);
		
		por.btnRegister.click();
		
		if (por.msgLoginPage.isDisplayed())
		{
			System.out.println("User account created successfully");
		}
		else
		{
			System.out.println("User account creation failed");
		}
		
		// Capture the login creation message and check if the expected
		String actLoginPageMsg = por.msgLoginPage.getText();			
		Assert.assertEquals(actLoginPageMsg, constant.expLoginPageMsg);
		
		// Signout of the application
		por.logout.click();
	}
	
}
