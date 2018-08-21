package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By username = By.id("username");
	By password = By.id("password");
	By authenticate = By.xpath("//*[@class='btn btn-primary ng-scope']");
	By automaticLogin = By.id("rememberMe");
	By forgetPassword = By.partialLinkText("password");
	By register = By.partialLinkText("Register");
	By invalidLoginMessage = By.xpath("//*[@class='alert alert-danger ng-scope']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRegister() {
		driver.findElement(register).click();
	}
	

	public void clickForgetPassword() {
		driver.findElement(forgetPassword).click();
	}

	public void setAutomaticLogin() {
		if (!driver.findElement(automaticLogin).isSelected()) {
			driver.findElement(automaticLogin).click();
		}
	}

	public void setUserName(String strUsername) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(strUsername);
	}

	public void setPassword(String strPassword) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickAuthenticate() {
		driver.findElement(authenticate).click();
	}

	public void login(String strUsername, String strPassword) {
		this.setUserName(strUsername);
		this.setPassword(strPassword);
		this.clickAuthenticate();
	}
	
	public String checkLoginMessage(){
		return driver.findElement(invalidLoginMessage).getText();
	}
}
