import static org.junit.Assert.*;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestCase3009 {
	private WebDriver driver;
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void gmailTestCase() throws Exception{
		driver.get("https://gmail.com");
//		for userName 
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("seleniumjava127");
//		for password
		driver.findElement(By.xpath("//input[@id=\"Passwd\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"Passwd\"]")).sendKeys("testcase123");
//		for signIn
		driver.findElement(By.xpath("//input[@id=\"signIn\"]")).click();
		String actualinbox = driver.findElement(By.xpath("//div [@class='ar5 J-J5-Ji']//span[@class='Dj']/b[3]")).getText();
		driver.findElement(By.xpath("//div[@class='aDP']/div[1]/div[2]//tbody/tr[2]/td[2]/div")).click();
		driver.findElement(By.xpath("//div [@class='ar9 T-I-J3 J-J5-Ji']")).click();
		driver.findElement(By.xpath("//span [@id='link_undo']")).click();
		Thread.sleep(8000);
		String finalinbox = driver.findElement(By.xpath("//div [@class='ar5 J-J5-Ji']//span[@class='Dj']/b[3]")).getText();
		System.out.println("finalInbox"+finalinbox);
		assertEquals(actualinbox,finalinbox);
	}

	@Test
	public void macysTestCase() throws Exception {
		driver.get("http://www.macys.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='tinybox']//a[@id='closeButton']")).click();
		Random rn = new Random();
		int anynumber;
		while(true) {
			anynumber = rn.nextInt(driver.findElements(By.xpath("//div[@id='globalMastheadCategoryMenu']//Li")).size()+1);
			if(anynumber != 0)
				break;
		}
		System.out.println(anynumber);
//		String link = (driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']//Li["+anynumber+"]/a")).getAttribute("href"));
//		System.out.println("link:-"+link);
//		driver.get(link);
		String actual = driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']//Li["+anynumber+"]")).getText();
		driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']//Li["+anynumber+"]/a")).click();
		System.out.println(actual.toLowerCase(Locale.UK));
		if(anynumber == 11){
			assertEquals("ALL "+actual.toUpperCase(), driver.findElement(By.xpath("//h1 [@id='currentCat_63538']")).getText().toUpperCase());
		}else{
			assertEquals(actual.toUpperCase(), driver.findElement(By.xpath("//div[@id='nav_title']//a")).getText().toUpperCase());
		}
	}
	
	@After
	public void ending() {
		driver.quit();
	}
}
