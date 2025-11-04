package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	// constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement btnPrivacypolicy;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

//	Action methods

	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void agreePrivacyPolicy() {
//		btnPrivacypolicy.click();

		// sol2
//		btnPrivacypolicy.submit();

		// sol3
//		Actions act = new Actions(driver);
//		act.moveToElement(btnPrivacypolicy).click().perform();

		// sol4
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnPrivacypolicy);

		// sol5
//		btnContinue.sendKeys(Keys.RETURN);

		// sol6
//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(btnPrivacypolicy)).click();
	}

	public void clickContinueBtn() {
//		btnContinue.click();
		
//		Actions act = new Actions(driver);
//		act.moveToElement(btnContinue).click().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnContinue);
	}

	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
