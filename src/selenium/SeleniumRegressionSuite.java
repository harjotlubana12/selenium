package selenium;

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

public class SeleniumRegressionSuite {


  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("seleniumRegressionSuite's Before suite");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("seleniumRegressionSuite's Before class");
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("seleniumRegressionSuite's Before method");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("seleniumRegressionSuite's Before Test");
  }
  
  @Parameters({"firstname", "lastname"})
  @Test
  public void test1(String first, String last) {
	  System.out.println("seleniumRegressionSuite's Test1 Printing "+first+" "+last);
  }

  @Test
  public void test2() {
	  System.out.println("seleniumRegressionSuite's test2 printting");
  }

  @AfterTest
  public void afterTest() {
	System.out.println("seleniumRegressionSuite's Aftern Test");  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("seleniumRegressionSuite's After method");
  }
  @AfterSuite
  public void afterSuite() {
	  System.out.println("seleniumRegressionSuite's After suite");
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("seleniumRegressionSuite's After class");
  }
}
