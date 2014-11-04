package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumTest {
  private WebDriver driver;
  private String baseUrl;
  
  public SeleniumTest() {
	  System.out.println("constructor printing");
  }

//  @Before
//  public void setUp() throws Exception {
//    driver = new FirefoxDriver();
//    baseUrl = "https://www.google.com/";
//    driver.manage().window().maximize();
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before suite");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before class");
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }
  
  @Parameters({"firstname", "lastname"})
  @Test
  public void test1(String first, String last) {
	  System.out.println("Test1 Printing "+first+" "+last);
  }

//  
//  @Test
//  public String test3() {
//	  System.out.print("test3");
//	  return "sds";
//  }

////@Parameters("username")
//@Test(dependsOnMethods = {"test2"})
//public void test1() throws Exception {
//	  System.out.println("Test1 Printing ");
//}
  @Test
  public void test2() {
	  System.out.println("test2 printting");
  }

  @AfterTest
  public void afterTest() {
	System.out.println("Aftern Test");  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method");
  }
  @AfterSuite
  public void afterSuite() {
	  System.out.println("After suite");
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("After class");
  }
//  @After
//  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }

}
