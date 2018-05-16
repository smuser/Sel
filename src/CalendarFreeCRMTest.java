import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarFreeCRMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\SofwareSelenium\\jarfiles\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.get(
				"https://www.freecrm.com/index.cfm?CFID=78065&CFTOKEN=77536822&jsessionid=8e303751e17baaa0903949c4e4f6a3d344ae");

		driver.switchTo().frame("processFrame");
		
		String date = "24-April-2018";
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		Select selectMonth = new Select(driver.findElement(By.name("slcMonth")));
		selectMonth.selectByVisibleText(month);
		
		Select selectYear = new Select(driver.findElement(By.name("slcYear")));
		selectYear.selectByVisibleText(year);
		
		String beforeXpath=".//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath="]/td[";
		
		final int totalWeekDays= 7;
		String dayVal;
		boolean flag=false; 
		for(int row=2; row<=7; row++)
		{
			for(int col=1; col<=totalWeekDays; col++)
			{
				try
				{
				dayVal = driver.findElement(By.xpath(beforeXpath+row+afterXpath+col+"]")).getText();
				}
				catch(Exception e)
				{
					System.out.println("Please enter a valid date");
					flag=false;
					break;
				}
				
				if(dayVal.equals(day))
				{
					driver.findElement(By.xpath(beforeXpath+row+afterXpath+col+"]")).click();
					flag=true;
					break;
				}
				
				if(flag)
				{
					break;
				}
			}
		}
		
		
	}

}
