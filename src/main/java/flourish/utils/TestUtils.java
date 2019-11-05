package flourish.utils;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.FileChooserUI;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

import flourish.testbase.AndroidTestBase;


public class TestUtils extends AndroidTestBase{
	
	static public String chromeBrowserPkg = "webdriver.chrome.driver";
	static public String chromeDriverPath = "src/test/resources/driver/chromedriver76.exe";
	static public String firefoxBrowserPkg = "webdriver.firefox.marionette";
	static public String firefoxDriverPath = "";
	static public XSSFWorkbook workbook;
	static public XSSFSheet sheet;
	
	static public int PAGE_LOAD_TIME_OUT = 60;
	static public int IMPLICIT_WAIT = 30;
	static public int EXPLICIT_WAIT = 60;
	
	public static String getSS(String ssName)
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("src/test/resources/screenshots/"+ssName+".png");
		try {
			//FileHandler.copy(src, dest);
			Files.copy(src, dest);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dest.getAbsolutePath();	
				
	}
	
	
	public static Object[][] getData(String sheetName)
	{
		try
		{
		workbook = new XSSFWorkbook("src/test/resources/FlourishLogin.xlsx");
		sheet = workbook.getSheet(sheetName);
		}

		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
		
		
	}
	
	public static void staticWait(long milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

}
