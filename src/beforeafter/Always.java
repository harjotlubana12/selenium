package beforeafter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Always {
	public static WebDriver driver; //= new FirefoxDriver();
	public String pass = "Harjot127";
	
	public Always() {
		driver = new FirefoxDriver();
	}
	@Before
	public void setUp() {
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	@After
	public void ending() {
		driver.quit();
	}
	
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
//	clickingProcess is only to click given xpath in xpathtoclick
	public void clickingProcess(String xpathtoclick) {
		driver.findElement(By.xpath(xpathtoclick)).click();
	}
}
