package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SessionsPage {

  WebDriver driver;

  public SessionsPage(WebDriver driver) {
    this.driver = driver;
  }

  By firstSessionInvalidate = By.xpath("/html/body/div[3]/div[1]/div/div[3]/table/tbody/tr[1]/td[4]/button");
  By invalidateMessage = By.xpath("/html/body/div[3]/div[1]/div/div[1]");

  public String invalidateFirstSession() {
    driver.findElement(firstSessionInvalidate).click();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(invalidateMessage));
    return driver.findElement(invalidateMessage).getText();
  }
}
