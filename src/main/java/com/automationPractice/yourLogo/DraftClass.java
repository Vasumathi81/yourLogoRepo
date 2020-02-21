package com.automationPractice.yourLogo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.GenericMethods;

public class DraftClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://automationpractice.com/index.php");
//		
//		driver.findElement(By.xpath("//*[@id='header'] //a[@class='login']")).click();
//		
//
//		WebElement element = driver.findElement(By.tagName("button"));
//
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		Object elementAttributes = executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",element);
//
//		System.out.println(elementAttributes.toString());
		
		GenericMethods gm = new GenericMethods();
		System.out.println(gm.getValuesFromExcel("user", "usercreation", "zipcode"));
		

		
	}

}
