package utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;


public class BaseTest {
	
	public static WebDriver driver;	
	public GenericMethods gm = new GenericMethods();
	

	// Initializing the required browser
	public WebDriver initializeBrowser() throws IOException
	{
		String browserValue = gm.getValueFromPropertiesFile("browser");
		// check the browser value and open the corresponding browser
		
		if (browserValue.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if (browserValue.equals("firefox"))
		{
	
			System.out.println("Firefox is initialised");
		}
		else if (browserValue.equals("ie"))
		{
	
			System.out.println("IE is initialised");
		}
		else
		{
			System.out.println("No browser value is set");
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
		
	}

	// Method to launch the application with the given url
	public void LaunchApp() throws IOException 
	{					
		driver.get(gm.getValueFromPropertiesFile("appURL"));	
		driver.manage().window().maximize();				
	
	}
	
	// Method to take screenshot of the browser and store it in a file
	public void takeScreenShot(String result) throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File(System.getProperty("user.dir")+"/Screenshots/" + result + "Screenshot.png"));
		//FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + result + "screenshot.png"));
	}
	


}
