package readexcel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class ReadExcelTestCase {

	static WebDriver driver;
	Util util;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SofwareSelenium\\jarfiles\\chromedriver.exe");
		//ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS); // taking values from test util class
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://www.freecrmtest.com");
	}
	
	@DataProvider
	public static Object[][] readExcelData() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Object[][] data = Util.getTestData("Sheet1");
		return data;
	}
	
	@Test(dataProvider="readExcelData")
	public void Login(String username, String password)
	{
		WebElement user = driver.findElement(By.name("username"));
		WebElement pwd = driver.findElement(By.name("password"));
		
		user.sendKeys(username);
		pwd.sendKeys(password);
		util.highlightElement(user);
		util.highlightElement(pwd);
		//util.takeScreenshot();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
