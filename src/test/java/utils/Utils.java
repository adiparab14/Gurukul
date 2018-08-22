package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import log.Log;
import pageobjects.BranchesPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MainPage;

public class Utils {

  WebDriver driver;

  public Utils(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriver startBrowser() {
    WebDriverManager.firefoxdriver().setup();
    //System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://127.0.0.1:8080/");
    Log.info("Browser Initiated.");
    return driver;
  }

  public void createBranch(String branchName, String branchCode) {
    BranchesPage branch = new BranchesPage(driver);
    MainPage main = new MainPage(driver);
    main.clickBranch();
    branch.createBranch(branchName, branchCode);
  }

  public void login(String user, String pass) {
    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    home.clickLogin();
    login.login(user, pass);
  }

  public void logout() {
    MainPage main = new MainPage(driver);
    main.clicklogout();
    driver.quit();
  }

}
