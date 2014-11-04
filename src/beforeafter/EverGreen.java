package beforeafter;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class EverGreen {
	static public WebDriver driver;
	
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

	public static boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}

}
