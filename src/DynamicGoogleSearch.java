import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogleSearch {
	
	static WebDriver driver;
	
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SofwareSelenium\\jarfiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		
		driver.findElement(By.id("lst-ib")).sendKeys("testing");	
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
		System.out.println("List of Search Result:  " +list.size());
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getText().contains("types"))
			{
				list.get(i).click();
				break;
			}
		}
	}
}
