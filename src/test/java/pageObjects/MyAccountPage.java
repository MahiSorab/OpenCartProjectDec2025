package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	// constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// locator
	@FindBy(xpath = "//h1[normalize-space()='My Account']") // MyAccount Page Heading
	WebElement msgHeading;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") // logout link
	WebElement lnkLogOut;

	// action method
	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {
//		lnkLogOut.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lnkLogOut);
	}

}
