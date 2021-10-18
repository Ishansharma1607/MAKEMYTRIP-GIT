package com.mmt.testcases;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class AmzonExcelCSV {
	
	WebDriver driver ;
	CSVReader csvreader;
	String browser1;
	String URL;

	
	@BeforeTest

	public void readprperty() throws IOException {

		FileInputStream fis = new FileInputStream("Utilities\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);

		browser1 = prop.getProperty("browser");
		URL = prop.getProperty("URL3");
		fis.close();		
		
		
		
	}
	
	
	@BeforeTest
	public void setup()
	{
		
		switch (browser1) {
		case "firefox":

			System.setProperty("webdriver.gecko.driver", "Utilities\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Utilities\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		}	
		
	
		driver.get(URL);
		
	}
	
	@Test
	public void gstest() throws IOException, CsvValidationException, InterruptedException {
		
	CSVReader csvreader ;
	csvreader = new CSVReader(new FileReader("Utilities\\Amazon.csv"));
		
	{
	      WebElement element = driver.findElement(By.cssSelector("#nav-link-accountList > .nav-line-2"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    
	    driver.findElement(By.linkText("Start here.")).click();
	

	    String[] csvCell;
	    while (csvreader.readNext() != null)
	    {

	    csvCell = csvreader.readNext();
	    String name = csvCell[0];
	    String email = csvCell[1];
	    String pass = csvCell[2];
	    String conpass = csvCell[3];
	    
	    driver.findElement(By.id("ap_customer_name")).sendKeys(name);
	    driver.findElement(By.id("ap_email")).sendKeys(email);
	    driver.findElement(By.id("ap_password")).sendKeys(pass);
	    driver.findElement(By.id("ap_password_check")).sendKeys(conpass);
	    
	}
	    
	    csvreader.close();
	    Thread.sleep(5000);
	   driver.close();
	}
	
	



}
