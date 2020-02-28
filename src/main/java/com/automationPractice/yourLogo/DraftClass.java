package com.automationPractice.yourLogo;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utilities.GenericMethods;

public class DraftClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class='login']")).click();
		driver.findElement(By.id("email")).sendKeys("cde@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("davidh123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.findElement(By.id("search_query_top")).sendKeys("printed summer dress");
		driver.findElement(By.name("submit_search")).click();
		
		//WebElement linkGrid = driver.findElement(By.xpath("//ul[@class='product_list grid row']"));
		//int prodCount = linkGrid.findElements(By.xpath("//img[@class='replace-2x img-responsive']")).size();
		
		////ul[@class='product_list grid row'] //img[@class='replace-2x img-responsive']
		int prodCount = driver.findElements(By.xpath("//ul[@class='product_list grid row'] //li[contains(@class,'ajax_block_product')]")).size();
		System.out.println("No. of products listed = " + prodCount);
		
		List<WebElement> prodList = driver.findElements(By.xpath("//ul[@class='product_list grid row'] //li[contains(@class,'ajax_block_product')]"));
		List<WebElement> btnAddToCart = driver.findElements(By.xpath("//ul[@class='product_list grid row'] //a[@title='Add to cart']"));
		
		
		Actions act = new Actions(driver);
		
		for (int i=0; i<prodCount; i++)
		{
			act.moveToElement(prodList.get(i)).build().perform();
			act.click(btnAddToCart.get(i)).build().perform();
			Thread.sleep(2000);			
			driver.findElement(By.xpath("//*[@id='layer_cart'] //*[@title='Close window']")).click();
			
		}
			
		
		

	}
	
}
