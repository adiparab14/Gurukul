package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

	WebDriver driver;

	By loginMessage = By.xpath("//*[@class='alert alert-success ng-scope ng-binding']");
	By entities = By.xpath("//a[@class='dropdown-toggle']//span[text()=\"Entities\"]");
	By branch = By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[2]/ul/li[1]/a");
	By staff = By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[2]/ul/li[2]/a");

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public String checkLoginMessage() {
		return driver.findElement(loginMessage).getText();
	}

	public void clickBranch() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(entities));
		driver.findElement(entities).click();
		wait.until(ExpectedConditions.elementToBeClickable(branch));
		driver.findElement(branch).click();
	}

	public void clickStaff() {
		driver.findElement(entities).click();
		driver.findElement(staff).click();
	}
}
