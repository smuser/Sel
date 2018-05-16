package objectrepodemo;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
import java.net.MalformedURLException;
import java.net.URL;
 
public class Grid_SetUp {
	public static WebDriver driver;
 
	public static void main(String[]  args) throws MalformedURLException, InterruptedException{
 
 		String URL = "http://www.DemoQA.com";
 		String Node = "http://192.168.60.110:4455/wd/hub";
 		System.setProperty("webdriver.chrome.driver","D:\\SofwareSelenium\\driver\\chromedriver.exe");
 		DesiredCapabilities cap = DesiredCapabilities.chrome();
 		cap.setBrowserName("chrome");
 		cap.setPlatform(Platform.VISTA);
 		WebDriver driver = new ChromeDriver(cap);
 		driver = new RemoteWebDriver(new URL(Node), cap);
 
 		driver.navigate().to(URL);
 		Thread.sleep(5000);
 		driver.quit();
 	}		
}