package objectrepodemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameter implements ITestListener{
	
	@Test
	@Parameters({"browser","chrome"})
	public static void launchchrome()
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\SofwareSelenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();	
	}
	
	@Test
	@Parameters({"browser","ie"})
	public static void launchie()
	{
		WebDriver driver;
		System.setProperty("webdriver.ie.driver", "D:\\SofwareSelenium\\IEDriverServer_x64_3.1\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();	
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}
