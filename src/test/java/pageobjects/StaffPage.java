package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaffPage {

  WebDriver driver;

  By createNew = By.xpath("/html/body/div[3]/div[1]/div/div[1]/div/div[1]/button");
  By search = By.xpath("/html/body/div[3]/div[1]/div/div[1]/div/div[2]/form/button");
  By searchQuery = By.xpath(".//div[@class='form-group']//input[@id='searchQuery']");
  By name = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/form/div[2]/div[2]/input");
  By branch = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/form/div[2]/div[3]/select");
  By cancel = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/form/div[3]/button[1]");
  By save = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/form/div[3]/button[2]");
  By branchname;
  By edit = By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[4]/button[2]");
  By view = By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[4]/button[1]");
  By delete = By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[4]/button[3]");
  By confirmDelete = By.xpath("/html/body/div[3]/div[1]/div/div[3]/div/div/form/div[3]/button[2]");
  By tableXpath = By.xpath("/html/body/div[3]/div[1]/div/div[4]/table");

  public StaffPage(WebDriver driver) {
    this.driver = driver;
  }

  public void clickCreateStaff() {
    driver.findElement(createNew).click();
  }

  public void clickDelete() {
    driver.findElement(delete).click();
  }

  public void clickConfirmDelete() {
    driver.findElement(confirmDelete).click();
  }

  public void clickSave() {
    driver.findElement(save).click();
  }

  public void clickSearch() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(search));
    driver.findElement(search).click();
  }

  public void setName(String strName) {
    driver.findElement(name).clear();
    driver.findElement(name).sendKeys(strName);
  }

  public void selectBranch(String strBranchName) {
    Select branchValue = new Select(driver.findElement(branch));
    branchValue.selectByVisibleText(strBranchName);
  }

  public int numberOfElements() {
    WebElement table = driver.findElement(tableXpath);
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
    return listOfRows.size();
  }

  public boolean checkStaffName(String staffName) {
    return driver.findElement(By.xpath("//td[text()='" + staffName + "']")).isDisplayed();
  }

  public String getStaffName(String staffName) {
    return driver.findElement(By.xpath("//td[text()='" + staffName + "']")).getText();
  }

  public void searchStaffName(String staffName) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(searchQuery));
    driver.findElement(searchQuery).clear();
    driver.findElement(searchQuery).sendKeys(this.getStaffName(staffName));
    this.clickSearch();
  }

  public void editStaff(String staffName, String staffBranch) {
    driver.findElement(edit).click();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(name));
    if (!staffName.equals("")) {
      this.setName(staffName);
    }
    if (!staffBranch.equals("")) {
      this.selectBranch(staffBranch);
    }
    driver.findElement(save).click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(cancel));
  }

  public void createStaff(String strName, String strBranchName) {
    this.clickCreateStaff();
    this.setName(strName);
    this.selectBranch(strBranchName);
    this.clickSave();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(cancel));
  }

  public void deleteStaff() {
    this.clickDelete();
    this.clickConfirmDelete();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(cancel));
  }

}
