package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import log.Log;
import pageobjects.MainPage;
import pageobjects.ResetpasswordPage;
import pageobjects.SessionsPage;
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

	@AfterClass(alwaysRun = true)
	public void teardown() {
		utils.logout();
	}

	@Test(groups = { "accountstest" }, priority = 0)
	public void validSettingsSave() {
		Log.startTestCase("Valid Settings Save");
		try {
			SettingsPage settings = new SettingsPage(driver);
			MainPage main = new MainPage(driver);
			main.clickSettings();
			settings.saveDetailsSettings("Administrator", "Administrator", "admin@localhost", "English");
			Assert.assertEquals(settings.validMessage(), "Settings saved!");
			Log.endTestCase("Valid Settings Save");
		} catch (Exception e) {
			Log.error("Error occured during test.");
			throw e;
		}
	}

	@Test(groups = { "accountstest" }, priority = 1)
	public void invalidSettingsSave() {
		Log.startTestCase("Invalid Settings Save");
		try {
			SettingsPage settings = new SettingsPage(driver);
			settings.saveDetailsSettings("Administrator1", "Administrator", "admin@localhost", "English");
			Assert.assertEquals(settings.invalidMessage(), "An error has occurred! Settings could not be saved.");
			Log.endTestCase("Invalid Settings Save");
		} catch (Exception e) {
			Log.error("Error occured during test.");
			throw e;
		}
	}

	@Test(groups = { "accountstest" }, priority = 2)
	public void invalidPasswordReset() {
		Log.startTestCase("Invalid Password Reset");
		try {
			ResetpasswordPage resetPassword = new ResetpasswordPage(driver);
			MainPage main = new MainPage(driver);
			main.clickPassword();
			resetPassword.resetPassword("administrator");
			Assert.assertEquals(resetPassword.invalidMessage(),
					"An error has occurred! The password could not be changed.");
			Log.endTestCase("Invalid Password Reset");
		} catch (Exception e) {
			Log.error("Error occured during test.");
			throw e;
		}
	}

	@Test(groups = { "accountstest" }, priority = 3)
	public void invalidateSession() {
		Log.startTestCase("Invalidate Session");
		try {
			SessionsPage session = new SessionsPage(driver);
			MainPage main = new MainPage(driver);
			main.clickSessions();
			Assert.assertEquals(session.invalidateFirstSession(), "Session invalidated!");
			Log.endTestCase("Invalidate Session");
		} catch (Exception e) {
			Log.error("Error occured during test.");
			throw e;
		}
	}
}
