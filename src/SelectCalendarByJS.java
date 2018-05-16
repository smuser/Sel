import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCalendarByJS {
	
	public static void main(String args[])
	{	
		System.setProperty("webdriver.chrome.driver", "D:\\SofwareSelenium\\jarfiles\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get("http://www.spicejet.com");
	}

}
