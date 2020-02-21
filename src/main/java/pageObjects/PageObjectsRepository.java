package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseTest;

public class PageObjectsRepository {

		WebDriver driver;

		/* creating a constructor with the driver arg, to get the idea of which driver
		 to use - this is passed from the testcase */
		public PageObjectsRepository(WebDriver driver) 
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
		
		// ***************************** HOME SCREEN  ********************************************************
		@FindBy(id = "search_query_top")
		public WebElement searchTextbox;	
		
		@FindBy(xpath = "//*[@id='header'] //a[@class='login']")
		public WebElement signinButton;	
		
		// ****************************** EMAIL CHECK SCREEN ************************************************
		@FindBy(id = "email_create")
		public WebElement newEmail;

		@FindBy(id = "SubmitCreate")
		public WebElement createAccountButton;

		@FindBy(xpath = "//*[@id='create_account_error']/ol/li")
		public WebElement errorMsg;
		
		// **************************** CREATE AN ACCOUNT SCREEN ********************************************
		@FindBy(id = "uniform-id_gender1")
		public WebElement mrRadioBtn;

		@FindBy(id = "uniform-id_gender2")
		public WebElement mrsRadioBtn;

		@FindBy(id = "customer_firstname")
		public WebElement firstName;

		@FindBy(id = "customer_lastname")
		public WebElement lastName;

		@FindBy(id = "email")
		public WebElement email;
		
		@FindBy(id = "passwd")
		public WebElement password;

		@FindBy(id = "days")
		public WebElement dateDOB;

		@FindBy(id = "months")
		public WebElement monthDOB;

		@FindBy(id = "years")
		public WebElement yearDOB;
		
		@FindBy(id = "firstname")
		public WebElement fnInAddr;
		
		@FindBy(id = "lastname")
		public WebElement lnInAddr;

		@FindBy(id = "address1")
		public WebElement address;
		
		@FindBy(id = "city")
		public WebElement city;
		
		@FindBy(id = "id_state")
		public WebElement state;
		
		@FindBy(id = "postcode")
		public WebElement zipCode;
		
		@FindBy(id = "id_country")
		public WebElement country;
		
		@FindBy(id = "phone_mobile")
		public WebElement mobile;
		
		@FindBy(id = "alias")
		public WebElement aliasAddress;
		
		@FindBy(id = "submitAccount")
		public WebElement btnRegister;
		
		// *************************************  Home Page *****************************************************
		@FindBy(xpath = "//p[@class='info-account']")
		public WebElement msgLoginPage;		
		
		@FindBy(xpath = "//a[@class='logout']")
		public WebElement logout;
}
