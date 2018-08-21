package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import pageobjects.BranchesPage;
import pageobjects.MainPage;
import utils.Utils;

public class BranchTests {

	public WebDriver driver;
	Logger logger = Logger.getLogger(LoginTests.class);
	Utils utils = new Utils(driver);

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = utils.startBrowser();
		logger.info("Hello");
		utils.login("admin", "admin");
	}

	@Test(groups = { "branchtest" }, priority = 0)
	public void createValidBranch() {
		BranchesPage branch = new BranchesPage(driver);
		MainPage main = new MainPage(driver);
		main.clickBranch();
		branch.createBranch("Infrastructure", "123");
		Assert.assertEquals(true, branch.checkBranchName("Infrastructure"));
	}

	@Test(groups = { "branchtest" }, priority = 1)
	public void editBranch() {
		BranchesPage branch = new BranchesPage(driver);
		branch.searchBranchName("Infrastructure");
		branch.editBranch("InfraEdited", "1234");
		Assert.assertEquals(true, branch.checkBranchName("InfraEdited"));
	}
	
	@Test(groups = { "branchtest" }, priority = 2)
	public void deleteBranch() {
		BranchesPage branch = new BranchesPage(driver);
		branch.searchBranchName("InfraEdited");
		branch.deleteBranch();
		branch.clickSearch();
		Assert.assertEquals(1, branch.numberOfElements());
	}
	

}
