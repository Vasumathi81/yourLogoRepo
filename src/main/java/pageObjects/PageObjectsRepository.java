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
		
		@FindBy(id = "email")
		public WebElement txtEmail;
		
		@FindBy(id = "passwd")
		public WebElement txtPwd;
		
		@FindBy(id = "SubmitLogin")
		public WebElement btnSignin;
		
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
		
		// *************************************  User Account Home Screen ****************************************
		@FindBy(xpath = "//p[@class='info-account']")
		public WebElement msgLoginPage;		
		
		@FindBy(xpath = "//a[@class='logout']")
		public WebElement logout;
		
		@FindBy(id = "search_query_top")
		public WebElement txtSearch;
		
		@FindBy(name = "submit_search")
		public WebElement btnSearch;
		
		@FindBy(linkText = "http://automationpractice.com/index.php?id_category=3&controller=category")
		public WebElement linkWomen;
		
		@FindBy(linkText = "http://automationpractice.com/index.php?id_category=8&controller=category")
		public WebElement linkDresses;
		
		@FindBy(linkText = "http://automationpractice.com/index.php?id_category=5&controller=category")
		public WebElement linkTshirts;
		
		@FindBy(xpath = "//ul[@class='product_list grid row']")
		public WebElement listGrid;
		
//		@FindBy(xpath = "//ul[@class='product_list grid row'] //li[contains(@class,'ajax_block_product')]")
//		public WebElement product;
//		
//		@FindBy(xpath = "//ul[@class='product_list grid row'] //a[@title='Add to cart']")
//		public WebElement btnAddToCart;
		
		@FindBy(xpath = "//*[@id='layer_cart'] //*[@title='Close window']")
		public WebElement btnClose;
		
		@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]")
		public WebElement tabWomen;
		
		@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]")
		public WebElement tabDresses;
		
		@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[3]")
		public WebElement mainTabTshirts;
		
		@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1] //*[@title='T-shirts']")
		public WebElement subTabTshirts;
		
		@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1] //*[@title='Blouses']")
		public WebElement subTabBlouses;
		
		
		
		
}
