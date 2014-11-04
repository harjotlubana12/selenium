//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class SeleniumTest1 {
  private WebDriver driver;
  private String baseUrl;
//  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.co.in/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled6() throws Exception {
    driver.get(baseUrl + "/?gfe_rd=cr&ei=FzIpVMH1GIfC8gfH4ICYCg&gws_rd=ssl");
    driver.findElement(By.id("gbqfq")).clear();
//    driver.findElement(By.id("gfq")).sendKeys("seleni");
    driver.findElement(By.id("gbqfq")).sendKeys("seleni");
//    driver.findElement(By.xpath("")).sendKeys("seleni");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.linkText("Selenium - Web Browser Automation"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
