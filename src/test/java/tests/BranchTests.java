package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import log.Log;
import pageobjects.BranchesPage;
import pageobjects.MainPage;
import utils.Utils;

public class BranchTests {

	public WebDriver driver;
	Utils utils = new Utils(driver);

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = utils.startBrowser();
		utils.login("admin", "admin");
	}

	@Test(groups = { "branchtest" }, priority = 0)
	public void createValidBranch() throws WebDriverException {
		Log.startTestCase("Create Branch");
		try {
			BranchesPage branch = new BranchesPage(driver);
			MainPage main = new MainPage(driver);
			main.clickBranch();
			branch.createBranch("Infrastructure", "123");
			Assert.assertEquals(true, branch.checkBranchName("Infrastructure"));
			Log.endTestCase("Create Branch");
		} catch (Exception e) {
			Log.error("Error occured during Branch Creation.");
		}
	}

	@Test(groups = { "branchtest" }, priority = 1)
	public void editBranch() {
		Log.startTestCase("Edit Branch");
		try {
			BranchesPage branch = new BranchesPage(driver);
			branch.searchBranchName("Infrastructure");
			branch.editBranch("InfraEdited", "1234");
			Assert.assertEquals(true, branch.checkBranchName("InfraEdited"));
			Log.endTestCase("Edit Branch");
		} catch (Exception e) {
			Log.error("Error occured during Branch Edit.");
		}
	}

	@Test(groups = { "branchtest" }, priority = 2)
	public void deleteBranch() {
		Log.startTestCase("Delete Branch");
		try {
			BranchesPage branch = new BranchesPage(driver);
			branch.searchBranchName("InfraEdited");
			branch.deleteBranch();
			branch.clickSearch();
			Assert.assertEquals(1, branch.numberOfElements());
			Log.endTestCase("Delete Branch");
		} catch (Exception e) {
			Log.error("Error occured during Branch Delete.");
		}
	}

}
