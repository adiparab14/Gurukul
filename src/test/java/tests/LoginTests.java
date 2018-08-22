package tests;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import log.Log;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.RegisterPage;
import utils.Utils;

public class LoginTests {

	public WebDriver driver;
	Utils utils = new Utils(driver);

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = utils.startBrowser();
	}
	
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.quit();
	}

	@Test(groups = {"logintest"})
	  public void validLogin() throws ElementNotVisibleException {
		Log.startTestCase("Valid Login");
	    try {
	      utils.login("admin", "admin");
	      MainPage main = new MainPage(driver);
	      Assert.assertEquals(main.checkLoginMessage(), "You are logged in as user \"admin\".");
	      Log.endTestCase("Valid Login");
	    } catch (Exception e) {
	      Log.error("Error occured during test.");
	      throw (e);
	    }
	  }
	
	
	@Test(groups = {"logintest"})
	public void invalidLogin() throws WebDriverException {
		Log.startTestCase("Invalid Login");
		try {
			LoginPage login = new LoginPage(driver);
			 utils.login("admin", "adm");
			Assert.assertEquals(login.checkLoginMessage(), "Authentication failed! Please check your credentials and try again.");
			Log.endTestCase("Invalid Login");
		} catch (Exception e) {
			Log.error("Error occured during test.");
			throw (e);
		}
	}
	
	@Test(groups = {"logintest"})
	public void invalidRegisterUser() throws WebDriverException{
		Log.startTestCase("Invalid Registration");
		try {
			HomePage home = new HomePage(driver);
			RegisterPage register = new RegisterPage(driver);
			home.clickRegister();
			register.registerUser("abc", "abc@def", "abcdef");
			Assert.assertEquals(register.checkInvalidRegisterMessage(), "Registration failed! Please try again later.");
			Log.endTestCase("Invalid Registration");
		} catch (Exception e) {
			Log.error("Error occured during test.");
			throw (e);
		}
	}

}
