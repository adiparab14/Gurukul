package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	WebDriver driver;
	
	By username = By.xpath(".//div[@class='form-group']//input[@name='login']");
	By email = By.xpath(".//div[@class='form-group']//input[@name='email']");
	By password = By.xpath(".//div[@class='form-group']//input[@name='password']");
	By confirmPassword= By.xpath(".//div[@class='form-group']//input[@name='confirmPassword']");
	By registerButton = By.xpath(".//*[@class='btn btn-primary ng-scope']");
	By invalidRegisterMessage = By.xpath("//*[@class='alert alert-danger ng-scope']");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUsername(String strUsername){
		driver.findElement(username).sendKeys(strUsername);
	}
	
	public void setEmail(String strEmail){
		driver.findElement(email).sendKeys(strEmail);
	}
	
	public void setPassword(String strPassword){
		driver.findElement(password).sendKeys(strPassword);
	}
	public void setConfirmPassword(String strPassword){
		driver.findElement(confirmPassword).sendKeys(strPassword);
	}
	public void clickRegister(){
		driver.findElement(registerButton).click();
	}
	public void registerUser(String strUsername,String strEmail,String strPassword){
		this.setUsername(strUsername);
		this.setEmail(strEmail);
		this.setPassword(strPassword);
		this.setConfirmPassword(strPassword);
		this.clickRegister();
	}
	
	public String checkInvalidRegisterMessage(){
		return driver.findElement(invalidRegisterMessage).getText();
	}
	
}
