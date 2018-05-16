
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4j {

	static WebDriver driver;

	private static Logger Log = Logger.getLogger(Log4j.class.getName());

	public static void main(String[] args) {

		DOMConfigurator.configure("log4j.xml");

		// Create a new instance of the Chrome driver

		System.setProperty("webdriver.chrome.driver", "D:\\SofwareSelenium\\jarfiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		Log.info("New driver instantiated");

		// Put a Implicit wait, this means that any search for elements on the page
		// could take the time the implicit wait is set for before throwing exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Log.info("Implicit wait applied on the driver for 10 seconds");

		// Launch the Online Store Website

		driver.get("http://www.google.com");

		Log.info("Web application launched");

		// Find the element that's ID attribute is 'account'(My Account)

		driver.findElement(By.id("lst-ib")).click();

		Log.info("Click action performed on My Account link");

		driver.findElement(By.id("lst-ib")).sendKeys("testing");

		Log.info("Search criteria entered");

	
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
		System.out.println("List of Search Result:  " +list.size());
		
		Log.info("Criterias all listed and now clicking on testing types criteria");
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getText().contains("types"))
			{
				list.get(i).click();
				break;
			}
		}
		// Close the driver

		driver.quit();

		Log.info("Browser closed");

	}

}