package com;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinks {

	 static public void main(String[] args) throws IOException, InterruptedException {
		
   
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://www.mercurytravels.co.in/");
		 
		 List<WebElement>web=driver.findElements(By.tagName("a"));
		 System.out.println(web.size());
		 for(int i=0;i<web.size();i++) {
			 WebElement name=web.get(i);
			 String url=name.getAttribute("href");
			 URL urlaa=new URL(url);
			 HttpURLConnection urlconn=(HttpURLConnection)urlaa.openConnection();
			 Thread.sleep(5000);
			 urlconn.connect();
			 int respcode=urlconn.getResponseCode();
			 if(respcode>=400) {
				 System.out.println("brokenlink");
			 }
			 else{
				 System.out.println("not a brokenlink");
				  
			 }
			 
		 }
		 driver.quit();
		 
	}

}
