package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	By login = By.linkText("login");
	By register = By.linkText("Register a new account");
	By home = By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[1]/a[2]/span[2]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLogin() {
		driver.findElement(login).click();
	}

	public void clickRegister() {
		driver.findElement(register).click();
	}

	public void clickHome() {
		driver.findElement(home).click();
	}
}
