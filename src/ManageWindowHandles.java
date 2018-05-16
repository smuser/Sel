import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageWindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\SofwareSelenium\\jarfiles\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get("http://www.popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("//a[@class='blu']")).click();
		
		driver.findElement(By.xpath("//a[@class='black']")).click();
		
		Set<String> handle = driver.getWindowHandles();
		
		Iterator<String> it = handle.iterator();
		
		String parentHandle = it.next(); // to move from 0 to parent handle to get ID
		
		System.out.println("Parent Window ID: " +parentHandle);
		
		String childHandle = it.next(); // move from parent to child to get ID
		
		String childHandle1 = it.next(); 
		
		System.out.println("Child Window ID: " +childHandle);
		
		driver.switchTo().window(childHandle); /// switch to child window
		
		System.out.println("Title of child window: " +driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(childHandle1); /// switch to child window
		
		System.out.println("Title of child 1 window: " +driver.getTitle());
		
//		driver.switchTo().defaultContent();
		
		driver.switchTo().window(parentHandle);
		
		System.out.println("Title of parent window: " +driver.getTitle());
		
		
	}

}
