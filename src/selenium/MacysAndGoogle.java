package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MacysAndGoogle {
	private WebDriver driver;

	@BeforeSuite
	public void breforeSuite() {
		System.out.println("MacysAndGoogle's beforeSuite");
	}
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("MacysAndGoogle'sBefore class");
		  
	  }

	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("MacysAndGoogle'sBefore method");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("MacysAndGoogle's Before Test");
	  }
	  
	  @Test
	  public void seleniumIDE() {
		    driver.get("http://google.com" + "/?gws_rd=ssl");
		    driver.findElement(By.id("gbqfq")).clear();
		    driver.findElement(By.id("gbqfq")).sendKeys("gspann technologies");
		    driver.findElement(By.cssSelector("em")).click();
	  }

	  @Test
	  public void masycTestCase() throws Exception{
			driver.get("http://www.macys.com/");
			driver.findElement(By.xpath("//div[@id='tinybox']//a[@id='closeButton']"));
			driver.findElement(By.xpath("//a[text()='sign up for email']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Harjot");
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Singh");
			driver.findElement(By.xpath("//input[@name='EmailAddr']")).sendKeys("seleniumjava127@gmail.com");
			driver.findElement(By.xpath("//option[@value='IN']")).click();
			Thread.sleep(5000);
			//input[@name='firstName']
	  }
	  @AfterTest
	  public void afterTest() {
		System.out.println("MacysAndGoogle's Aftern Test");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("MacysAndGoogle's After method");  
			driver.quit();
	  }
	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("MacysAndGoogle's After suite");
	  }
	  @AfterClass
	  public void afterClass() {
		  System.out.println("MacysAndGoogle's After class");
	  }
}
