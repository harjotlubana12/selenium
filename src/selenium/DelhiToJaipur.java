package selenium;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DelhiToJaipur {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	private Select dropdown;
	

	@BeforeMethod 
	public void beforeTest(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		builder = new Actions(driver);
		wait = new WebDriverWait(driver, 60);
	}
	
	@Test
	public void cheapestClass() throws Exception{
		driver.get("https://www.irctc.co.in/");
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Flights")).click();
		Set<String> allwindows = driver.getWindowHandles();
		for(String flightwindow:allwindows){
			if(!flightwindow.equals(parentwindow)){
				driver.switchTo().window(flightwindow);
				driver.findElement(By.id("origin")).sendKeys("DEL");
				driver.findElement(By.linkText("New Delhi, DEL")).click();
				driver.findElement(By.id("destination")).sendKeys("JAI");
				driver.findElement(By.linkText("Jaipur, JAI")).click();
//				driver.findElement(By.xpath("//input[@id='departDate']/preceding::img[@class='ui-datepicker-trigger'][0]")).click();
				driver.findElement(By.xpath("//input[@id='departDate']/following::img[1]")).click();
				driver.findElement(By.xpath("//span[text()='November']/following::table[1]//a[text()='15']")).click();
				dropdown = new Select(driver.findElement(By.xpath("//div[@id='passgrinfo']//select[@class='autocombo' and not(@id='classTypeInt')]")));
				dropdown.selectByValue("B");
				driver.findElement(By.xpath("//div[@id='searchopt_dom']/following::div[@class='srchbtn']")).click();
				//a id="minPrice"
				if(!driver.findElement(By.id("minPrice")).isDisplayed()) {
					driver.findElement(By.id("maxPrice")).click();
				}
				System.out.println(driver.findElements(By.xpath("//div[@id='flightListResult']/div")).size());
				System.out.println(driver.findElement(By.xpath("//div[@id='flightListResult']/div[1]//tr[1]//div[@class]/ancestor::td[1]")).getText());
				System.out.println(driver.findElement(By.xpath("//div[@id='flightListResult']/div[1]//tr[1]//span[@class='onewayprice']")).getText());
				File errorShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(errorShot,new File("screen_shots//"+this.getClass()+".png"));
			}
		}
	}
	
	@Test
	public void getPlacesOfInterest() throws Exception{
		driver.get("https://www.irctc.co.in/");
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Flights")).click();
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows);
		for(String flightwindow:allwindows) {
			if(driver.switchTo().window(flightwindow).getTitle().equals("IRCTC Online Passenger Reservation System")){
				break;
			}
		}
		System.out.println("Flight Page Title--->>"+driver.getTitle());
		driver.close();
		driver.switchTo().window(parentwindow);
		System.out.println("Home Page Title--->>"+driver.getTitle());
////////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.id("loginbutton")).click();
		driver.findElement(By.className("close")).click();
///////////////////////////////////////////////////////////////////////////////////////////////
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='banner3']/iframe"))).findElement(By.xpath("//img")).click();
		allwindows = driver.getWindowHandles();
		for(String maharajawindow:allwindows) {
			if(driver.switchTo().window(maharajawindow).getTitle().equals("Maharajas' Express | Official Website of Luxury Train Tour India"))
				break;
		}
		builder.moveToElement(driver.findElement(By.xpath("//div[@id='nav']//a[text()='Journeys']"))).moveToElement(driver.findElement(By.xpath("//div[@id='nav']//a[text()='Gems of India']"))).click(driver.findElement(By.xpath("//div[@id='nav']//a[text()='Gems of India']/ancestor::li[1]//a[text()='Jaipur']"))).build().perform();
		driver.findElement(By.linkText("Places Of Interest")).click();
		List<WebElement> listfoplaces = driver.findElements(By.xpath("//div[@id='view2']//h3"));
		for(WebElement place:listfoplaces) {
			System.out.println(place.getText());
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
