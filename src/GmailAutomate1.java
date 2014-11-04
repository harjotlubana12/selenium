import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GmailAutomate1 {
	private WebDriver driver;
	private String urlb1;
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		driver.get(urlb1);
//		try{
//			driver.findElement(By.xpath("//a[@id=\"gmail-sign-in\"]"));
//			driver.findElement(By.xpath("//a[@id=\"gmail-sign-in\"]")).click();
//		}catch(Exception e){
//			
//		}
	}
	
	@Test
	public void firstCase() throws Exception {
		urlb1 = "https://www.gmail.com";
		driver.get(urlb1);
//		driver.findElement(By.xpath("//a[@id='gmail-sign-in']"));
//		driver.findElement(By.xpath("//a[@id='gmail-sign-in']")).click();
//		for userName 
		
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("harjotlubana12");
//		for password
		driver.findElement(By.xpath("//input[@id=\"Passwd\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"Passwd\"]")).sendKeys("pass123");
//		if(driver.findElement(By.xpath("//span[@id=\"errormsg_0_Passwd\"]"))!=null){
//		}else{
//		}
		driver.findElement(By.xpath("//input[@id=\"signIn\"]")).click();
//		driver.findElement(By.id("signIn")).click();
		try {
//			to check for wrong password
		}catch(Exception e) {
			
		}
	}
	@Test
	public void secondCase() throws Exception {
		urlb1 = "https://www.macys.com";
		driver .get(urlb1);
		driver.findElement(By.xpath("li[@id=\"flexLabel_1\"]/a"));
		Thread.sleep(5000);
		
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.);
	}
	
	@After
	public void ending(){
		driver.quit();
	}
}
