package selenium;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import excelclasses.ExcelData;


public class DataDrivenApproach {
	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@BeforeMethod 
	public void beforeTest(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	@Test
	public void usingExcelData() throws Exception{
		Calendar cal = Calendar.getInstance();
		int monthInt = cal.get(Calendar.MONTH) + 1;
		System.out.println(monthInt);
		System.out.println(new DateFormatSymbols().getMonths()[11 - 1]);
		ExcelData excel = new ExcelData("D:/wokspace/ExcelData/data.xls", "Sheet1");
		excel.setExcel("D:/wokspace/ExcelData/data.xls", "Sheet1");
		System.out.println(excel.getCellValue(1, 0));
		System.out.println(excel.getCellValue(1, 40).hashCode());
	}
	
	@Test
	public void loginGmail() throws Exception{
		int row = 1, col = 1;
//		ExcelData excel = new ExcelData();
		ExcelData excel = new ExcelData("D:/wokspace/ExcelData/data.xls", "Sheet1");
//		excel.setExcel("D:/wokspace/ExcelData/data.xls", "Sheet1");
		driver.get("https://www.gmail.com");
		while(true) {
			System.out.println("asasasas"+excel.isCellEmpty(row, col));
//			if(!isElementPresent(By.id("signIn")))
//				break;
			if(excel.isCellEmpty(row, col))
				break;
//			System.out.println(excel.getCellValue(row,  col));
//			System.out.println(excel.getCellValue(row, col+1));
			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Email")).sendKeys(excel.getCellValue(row, col));
			driver.findElement(By.id("Passwd")).sendKeys(excel.getCellValue(row, col+1));
			driver.findElement(By.id("signIn")).click();
			row++;
		}
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	

	public  boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
}
