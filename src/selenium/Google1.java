package selenium;

import beforeafter.EverGreen;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Google1 {
	private WebDriver driver;
	private Actions builder;
	private Alert jscriptalert;
	
	@BeforeClass
	public void beforeClass() {
	}
	
	@BeforeMethod 
	public void beforeTest(){
//		System.setProperty("webdriver.chrome.driver", "browserexe\\chromedriver.exe");
//			driver = new ChromeDriver();
//		System.setProperty("webdriver.ie.driver", "browserexe\\IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		builder = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void acceptAlert() throws Exception{
		((JavascriptExecutor)driver).executeScript("alert(\"Welcome\")");
		Thread.sleep(2000);
		jscriptalert = driver.switchTo().alert();
		System.out.println(jscriptalert.getText());
		jscriptalert.accept();
	}
	
	@Test (enabled = false)
	public void isMacysPresentUrl() {
		driver.get("https://www.macys.com/");
		Assert.assertTrue(driver.getCurrentUrl().contains("macys.com"));
	}
	
	@Test (enabled = false)
	public void sorry(){
		Actions builder = new Actions(driver);
	}
	
	@Test (enabled = false)
	public void searchTest() {
		driver.get("http://www.google.com/");
//		Assert.assertEquals("Google Search", driver.findElement(By.id("gbqfba")).getText());
//		Assert.assertEquals("gbqfba", driver.findElement(By.id("gbqfba")).getAttribute("id"));
		System.out.println(driver.findElement(By.xpath("//div[@id='hplogo']")).getCssValue("background"));
	}
	
	@Test (enabled = false)
	public void forthLink() throws Exception {
		driver.get("http://www.google.co.in/");
		String linktext = driver.findElements(By.xpath("//div[@id='als']/a")).get(3).getText();
		driver.findElement(By.id("gbqfq")).sendKeys(linktext);
		System.out.println(linktext);
		((JavascriptExecutor)driver).executeScript("alert('hi')");
		((JavascriptExecutor)driver).executeScript("alert(document.getElementsByTagName('html').length)");
		Thread.sleep(5000);
//		driver.findElement(By.id("gbqfba")).click();
		driver.findElement(By.id("gbqfb")).click();
		Thread.sleep(5000);
	}
	
	@Test (enabled = false)
	public void screenShotTest() throws Exception{
		driver.get("http://www.google.co.in/");
		String linktext = driver.findElements(By.xpath("//div[@id='als']/a")).get(3).getText();
		driver.findElement(By.id("gbqfq")).sendKeys(linktext);
		driver.findElement(By.id("gbqfb")).click();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("D:\\png\\"+linktext+"'s_issue.png"));
	}
	
	@Test(enabled = false)
	public void seleniumInCaps() throws Exception{
		driver.get("https://www.google.co.in/");
//		driver.findElement(By.id("gbqfq")).sendKeys("");
//		builder.keyDown(Keys.LEFT_SHIFT).sendKeys(driver.findElement(By.xpath("//div[@id='gbqfqwb']//input[2]")), "selenium").keyUp(Keys.LEFT_SHIFT).build().perform();
//		Assert.assertTrue(EverGreen.isElementPresent(By.xpath("//div[@id='gbqfqwb']//input[3]")));
		driver.findElement(By.id("gbqfq")).click();
		builder.clickAndHold();
		builder.moveToElement(driver.findElement(By.id("gbqfq"))).click(driver.findElement(By.id("gbqfq"))).build().perform();
//		driver.findElement(By.id("gbqfq")).click();
		builder.keyDown(Keys.LEFT_SHIFT).build().perform();
		builder.sendKeys(driver.findElement(By.id("gbqfq")), "selenium").build().perform();
//		driver.findElement(By.id("gbqfq")).sendKeys("selenium");
		builder.keyUp(Keys.LEFT_SHIFT).build().perform();
		Thread.sleep(10000);
	}
	
	@AfterMethod
	public void afterTest(){
		driver.quit();
	}
	
	

}
