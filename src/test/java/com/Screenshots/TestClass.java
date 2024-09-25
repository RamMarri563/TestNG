package com.Screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass extends BaseTest {
	
	
	 @Test
		public void  openGmail() throws InterruptedException {
	    	WebDriverManager.chromedriver().setup();
	    	WebDriver driver=new ChromeDriver();
	    	driver.manage().window().maximize();
	    	driver.get("https://www.google.com/");
	    	driver.findElement(By.name("q")).sendKeys("Gmail",Keys.ENTER);
	    	System.out.println(driver.getTitle());
	    	Thread.sleep(5000);
	    	driver.quit();
	    }
	    
	    	 @Test(testName ="openfacebook" )
	    		public void  openfacebook() throws InterruptedException {
	    	    	WebDriverManager.chromedriver().setup();
	    	    	WebDriver driver=new ChromeDriver();
	    	    	driver.manage().window().maximize();
	    	    	driver.get("https://www.facebook.com/login/");
	    	    	driver.findElement(By.name("email")).sendKeys("Gmail",Keys.ENTER);
	    	    	String actaul=driver.getCurrentUrl();
	    	    	String expe="httppps";
	    	    	Assert.assertEquals(actaul, expe);
	    	    	Thread.sleep(5000);
	    	    	driver.quit();
	    	    }
	    	
	    

}
