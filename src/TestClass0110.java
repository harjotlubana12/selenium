import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import beforeafter.Always;

//TestClass0110 extends Always which contains before and after parts and functions like randomGenerator and clickingProcess
public class TestClass0110 extends Always{
	private  static WebDriverWait wait;// = new WebDriverWait(driver, 180);
	String selectedtitle = "", titlename = "", parentblock = "", finalxpath = "",brandparentxpath = "", brandfinalxpath = "";
	
	public TestClass0110() {
		System.out.println("Constructor calling TestClass0110");
		wait = new WebDriverWait(driver, 180);
	}
	
	@Test
	public void mailCompose() throws Exception{
		driver.get("https://login.microsoftonline.com/");
		Thread.sleep(5000);
//		for userName 
		System.out.println(driver.findElement(By.xpath("//input[@id='cred_userid_inputtext']")).isDisplayed());
		driver.findElement(By.xpath("//input[@id='cred_userid_inputtext']")).clear();
		driver.findElement(By.xpath("//input[@id='cred_userid_inputtext']")).sendKeys("harjot.singh@gspann.com");
//		for password
		driver.findElement(By.xpath("//input[@id='cred_password_inputtext']")).clear();
		driver.findElement(By.xpath("//input[@id='cred_password_inputtext']")).sendKeys(pass);
//		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@id='cred_sign_in_button']")));
		while(true) {
			try {
				clickingProcess("//span[@id='cred_sign_in_button']");
				System.out.println("count click");
			}catch(Exception e) {
				break;
			}
		}
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='_ariaId_32']")));
		clickingProcess("//span[@id='_ariaId_32']");
		driver.findElement(By.xpath("//div[@class='_mcp_Z ms-bg-color-white customScrollBar']/div[3]//input")).sendKeys("seleniumjava127@gmail.com");
		driver.findElement(By.xpath("//div[@class='_mcp_o1']/div[@class='_mcp_N1']/input")).sendKeys("Test mail(ignore)");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='EditorBody']"))); //switchTo() helps to locate xpath inside the frame
		((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = ''", driver.findElement(By.xpath("//div[@id='MicrosoftOWAEditorRegion']")) );
		driver.findElement(By.xpath("//div[@id='MicrosoftOWAEditorRegion']")).sendKeys("Hi,\nIts working\r\n\r\nRegards,\r\nHarjot Singh\r\n+919818306851");
//		driver.switchTo().window(driver.getWindowHandle()); 
		driver.switchTo().defaultContent(); //For Switch to default content from frame
//		java script helps to click send button
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[@class='_mcp_G1 ms-font-weight-regular sendButton o365button ms-font-m ms-font-color-neutralSecondary']")));
		Thread.sleep(5000);
		
	}
	
	@Test
	public void mailDelete() throws Exception{
		driver.get("https://login.microsoftonline.com/");
		Set<String> seleniumtext = new HashSet<String>();
		seleniumtext.add("seleniumjava127@gmail.com");
		int count = 2;
		Thread.sleep(5000);
//		for userName 
		System.out.println(driver.findElement(By.xpath("//input[@id='cred_userid_inputtext']")).isDisplayed());
		driver.findElement(By.xpath("//input[@id='cred_userid_inputtext']")).clear();
		driver.findElement(By.xpath("//input[@id='cred_userid_inputtext']")).sendKeys("harjot.singh@gspann.com");
//		for password
		driver.findElement(By.xpath("//input[@id='cred_password_inputtext']")).clear();
		driver.findElement(By.xpath("//input[@id='cred_password_inputtext']")).sendKeys(pass);
//		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@id='cred_sign_in_button']")));
		while(true) {
			try {
				clickingProcess("//span[@id='cred_sign_in_button']");
				System.out.println("count click");
			}catch(Exception e) {
				break;
			}
		}
		clickingProcess("//div[@class='folderPaneGradient']//div[@class='treeNodeRowContainer']//span[text()='Sent Items']");//_ariaId_124.folder
		clickingProcess("//div[@class='conductorContent']//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]/div[ 2 ]/div/button/span[1]");
		System.out.println(driver.findElements(By.xpath("//div[@class='conductorContent']//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]/div[ contains(@id, '_') ]/div/button/span[1]")));
		List<WebElement> sentitem = driver.findElements(By.xpath("//div[@class='conductorContent']//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]/div[ contains(@id, '_') ]/div/button/span[1]"));
		System.out.println(sentitem.get(1));
		System.out.println(driver.findElement(By.xpath("//div[@class='conductorContent']//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]/div[ 2 ]/div/div[3]/div[1]/span[2]")).getText()+"<<<<----->>>");
//		System.out.println(driver.findElement(By.xpath("//div[@class='conductorContent']//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]/div[ 1 ]/div/div[3]/div[1]/span[2]")).getText());
		//[[FirefoxDriver: firefox on XP (7f37ebad-0b40-4a93-bb55-c490c14bff01)] -> xpath: 
		//div[@class='conductorContent']//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]/div[ contains(@id, '_') ]/div/button/span[1]]
//		String element = "[[FirefoxDriver: firefox on XP (7f37ebad-0b40-4a93-bb55-c490c14bff01)] -> xpath: //div[@class='conductorContent']//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]/div[ contains(@id, '_') ]/div/button/span[1]]";
//		System.out.println(element.toString().split("xpath: ")[1].replace("/div/button/span[1]]", "/div/div[3]/div[1]/span[2]").replace("contains(@id, '_')", "2"));
		for(WebElement tempelement:sentitem) {
			try {
//			if(count == 1){
//				count++;
//				continue;
//			}
			System.out.println(tempelement.toString().split("xpath: ")[1].replace("/div/button/span[1]]", "/div/div[3]/div[1]/span[2]").replace("contains(@id, '_')", count+"")+"-->>");
			System.out.println(count+" <---> "+driver.findElement(By.xpath(tempelement.toString().split("xpath: ")[1].replace("/div/button/span[1]]", "/div/div[3]/div[1]/span[2]").replace("contains(@id, '_')", count+""))).getText().equals("seleniumjava127@gmail.com"));
			if(driver.findElement(By.xpath(tempelement.toString().split("xpath: ")[1].replace("/div/button/span[1]]", "/div/div[3]/div[1]/span[2]").replace("contains(@id, '_')", count+""))).getText().equals("seleniumjava127@gmail.com")){
//			if(driver.findElement(By.xpath(tempelement.toString().split("xpath: ")[1].replace("/div/button/span[1]]", "/div/div[3]/div[1]/span[2]").replace("contains(@id, '_')", count+""))).getText().equals("chiranjeeviaggarwal@gmail.com")){
				System.out.println("count-->>"+count);
				System.out.println(count+" <---> "+driver.findElement(By.xpath(tempelement.toString().split("xpath: ")[1].replace("/div/button/span[1]]", "/div/div[3]/div[1]/span[2]").replace("contains(@id, '_')", count+""))).getText());
				tempelement.click();
			}
			}catch(Exception e) {
				System.out.println("Exception ");
				count--;
			}
			count++;
		}
		clickingProcess("//div[@class='conductorContent']//span[text()='DELETE']");
//		sentitem.get(1).click();
		//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]
		//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]/div[contains(@id, '_')]
		//div[@class='conductorContent']//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]/div[ 2 ]/div/button/span[1]
		//div[@class='conductorContent']//div[@class='conductorContent']/div[1]/div[1]/div/div/div[1]/div[2]/div/div[3]/div[1]/span[3]
		Thread.sleep(5000);
	}
	@Test
	public void macysNavigationTest() throws Exception{
		driver.get("http://www.macys.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tinybox']//a[@id='closeButton']")));
		clickingProcess("//div[@id='tinybox']//a[@id='closeButton']");
		clickingProcess("//div[@id='globalMastheadCategoryMenu']//Li["+randomGenerator("//div[@id='globalMastheadCategoryMenu']//Li", 0)+"]/a");
		sidePanel();
		System.out.println("After random");
		System.out.println("After visibility");
		assertTrue("we are not on Second page:-TEST CASE FAIL", correctPage("arrowRight", 2));
		System.out.println("second true");
		assertTrue("we are not on Second page:-TEST CASE FAIL", correctPage("arrowLeft", 1));
		System.out.println("first true");
		selectedtitle = ""; titlename = ""; parentblock = ""; finalxpath = ""; brandparentxpath = ""; brandfinalxpath = ""; selectedtitle = ""; titlename = ""; parentblock = ""; finalxpath = ""; brandparentxpath = ""; brandfinalxpath = "";
	}
	
	@Test
	public void test() throws Exception{
		driver.get("http://www.macys.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tinybox']//a[@id='closeButton']")));
		clickingProcess("//div[@id='tinybox']//a[@id='closeButton']");
//		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']//Li[2]/a")),"class", "selected-flyout");
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('class','selected-flyout')", driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']//Li[2]")));
//		((JavascriptExecutor)driver).executeScript("document.getElementById('flexLabel_16904').setAttribute('class', 'selected-flyout')",driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']//Li[2]")));
		System.out.println("000----+"+driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']//Li[2]/a")).getAttribute("class"));
		Thread.sleep(5000);
	}
	@Test
	public void macysRandomSelection() {
//		home page
		driver.get("http://www.macys.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tinybox']//a[@id='closeButton']")));
		clickingProcess("//div[@id='tinybox']//a[@id='closeButton']");
//		selectedtitle = "//div[@id='globalMastheadCategoryMenu']//Li["+randomGenerator("//div[@id='globalMastheadCategoryMenu']//Li", 0)+"]/a";
		selectedtitle = "//div[@id='globalMastheadCategoryMenu']//Li[10]/a";
		titlename= driver.findElement(By.xpath(selectedtitle)).getText().toLowerCase().trim();
		clickingProcess(selectedtitle);
		sidePanel();
		parentblock = ""; finalxpath = "";
		if(selectedtitle.equals("home")) {
			
		}
		try {
		clickingProcess("//ul[@id='thumbnails']/li["+randomGenerator("//ul[@id='thumbnails']/li", 0)+"]//div[@class='shortDescription']/a");
		}catch(Exception e) {
			assertTrue("There is no item present", false);
		}
		System.out.println("Title is:- "+driver.findElement(By.xpath("//h1[@id='productTitle']")).getText());
		selectedtitle = ""; titlename = ""; parentblock = ""; finalxpath = ""; brandparentxpath = ""; brandfinalxpath = ""; selectedtitle = ""; titlename = ""; parentblock = ""; finalxpath = ""; brandparentxpath = ""; brandfinalxpath = "";
	}
	
	void sidePanel(){
		while(true) {
			System.out.println("while");
			try{
				System.out.println("inside try block");
				driver.findElement(By.xpath("//ul[@id='firstNavSubCat']/li"));
			String parentblock = "//ul[@id='firstNavSubCat']/li["+randomGenerator("//ul[@id='firstNavSubCat']/li", 0)+"]";  //will throw exception if we are in brands
			System.out.println("try second line");
			System.out.println(parentblock+""+driver.findElements(By.xpath(parentblock+"//li")));
//			
//			For Specials and sales & clearance links
//			
			String finalxpath = driver.findElements(By.xpath(parentblock+"//li")).isEmpty()
					?parentblock
					:parentblock+"//li["+randomGenerator(parentblock+"//li", 0)+"]";
			System.out.println(finalxpath);
			if(driver.findElement(By.xpath(finalxpath)).isDisplayed()){
				System.out.println(finalxpath);
				clickingProcess(finalxpath+"/a");
				break;
			}
			}catch(Exception e) {	// For Brands tag
				System.out.println("inside catch block");
//				System.out.println(randomGenerator("//div[@class='subCatList']/div", 0));
				clickingProcess("//div[@class='subCatList']/div["+randomGenerator("//div[@class='subCatList']/div", 0)+"]/a");
				System.out.println(driver.getTitle());
				brandparentxpath = "//div[@id='brandIndex']/div["+randomGenerator("//div[@id='brandIndex']/div", 3)+"]";
				System.out.println(brandparentxpath);
				brandfinalxpath = brandparentxpath+"/ul["+randomGenerator(brandparentxpath+"/ul", 0)+"]";
				brandfinalxpath = driver.findElements(By.xpath(brandfinalxpath+"//a")).size() == 1
						?brandfinalxpath+"//a"
						:brandfinalxpath+"/li["+randomGenerator(brandfinalxpath+"/li", 0)+"]/a"
				;
				System.out.println(brandfinalxpath);
				clickingProcess(brandfinalxpath);
				break;
			}
		}
	}

	public boolean correctPage(String arrow, int pagenumber) throws Exception{
		try {
			clickingProcess("//div[@id='paginateTop']/a[contains(@class, '"+arrow+"')]");
		}catch(Exception e) {
			assertTrue("There is no arrow button on this page", false);
		}
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//div[@id='paginateTop']/a[text()='"+pagenumber+"']")).getAttribute("class").equals("currentPage paginationSpacer");
	}
}

