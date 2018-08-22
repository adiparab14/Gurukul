package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import log.Log;
import pageobjects.MainPage;
import pageobjects.StaffPage;
import utils.Utils;

public class StaffTests {

	public WebDriver driver;
	Utils utils = new Utils(driver);

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = utils.startBrowser();
		utils.login("admin", "admin");
		utils.createBranch("StaffBranch", "1234");
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		utils.logout();
	}

	@Test(groups = { "stafftest" }, priority = 7)
	public void createValidStaff() {
		Log.startTestCase("Create Staff");
		try {
			MainPage main = new MainPage(driver);
			StaffPage staff = new StaffPage(driver);
			main.clickStaff();
			staff.createStaff("Staff", "StaffBranch");
			Assert.assertEquals(true, staff.checkStaffName("Staff"));
			Log.endTestCase("Create Staff");
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(groups = { "stafftest" }, priority = 8)
	public void editValidStaff() {
		Log.startTestCase("Edit Staff");
		try {
			MainPage main = new MainPage(driver);
			StaffPage staff = new StaffPage(driver);
			main.clickStaff();
			staff.searchStaffName("Staff");
			staff.editStaff("StaffEdited", "StaffBranch");
			Assert.assertEquals(true, staff.checkStaffName("StaffEdited"));
			Log.endTestCase("Edit Staff");
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(groups = { "stafftest" }, priority = 9)
	public void deleteValidStaff() {
		Log.startTestCase("Delete Staff");
		try {
			StaffPage staff = new StaffPage(driver);
			staff.searchStaffName("StaffEdited");
			staff.deleteStaff();
			staff.clickSearch();
			Assert.assertEquals(1, staff.numberOfElements());
			Log.endTestCase("Delete Staff");
		} catch (Exception e) {
			throw e;
		}

	}

}
