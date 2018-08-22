package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SettingsPage {
	
	WebDriver driver;
	
	By firstName = By.xpath("/html/body/div[3]/div[1]/div/div/div/form/div[1]/input");
	By lastName = By.xpath("/html/body/div[3]/div[1]/div/div/div/form/div[2]/input");
	By email = By.xpath("/html/body/div[3]/div[1]/div/div/div/form/div[3]/input");
	By language = By.xpath("/html/body/div[3]/div[1]/div/div/div/form/div[4]/select");
	By save = By.xpath("/html/body/div[3]/div[1]/div/div/div/form/button");
	By validMessage = By.xpath("/html/body/div[3]/div[1]/div/div/div/div[1]");
	By invalidMessage = By.xpath("/html/body/div[3]/div[1]/div/div/div/div[3]");
	
	public SettingsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setFirstName(String strFirstName){
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(strFirstName);
	}
	
	public void setLastName(String strLastName){
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(strLastName);
	}
	
	public void setEmail(String strEmail){
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(strEmail);
	}
	
	public void selecLanguage(String lang){
		Select languageValue = new Select(driver.findElement(language));
		languageValue.selectByVisibleText(lang);
	}
	
	public String validMessage(){
		return driver.findElement(validMessage).getText();
	}
	
	public String invalidMessage(){
		return driver.findElement(invalidMessage).getText();
	}
	
	public void saveDetailsSettings(String strFirstName, String strLastName, String strEmail, String lang){
		this.setFirstName(strFirstName);
		this.setLastName(strLastName);
		this.setEmail(strEmail);
		this.selecLanguage(lang);
		driver.findElement(save).click();
	}
}
