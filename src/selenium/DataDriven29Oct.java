package selenium;

import java.io.File;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import excelclasses.ExcelData;

public class DataDriven29Oct {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExcelData excel;
	private Select dropdown;
	private Actions builder;

	
	@BeforeClass
	public void beforeClass() {
//		excel = new ExcelData();
	}
	
	@BeforeMethod 
	public void beforeTest() {
		driver = new FirefoxDriver();
		builder = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void submitMacysProfile() throws Exception{
		int row = 1, column = 0;
		StringBuilder strbuilder;
//		builder.insert(1, '-');
		
		excel = new ExcelData("data/profiledata.xls", "macysprofile");
		driver.get("https://www.macys.com/account/profile");
		//form[@id='create-profile']/div[@class='large-16 columns create-profile-border']/div[contains(@class,'create-profile')]/div/div[@class='columns large-8']
		List<WebElement> field = driver.findElements(By.xpath("//form[@id='create-profile']/div[@class='large-16 columns create-profile-border']/div[contains(@class,'create-profile')]/div/div[@class='columns large-8']"));
		System.out.println(field.get(0));
//		StringUtils.
//		[[FirefoxDriver: firefox on XP (b9011e35-b588-46e4-97a6-14939038e146)] -> 
//xpath: //form[@id='create-profile']/div[@class='large-16 columns create-profile-border']/div[contains(@class,'create-profile')]/div/div[@class='columns large-8']]
//		for(int currentRow = 1; currentRow <= excel.TOTAL_ROW; currentRow++){
//			if(excel.isCellEmpty(currentRow, ++column)) 
//				continue;
//			driver.findElement(By.xpath("//*[contains(@id, "+excel.getCellValue(0, column)+")")).sendKeys(excel.getCellValue(currentRow, column));
////			for(WebElement singleData:field) {
////				if(!excel.isCellEmpty(row, ++column)) {
////					String start = singleData.toString().split("xpath: ")[1];
////					strbuilder= new StringBuilder(start);
////					start = strbuilder.insert(start.length()-31, "[index]").toString();
////					start = strbuilder.substring(0, start.length()-1);
////					System.out.println(start);
////					driver.findElement(By.xpath(""));
////				}
////			}
//		}
		List<String> idAttributes = excel.createHeaderList();
		System.out.println(idAttributes);
		for(int currentRow = 1; currentRow <= excel.TOTAL_ROW; currentRow++){
			
		}
	}
	
	@Test
	public void bookingFlight() throws Exception{
		int row = 1, column = 0;
		driver.get("https://www.irctc.co.in/");
		String parenthandle = driver.getWindowHandle(), flighthandle = null;
		excel = new ExcelData("data/profiledata.xls", "irctcflight");
		int totalRow = excel.getRowCount();
		System.out.println(excel.getRowCount()+"-->total number of rows");
		System.out.println(excel.TOTAL_ROW);
		for(int currentRow = 1; currentRow <= excel.TOTAL_ROW; currentRow++){
			System.out.println(row);
			column = 0;
			if(excel.isColumnEmpty(row)) {
				File errorShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(errorShot,new File("screen_shots//"+this.getClass()+"irctc_of"+row+".png"));
				row++;
				continue;
			}
			driver.findElement(By.linkText("Flights")).click();
			Set<String> allwindows = driver.getWindowHandles();
			System.out.println(allwindows);
			for(String flightwindow:allwindows) {
				if(driver.switchTo().window(flightwindow).getTitle().equals("IRCTC Online Passenger Reservation System")){
					flighthandle = flightwindow;
					break;
				}
			}
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("destination"))));
			if(excel.isColumnEmpty(row)) {
				File errorShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(errorShot,new File("screen_shots//"+this.getClass()+"irctc_of"+row+".png"));
				row++;
				continue;
			}
			System.out.println(row+"---"+column);
			driver.findElement(By.id("destination")).clear();
			driver.findElement(By.id("destination")).sendKeys(StringUtils.capitalize(excel.getCellValue(row, ++column)));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'"+StringUtils.capitalize(excel.getCellValue(row, column).trim())+"')]")).click();
			driver.findElement(By.id("origin")).clear();
			driver.findElement(By.id("origin")).sendKeys(excel.getCellValue(row, ++column));
			System.out.println("//a[contains(text(),'"+excel.getCellValue(row, column).trim()+"')]");
			driver.findElement(By.xpath("//a[contains(text(),'"+StringUtils.capitalize(excel.getCellValue(row, column).trim())+"')]")).click();
			driver.findElement(By.xpath("//input[@id='departDate']/following::img[1]")).click();
			System.out.println(new DateFormatSymbols().getMonths().length);
			System.out.println("//span[text()='"+new DateFormatSymbols().getMonths()[Integer.parseInt(excel.getCellValue(row, ++column).split("/")[1]) - 1]+"']/following::span[text()='2014']");
			while(true) {
				String year = excel.getCellValue(row, column).split("/")[2].length()==4
				?excel.getCellValue(row, column).split("/")[2]
				:"20"+excel.getCellValue(row, column).split("/")[2];
				System.out.println(year);
				List<WebElement> leftright = driver.findElements(By.xpath("//span[contains(text(),'20')]"));
				System.out.println(leftright);
				if(leftright.get(0).getText().equals(year) || leftright.get(0).getText().equals(year)) {
					if(isElementPresent(By.xpath("//span[text()='"+new DateFormatSymbols().getMonths()[Integer.parseInt(excel.getCellValue(row, ++column).split("/")[1]) - 1]+"']"))) {
						System.out.println("if");
						break;
					}else {
						driver.findElement(By.xpath("//span[text()='Next']")).click();
					}
				}else {
					driver.findElement(By.xpath("//span[text()='Next']")).click();
				}
				System.out.println("lets see ");
			}
			
			
			
//			while(true){
//				String year = excel.getCellValue(row, column).split("/")[2].length()==4
//						?excel.getCellValue(row, column).split("/")[2]
//						:"20"+excel.getCellValue(row, column).split("/")[2];
//				if(isElementPresent(By.xpath("//span[text()='"+new DateFormatSymbols().getMonths()[Integer.parseInt(excel.getCellValue(row, column).split("/")[1]) - 1]+"']/following::span[text()='"+year+"']"))){
//					break;
//				}
//				driver.findElement(By.xpath("//span[text()='Next']")).click();
//			}
			driver.findElement(By.xpath("//span[text()='"+new DateFormatSymbols().getMonths()[Integer.parseInt(excel.getCellValue(row, column).split("/")[1]) - 1]+"']/following::table[1]//a[text()='"+excel.getCellValue(row, column).split("/")[0]+"']")).click();
			
			
			
//			if(!isElementPresent(By.xpath("//span[text()='"+new DateFormatSymbols().getMonths()[Integer.parseInt(excel.getCellValue(row, column).split("/")[1]) - 1]+"']/following::table[1]//a[text()='"+excel.getCellValue(row, column).split("/")[0]+"']"))){
//				if(Integer.parseInt(driver.findElements(By.xpath("//td[@data-month]")).get(0).getAttribute("data-month"))+1 < Integer.parseInt(excel.getCellValue(row, column)) && Integer.parseInt(driver.findElements(By.xpath("//td[@data-month]")).get(0).getAttribute("data-month"))+1 - Integer.parseInt(excel.getCellValue(row, column))>1) {
//					for(int click=1;click < Integer.parseInt(excel.getCellValue(row, column)) - (Integer.parseInt(driver.findElements(By.xpath("//td[@data-month]")).get(0).getAttribute("data-month"))+1);click++) {
//						driver.findElement(By.xpath("//span[text()='Next']")).click();
//					}
//				}
////				else if(Integer.parseInt(driver.findElements(By.xpath("//td[@data-month]")).get(0).getAttribute("data-month"))+1 > Integer.parseInt(excel.getCellValue(row, column))) {
////					for(int click=1;click < Integer.parseInt(driver.findElements(By.xpath("//td[@data-month]")).get(0).getAttribute("data-month"))+1 - Integer.parseInt(excel.getCellValue(row, column));click++) {
////						driver.findElement(By.xpath("//span[text()='Prev']")).click();
////					}
////				}
//			}else {
//				driver.findElement(By.xpath("//span[text()='"+new DateFormatSymbols().getMonths()[Integer.parseInt(excel.getCellValue(row, column).split("/")[1]) - 1]+"']/following::table[1]//a[text()='"+excel.getCellValue(row, column).split("/")[0]+"']")).click();
//			}
			
			
			dropdown = new Select(driver.findElement(By.xpath("//div[@id='passgrinfo']//select[@class='autocombo' and not(@id='classTypeInt')]")));
			dropdown.selectByValue((excel.getCellValue(row, ++column).charAt(0)+"").toUpperCase());
			
			if((excel.getCellValue(row, ++column).charAt(0)+"").toUpperCase().equals("Y")) {
				File errorShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(errorShot,new File("screen_shots//"+this.getClass()+"irctc_of"+row+".png"));
			}

			Thread.sleep(2000);
			row++;
			driver.close();
			driver.switchTo().window(parenthandle);
		}
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

	
	public void insertData(By locator, int row, int column) {
		if(!excel.isCellEmpty(row, column)) {
			driver.findElement(locator).sendKeys(excel.getCellValue(row, column));
		}
	}
}
