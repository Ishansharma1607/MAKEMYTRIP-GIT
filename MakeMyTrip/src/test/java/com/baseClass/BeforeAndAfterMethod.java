package com.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BeforeAndAfterMethod {
	public WebDriver driver ; 
	Keywords key ;

	@BeforeTest
	public void beforeMethod() throws Exception  {
		key = new Keywords(driver);
		switch (key.readproperty("browser")) {
		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		}			
	
		  key = new Keywords(driver);
		  key.getUrl(key.readproperty("URL"));
		  driver.manage().window().maximize();
	}

	@AfterTest
	public void afterMethod() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
