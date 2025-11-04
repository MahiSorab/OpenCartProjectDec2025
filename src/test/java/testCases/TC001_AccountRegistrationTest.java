package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_account_registration() {
		try {
			logger.info("*********Started TC001_AccountRegistrationTest execution************");

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount link");
			hp.clickRegister();
			logger.info("clicked on Register link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing customer details ");
			regpage.setFirstname(randomeString().toUpperCase());
			regpage.setLastname(randomeString().toUpperCase());
//		regpage.setEmail("vini123@gmail.com"); // passing static data

			regpage.setEmail(randomeString().toLowerCase() + "@gmail.com"); // passing dynamic data.

//		String password = randomeAlphaNumeric() --> store it in a string and use it if confirm password field is there..
			regpage.setPassword(randomeAlphaNumeric());

			regpage.agreePrivacyPolicy();
//			Thread.sleep(5000);
			logger.info("Accept the privacy policy");
			regpage.clickContinueBtn();
			logger.info("clicked on continue button");
			logger.info("validating expected message");
			String confmsg = regpage.getConfirmationMsg();

			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}

//			Assert.assertEquals(confmsg, "Your Account Has Been Created!!!!");

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("******Finished TC001_AccountRegistrationTest execution********");
	}

}
