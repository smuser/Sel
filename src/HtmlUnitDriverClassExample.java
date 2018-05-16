import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverClassExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Not WOrking need ot check
		
		WebDriver driver = new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		
		System.out.println(driver.getTitle());	

	}

}
