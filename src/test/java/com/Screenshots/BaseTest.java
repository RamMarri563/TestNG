package com.Screenshots;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static String schreenshotFoldername;
	
@BeforeTest
	public void setup() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	
		
	}
@AfterTest
	public void tearDown() {
	driver.quit();

}

public void catureScreenshot(String fileName) throws IOException {
	if(schreenshotFoldername ==null) {
	 LocalDateTime myDateObj = LocalDateTime.now();
	 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	 String schreenshotFoldername = myDateObj.format(myFormatObj);
	}
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	File destFile = new File("C:\\Users\\Dell\\Desktop\\TestNG1\\practiseTestNG\\screenshotss"+ fileName);
	
	FileUtils.copyFile(sourceFile, destFile);
	
	System.out.println("Screenshot saved successfully");



}
}