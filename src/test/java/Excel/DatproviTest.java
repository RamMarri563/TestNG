package Excel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatproviTest {
	@Test(dataProvider = "LoginCredentials" , dataProviderClass = Apachepractise.class)
	public void log(String uname , String upass) throws InterruptedException {
	
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
	
	
	

}}
 