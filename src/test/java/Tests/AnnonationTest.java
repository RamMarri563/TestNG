package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
  
public class AnnonationTest {
  @Test
  public void first() {
	  System.out.println("Test Method");
  }
  @BeforeMethod
  public void beforeMethod() {
	 
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("BeforeTest");
	  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuite");
  }

}
