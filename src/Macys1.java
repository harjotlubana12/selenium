import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Macys1 {
	private WebDriver driver;
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.macys.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testCase1() throws Exception {
//		System.out.print(driver.findElement(By.xpath("//input [@id=\"globalSearchInputField\"]")).toString());
		driver.findElement(By.xpath("//input [@id=\"globalSearchInputField\"]"));
		driver.findElement(By.xpath("//input [@id=\"globalSearchInputField\"]")).sendKeys("jeans");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input [@id=\"subnavSearchSubmit\"]")).click();
//		Thread.sleep(5000);
		System.out.println("sds");
		driver.findElement(By.xpath("//span [@id='productCount']"));
		System.out.print(driver.findElement(By.xpath("//span [@id='productCount']")).getText());
	}
	
	@Test
	public void testCase2()throws Exception {
		driver.findElement(By.xpath("//input [@id=\"globalSearchInputField\"]"));
		driver.findElement(By.xpath("//input [@id=\"globalSearchInputField\"]")).sendKeys("jeans");
		driver.findElement(By.xpath("//input [@id=\"subnavSearchSubmit\"]")).click();
//		assertTrue("Passed", driver.findElement(By.xpath("//span [@id=\"productCount\"]")).getText().equals("1306"));
		assertEquals(driver.findElement(By.xpath("//span [@id=\"productCount\"]")).getText(), "1306");
	}
	
	@Test
	public void testCase3() throws Exception {
		Thread.sleep(5000);
		ArrayList<WebElement> ls1 = new ArrayList<WebElement>(driver.findElements(By.xpath("//div[@id='globalMastheadCategoryMenu']//Li")));
		System.out.println(ls1.size());
	}
	@After
	public void ending() {
		driver.quit();
	}

}
