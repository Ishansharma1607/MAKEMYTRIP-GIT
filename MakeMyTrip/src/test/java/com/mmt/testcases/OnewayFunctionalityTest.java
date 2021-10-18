package com.mmt.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseClass.Keywords;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OnewayFunctionalityTest {
	static Keywords key;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20) ;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']")));
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]")).click();
		driver.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']")).click();
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("Mumbai");
		

		
	//	driver.quit();
	}

}
