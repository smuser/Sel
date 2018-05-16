package readexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


public class Util extends ReadExcelTestCase {

	public static String TESTDATA_SHEET_PATH = "D:\\Workspace\\MySelenium\\src\\readexcel\\testData1.xlsx";

	public static Object[][] getTestData(String sheetName)
			throws IOException {
		InputStream fileIO = new FileInputStream(TESTDATA_SHEET_PATH);
		Workbook book = null;
		try {
			book = WorkbookFactory.create(fileIO);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int row = 0; row < sheet.getLastRowNum(); row++)
			for (int col = 0; col < sheet.getRow(0).getLastCellNum(); col++) {
				data[row][col] = sheet.getRow(row + 1).getCell(col).toString(); // get data e.g. [1][0]
			}
		return data;
	}
	
	public void highlightElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'backgroud: grey border: 2px red;');", element);
	}
	
	
	/*public void takeScreenshot()
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		String currentDir = System.getProperty("user.dir");

		try {
			FileUtils.copyFile(file, new File(currentDir + "/screenshot/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}
