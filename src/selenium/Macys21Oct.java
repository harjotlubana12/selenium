package selenium;



import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Macys21Oct {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	private Select dropdown;
	String selectedtitle, titlename, parentblock, finalxpath, brandparentxpath, brandfinalxpath, expecteditems, actualitems;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
//		builder = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.macys.com/");
		builder = new Actions(driver);
		selectedtitle = ""; titlename = ""; parentblock = ""; finalxpath = ""; brandparentxpath = ""; brandfinalxpath = ""; expecteditems = ""; actualitems = "0";
	}
	
	@Test 
	public void verifyQuantiy() throws Exception{
		while(true) {
			builder.moveToElement(driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']//li["+randomGenerator("//div[@id='globalMastheadCategoryMenu']//li", 0)+"]/a"))).build().perform();
			Thread.sleep(3000);
			
//			driver.findElements(By.xpath("//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']//ul/li/a")).get(randomGenerator("//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']//ul/li/a", -1)).click();
			
			parentblock= "//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']/div/div["+randomGenerator("//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']/div/div", 0)+"]";
			System.out.println("----1----"+parentblock);
			parentblock = parentblock+"/ul["+randomGenerator(parentblock+"/ul", 0)+"]";
			System.out.println("----2----"+parentblock);
			finalxpath = parentblock+"/li["+randomGenerator(parentblock+"/li", 1)+"]/a";
			System.out.println("----3----"+finalxpath);
			System.out.println(driver.findElement(By.xpath(finalxpath)).getText());
			clickingProcess(finalxpath);
			
			try {
				System.out.println("Inside try block");
				
				if(!driver.findElement(By.id("brandFacets")).isDisplayed())
					driver.findElement(By.id("BRAND")).click();
				
				if(!driver.findElement(By.id("featuredBrands")).isDisplayed())
					driver.findElement(By.id("featuredBrandsHdr")).click();
				
				
				String featuredbrand = "//ul[@id='featuredBrands']/li["+randomGenerator("//ul[@id='featuredBrands']/li", 0)+"]";
				System.out.println("Featured Brand-->"+driver.findElement(By.xpath(featuredbrand)));
				expecteditems = driver.findElement(By.xpath(featuredbrand+"/span[2]")).getText();
				clickingProcess(featuredbrand+"/span[1]");
			}catch(Exception e) {
				System.out.println("Inside catch block");
				continue;
			}
			dropdown = new Select(driver.findElement(By.id("ppp")));
			dropdown.selectByValue("100");
			Thread.sleep(2000);
			while(true) {	
				try {
					actualitems = ( Integer.parseInt(actualitems) + driver.findElements(By.xpath("//ul[@id='thumbnails']/li")).size() )+"";
					clickingProcess("//div[@id='paginateTop']/a[@class='arrowRight']");
				}catch(Exception e){
					break;
				}
			}
			Assert.assertEquals(expecteditems.trim(), "("+actualitems+")");
			break;
		}
	}
	
	@Test 
	public void verifyPagination() throws Exception{
		while(true) {
			builder.moveToElement(driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']//li["+randomGenerator("//div[@id='globalMastheadCategoryMenu']//li", 0)+"]/a"))).build().perform();
			Thread.sleep(3000);
			
			parentblock = "//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']/div/div["+randomGenerator("//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']/div/div", 0)+"]";
			parentblock = parentblock+"/ul["+randomGenerator(parentblock+"/ul", 0)+"]";
			finalxpath = parentblock+"/li["+randomGenerator(parentblock+"/li", 1)+"]/a";
			System.out.println(finalxpath);
			System.out.println(driver.findElement(By.xpath(finalxpath)).getText());
			clickingProcess(finalxpath);
			
			try {
			clickingProcess("//div[@id='paginateTop']/a[contains(@class, arrowRight')]");
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='paginateTop']/a[text()='2']")).getAttribute("class").equals("currentPage paginationSpacer"));
			System.out.println("second true");
			clickingProcess("//div[@id='paginateTop']//a[@class='paginationSpacer' and text()='1']");
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='paginateTop']/a[text()='1']")).getAttribute("class").equals("currentPage paginationSpacer"));
			System.out.println("first true");
			}catch(Exception e) {
				continue;
			}
			break;
		}
	}
	
	@Test 
	public void createProfile() throws Exception{
		  driver.get("https://www.macys.com/account/profile");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//button[@id='createProfileBtn']")).click();
		 
		  File errorShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(errorShot,new File("screen_shots//ERRORSHOT.png"));
		  
		//div[@class='large-8 columns create-profile']//input
		//div[@class='large-8 columns create-profile']//select
		  
//		  List<WebElement> inputfield = driver.findElements(By.xpath("//div[@class='large-8 columns create-profile']//input"));
//		  for( WebElement we:inputfield) {
//			  
//		  }
		  
		  driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Harjot");
		  driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Singh");
		  driver.findElement(By.xpath("//input[@id='addressLine1']")).sendKeys("ABC");
		  driver.findElement(By.xpath("//input[@id='addressLine2']")).sendKeys("DEF");
		  driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Jalandhar");
		  Select dd=new Select(driver.findElement(By.xpath("//select[@id='state']")));
		  dd.selectByValue("LA");
		  driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("132039");
		  Select d3=new Select(driver.findElement(By.xpath("//select[@id='month']")));
		  d3.selectByValue("10");
		  driver.findElement(By.xpath("//select[@id='date']//option[@value='17']")).click();
		  driver.findElement(By.xpath("//select[@id='year']//option[@value='1991']")).click();
		  driver.findElement(By.xpath("//select[@id='gender']//option[@value='M']")).click();
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("harjot@gmail.com");
		  driver.findElement(By.xpath("//input[@id='createConfirmEmail']")).sendKeys("harjot@gmail.com");
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");
		  driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("123");
		  driver.findElement(By.xpath("//select[@id='SecurityQna']//option[@value='6']")).click();
		  driver.findElement(By.xpath("//input[@id='securityAns']")).sendKeys("MOUSER");
		  driver.findElement(By.xpath("//input[@id='MacysCardNumbar']")).sendKeys("2327000100121096");
		  driver.findElement(By.xpath("//input[@id='Ssn']")).sendKeys("0001");
		  isElementPresent(By.id("Ssn"));
		  Thread.sleep(10000); 
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	

/*
 * 
 */
	public int randomGenerator(String xpathtofindsize, int notincluded) {
		Random rn = new Random();
		int anynumber;
		while(true) {
			anynumber = rn.nextInt(driver.findElements(By.xpath(xpathtofindsize)).size()+1);
			if(anynumber > notincluded)
				break;
		}
		return anynumber;
	}

	public void clickingProcess(String xpathtoclick) {
		driver.findElement(By.xpath(xpathtoclick)).click();
	}
	
	boolean isElementPresent(By b) {
		driver.findElement(b).sendKeys("working");
		return true;
	}
}
