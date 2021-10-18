package com.mmt.testcases;

import static org.testng.Assert.*;

import java.io.IOException;
import org.testng.annotations.Test;

import com.baseClass.BeforeAndAfterMethod;
import com.baseClass.Keywords;

import pages.LoginPage;

public class LoginFunctionalityTest extends BeforeAndAfterMethod {
	Keywords key;
	LoginPage lp;
//5ritik.vish@sungkian.com
	@Test(enabled = true)
	public void loginTestWithCorrectCredential() throws Exception {
		key = new Keywords(driver);
		lp = new LoginPage(driver);
		lp.doLogin("ishansharma1607@gmail.com", "Hello@123");
		boolean isloggedin = key.getElement(key.readlocator("isLoggedIn_locatortype"), key.readlocator("isLoggedIn_locatorvalue")).isDisplayed();
		assertTrue(isloggedin, "Login Failed With Correct Credentials");

	}

	@Test(enabled = true, dependsOnMethods = "loginTestWithCorrectCredential")
	public void testLogout() throws IOException {
		lp.doLogout();
		boolean isloggedin = key
				.getElement(key.readlocator("isLoggedOut_locatortype"), key.readlocator("isLoggedOut_locatorvalue"))
				.isDisplayed();

		assertTrue(isloggedin, "Logout Failed");

	}

	@Test(enabled = true, dependsOnMethods = "testLogout")
	public void loginTestWithIncorrectCredtentials1() throws IOException {
		key.click(key.readlocator("loginbutton1_locatortype"), key.readlocator("loginbutton1_locatorvalue"));
		lp.doLoginWithIncorrectCredentials("ishan@gmail.com", "Hkdhkkkj");
		boolean isloggedin = key.getElement(key.readlocator("error_locatortype"), key.readlocator("error_locatorvalue")).isDisplayed();
		assertTrue(isloggedin, "Logged In With Incorrect Credentials");

	}

	@Test(enabled = true, dependsOnMethods = "loginTestWithIncorrectCredtentials1")
	public void LoginTestWithIncorrectCredtentials2() throws IOException {

		key.click("xpath", "//a[@class='modalBack capText font12 latoBlack']");
		lp.doLoginWithIncorrectCredentials("aaa@gmail.com", "ffdfdsf");
		boolean isloggedin = key.getElement(key.readlocator("error_locatortype"), key.readlocator("error_locatorvalue")).isDisplayed();
		assertTrue(isloggedin, "Logged In With Incorrect Credentials");
	}

}