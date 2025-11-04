package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verify_Login() {
		try {
			logger.info("*********** starting TC002_LoginTest ************");

			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clicklogin();

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin();

			// MyAccountPAge
			MyAccountPage mypage = new MyAccountPage(driver);
			boolean targetpage = mypage.isMyAccountPageExists();

			Assert.assertEquals(targetpage, true, "Login failed..");
//		Assert.assertTrue(targetpage);

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*********** Finished TC002_LoginTest ************");
	}
}
