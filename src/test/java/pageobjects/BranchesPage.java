package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BranchesPage {

	WebDriver driver;

	By createNew = By.xpath("/html/body/div[3]/div[1]/div/div[1]/div/div[1]/button");
	By search = By.xpath("/html/body/div[3]/div[1]/div/div[1]/div/div[2]/form/button");
	By searchQuery = By.xpath(".//div[@class='form-group']//input[@id='searchQuery']");
	By name = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/form/div[2]/div[2]/input");
	By code = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/form/div[2]/div[3]/input");
	By cancel = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/form/div[3]/button[1]");
	By save = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/form/div[3]/button[2]");
	By branchname;
	By edit = By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[4]/button[2]");
	By view = By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[4]/button[1]");
	By delete = By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[4]/button[3]");
	By confirmDelete = By.xpath("/html/body/div[3]/div[1]/div/div[3]/div/div/form/div[3]/button[2]");
	By tableXpath = By.xpath("/html/body/div[3]/div[1]/div/div[4]/table");

	public BranchesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setName(String strName) {
		driver.findElement(name).sendKeys(strName);
	}

	public void setCode(String strCode) {
		driver.findElement(code).sendKeys(strCode);
	}

	public void clickCreateBranch() {
		driver.findElement(createNew).click();
	}

	public void clickSave() {
		driver.findElement(save).click();
	}

	public void clickDelete() {
		driver.findElement(delete).click();
	}

	public void clickConfirmDelete() {
		driver.findElement(confirmDelete).click();
	}

	public void clickView() {
		driver.findElement(view).click();
	}
	
	public void clickSearch(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(search));
		driver.findElement(search).click();
	}

	public void createBranch(String strName, String strCode) {
		this.clickCreateBranch();
		this.setName(strName);
		this.setCode(strCode);
		this.clickSave();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(cancel));
	}
	
	public int numberOfElements(){
		WebElement table = driver.findElement(tableXpath);
		List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		return listOfRows.size();
	}

	/*
	 * public void editBranch(String strName, String strCode) {
	 * this.clickCreateBranch(); this.setName(strName); this.setCode(strCode);
	 * this.clickSave(); }
	 */

	public boolean checkBranchName(String branchName) {
		return driver.findElement(By.xpath("//td[text()='" + branchName + "']")).isDisplayed();
	}

	public String getBranchName(String branchName) {
		return driver.findElement(By.xpath("//td[text()='" + branchName + "']")).getText();
	}

	public void searchBranchName(String branchName) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(searchQuery));
		driver.findElement(searchQuery).clear();
		driver.findElement(searchQuery).sendKeys(this.getBranchName(branchName));
		driver.findElement(search).click();
	}

	public void editBranch(String branchName, String branchCode) {
		driver.findElement(edit).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(code));
		if (!branchCode.equals("")) {
			driver.findElement(code).clear();
			driver.findElement(code).sendKeys(branchCode);
		}
		if (!branchName.equals("")) {
			driver.findElement(name).clear();
			driver.findElement(name).sendKeys(branchName);
		}
		driver.findElement(save).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(cancel));
	}

	public void deleteBranch() {
		this.clickDelete();
		this.clickConfirmDelete();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(cancel));
	}

}
