package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider {
	@Test(dataProvider="LoginData")
	public void TestLogin(String uname , String upass) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait for the username field to be visible and enter the username
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(uname);

	        // Wait for the password field to be visible and enter the password
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(upass);

	        // Wait for the submit button to be clickable and click it
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
		String Actualurl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(Actualurl, driver.getCurrentUrl());
		driver.quit();
	}
	
	
	@DataProvider(name="LoginData" , parallel = true)
	public Object[][] TestData(){
		Object[][] data=new Object[6][2];
		data[0][0]="Admin";
		data[0][1]="admin123";
		data[1][0]="Admin";
		data[1][1]="admin123";
		
		data[2][0]="Admin";
		data[2][1]="admin123";
		
		data[3][0]="Admin";
		data[3][1]="admin123";
		data[4][0]="Admin";
		data[4][1]="admin123";
		data[5][0]="Admin";
		data[5][1]="admin123";
		
		return data;
		
		
		
	}

}
