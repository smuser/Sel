import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class s {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "D:\\SofwareSelenium\\jarfiles\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        String baseUrl = "http://demo.guru99.com/test/upload/";
        driver.manage().window().maximize();

        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\shaheen.mirza\\Downloads\\File Upload Demo.html");
        System.out.println("File Uploaded");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
        System.out.println("Send Clicked");
        }
}