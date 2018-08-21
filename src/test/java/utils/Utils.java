package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import log.Log;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class Utils {

	WebDriver driver;

	public Utils(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver startBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1:8080/");
		Log.info("Browser initaited.");
		return driver;
	}

	public void login(String user, String pass) {
		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		home.clickLogin();
		login.login(user, pass);
	}

}
