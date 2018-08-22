package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.MainPage;
import pageobjects.SettingsPage;
import utils.Utils;

public class AccountTests {

	public WebDriver driver;
	Utils utils = new Utils(driver);

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = utils.startBrowser();
		utils.login("admin", "admin");
	}
	
	@Test(groups = {"accountstest"}, priority = 0)
	public void validSettingsSave(){
		SettingsPage settings = new SettingsPage(driver);
		MainPage main = new MainPage(driver);
		main.clickSettings();
		settings.saveDetailsSettings("Administrator", "Administrator", "admin@localhost", "English");
		Assert.assertEquals(settings.validMessage(), "Settings saved!");
	}
	
	@Test(groups = {"accountstest"}, priority = 1)
	public void invalidSettingsSave(){
		SettingsPage settings = new SettingsPage(driver);
		//MainPage main = new MainPage(driver);
		//main.clickSettings();
		settings.saveDetailsSettings("Administrator1", "Administrator", "admin@localhost", "English");
		Assert.assertEquals(settings.invalidMessage(), "An error has occurred! Settings could not be saved.");
	}
}
