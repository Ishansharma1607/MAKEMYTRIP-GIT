package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.baseClass.Keywords;


public class LoginPage {

	WebDriver driver;
	Keywords key;

	// creating constructor so that we can call LoginPage.MethodName in
	// PomRunner.java
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public void setUserName(String user) throws Exception {
		// driver.findElement(e_un).sendKeys(user);
		key = new Keywords(driver);
		key.type(key.readlocator("username_locatortype"), key.readlocator("username_locatorValue"), user);
	}

	public void setPassWord(String pwd) throws IOException {
		key.type(key.readlocator("password_locatortype"), key.readlocator("password_locatorValue"), pwd);
	}

	public void doLogin(String email, String pwd) throws Exception {
		key = new Keywords(driver);

		try {
			key.click(key.readlocator("loginbutton1_locatortype"), key.readlocator("loginbutton1_locatorvalue"));
		} catch (Exception e) {

		}
		try {
			key.click(key.readlocator("loginbutton2_locatortype"), key.readlocator("loginbutton2_locatorvalue"));

		} catch (Exception e) {

		}
		key.implicitwait(10);
		setUserName(email);

		key.typeKeys(key.readlocator("username_locatortype"), key.readlocator("username_locatorValue"), Keys.ENTER);
		key.implicitwait(10);
		setPassWord(pwd);
		key.typeKeys(key.readlocator("password_locatortype"), key.readlocator("password_locatorValue"), Keys.ENTER);
		key.click(key.readlocator("cross_locatortype"), key.readlocator("cross_locatorvalue"));
		

	}

	public void doLogout() throws IOException {

		WebElement element = key.getElement(key.readlocator("hover_locatortype"), key.readlocator("hover_locatorvalue"));
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		key.click(key.readlocator("profile_locatortype"), key.readlocator("profile_locatorvalue"));
		key.click(key.readlocator("logout_locatortype"), key.readlocator("logout_locatorvalue"));
		
	}
	
	public void doLoginWithIncorrectCredentials(String email , String pwd) throws IOException {
		
		key.getElement(key.readlocator("username_locatortype"), key.readlocator("username_locatorValue")).clear();
		key.type(key.readlocator("username_locatortype"), key.readlocator("username_locatorValue"), email);
		key.typeKeys(key.readlocator("username_locatortype"), key.readlocator("username_locatorValue"), Keys.ENTER);
		key.implicitwait(10);
		key.getElement(key.readlocator("password_locatortype"), key.readlocator("password_locatorValue")).clear();
		key.type(key.readlocator("password_locatortype"), key.readlocator("password_locatorValue"), pwd);
		key.typeKeys(key.readlocator("password_locatortype"), key.readlocator("password_locatorValue"), Keys.ENTER);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
