package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	
	WebDriver driver;

	@BeforeTest // Ensure driver is initialized before every test
	@Parameters("browserName")
	public void open(String browser) throws InterruptedException {
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	@Parameters({"userName", "passWord"})
	public void Login(String uname, String upass) throws InterruptedException {
       Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys(uname);
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(upass); // Fixed missing password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test
	public void verifyLogin() {
		String actualTitle = driver.getCurrentUrl();
		String expectedTitle = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	@Parameters("url")
	public void LaunchUrl(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		
		// Using explicit wait to ensure the page loads completely
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(url));
	}
}
