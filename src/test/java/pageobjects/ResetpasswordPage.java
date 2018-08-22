package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetpasswordPage {

  WebDriver driver;

  By password = By.xpath("/html/body/div[3]/div[1]/div/div/div/form/div[1]/input");
  By confirmPassword = By.xpath("/html/body/div[3]/div[1]/div/div/div/form/div[2]/input");
  By save = By.xpath("/html/body/div[3]/div[1]/div/div/div/form/button");
  By invalidMessage = By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]");

  public ResetpasswordPage(WebDriver driver) {
    this.driver = driver;
  }

  public void setPassword(String strPassword) {
    driver.findElement(password).clear();
    driver.findElement(password).sendKeys(strPassword);
  }

  public void setConfirmPassword(String strPassword) {
    driver.findElement(confirmPassword).clear();
    driver.findElement(confirmPassword).sendKeys(strPassword);
  }

  public void resetPassword(String strPassword) {
    this.setPassword(strPassword);
    this.setConfirmPassword(strPassword);
    driver.findElement(save).click();
  }

  public String invalidMessage() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(invalidMessage));
    return driver.findElement(invalidMessage).getText();
  }

}
