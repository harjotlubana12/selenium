package selenium;

import java.io.File;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parallel27Oct {
	private WebDriver driver;
	private WebDriverWait wait;
	

	@Parameters ("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "browserexe\\chromedriver.exe");
			System.out.println(System.getProperty("webdriver.chrome.driver"));
			driver = new ChromeDriver();
		}else if(browser.equals("IE")){
			System.setProperty("webdriver.ie.driver", "browserexe\\IEDriverServer.exe");
			System.out.println(System.getProperty("webdriver.ie.driver"));
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}
	
	@Parameters("browser")
	@Test(enabled = false)
	public void isLogoPresentMacys(String browser) throws Exception{
		driver.get("https://www.macys.com/");
		Thread.sleep(5000);
		System.out.println(browser+"----"+isElementPresent(By.id("macysHomePageLogo")));
		Assert.assertTrue(isElementPresent(By.id("macysHomePageLogo")));
	}
	
	public  boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	@Test(enabled=false)
	public void isMacysPresentUrl() {
		driver.get("https://www.macys.com/");
		Assert.assertTrue(driver.getCurrentUrl().contains("macys.com"));
	}
	
	@Parameters("browser")
	@Test(enabled=true)
	public void profileScreenShotParallel(String browser) throws Exception{
		  driver.get("https://www.macys.com/account/profile");
		  driver.findElement(By.xpath("//button[@id='createProfileBtn']")).click();
		  Thread.sleep(2000);
		 
		  File errorShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(errorShot,new File("screen_shots//"+browser+"_ERRORSHOT.png"));
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
