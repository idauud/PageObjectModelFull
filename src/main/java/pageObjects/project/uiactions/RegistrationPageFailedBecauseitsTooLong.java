package pageObjects.project.uiactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.project.testbase.TestBase;

public class RegistrationPageFailedBecauseitsTooLong extends TestBase {

	public RegistrationPageFailedBecauseitsTooLong(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_gender1")
	WebElement genderMr;

	@FindBy(name = "customer_firstname")
	WebElement firstName;

	@FindBy(id = "customer_lastname")
	WebElement lastName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(css = ".alert-danger")
	WebElement errorMessage;

	@FindBy(id = "submitAccount")
	WebElement createAccount;

	public void registrationForm() {

		genderMr.click();
		firstName.sendKeys("bilia");
		lastName.sendKeys("kutat");
		password.sendKeys("hjgkfl");
		createAccount.click();

	}

	public boolean failedMessage() {

		try {
			return errorMessage.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

}