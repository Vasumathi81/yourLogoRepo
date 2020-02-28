package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.TestData;

public class UserHomeScreen {

	public WebDriver driver;
	static final Logger log = LogManager.getLogger(UserHomeScreen.class.getName());

	public UserHomeScreen(WebDriver driver) {
		this.driver = driver;
	}

	public void SearchAnItem() {

		PageObjectsRepository por = new PageObjectsRepository(driver);
		TestData td = new TestData();

		por.txtSearch.sendKeys(td.searchVal);
		log.info("Entered the value " + td.searchVal + " in the search textbox");
		por.btnSearch.click();
		log.info("Clicked on the search button");

	}

	public void SelectingValueFromList() throws InterruptedException {

		PageObjectsRepository por = new PageObjectsRepository(driver);

		int prodCount = driver.findElements(By.xpath("//ul[@class='product_list grid row'] //li[contains(@class,'ajax_block_product')]")).size();
		log.info("Number of listed products - " + prodCount);

		List<WebElement> prodList = driver.findElements(
				By.xpath("//ul[@class='product_list grid row'] //li[contains(@class,'ajax_block_product')]"));
		List<WebElement> btnAddToCart = driver
				.findElements(By.xpath("//ul[@class='product_list grid row'] //a[@title='Add to cart']"));

		// creating Actions class object to perform keyboard actions
		Actions act = new Actions(driver);
		act.moveToElement(prodList.get(0)).build().perform();
		log.info("Moved the mouse over the first product to select");
		act.click(btnAddToCart.get(0)).build().perform();
		log.info("Clicked on the AddToCart button");
		Thread.sleep(1000);
		por.btnClose.click();
		log.info("Closed the pop up window");

	}
	
	public void SearchByTabs() {
		
		PageObjectsRepository por = new PageObjectsRepository(driver);
		Actions act = new Actions(driver);
		act.moveToElement(por.tabWomen).build().perform();
		act.moveToElement(por.subTabBlouses).click().build().perform();
	}

}
