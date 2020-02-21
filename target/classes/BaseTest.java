package resources;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


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
		return driver;
		
	}

	// Method to launch the application with the given url
	public void LaunchApp() throws IOException 
	{					
		driver.get(gm.getValueFromPropertiesFile("appURL"));	
		driver.manage().window().maximize();				
	
	}
	


}
