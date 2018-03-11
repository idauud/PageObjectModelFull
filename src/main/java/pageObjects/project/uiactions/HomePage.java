package pageObjects.project.uiactions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.project.testbase.TestBase;

public class HomePage extends TestBase {
	
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	@FindBy(css=".login")
	WebElement signin;
	
	
	@FindBy(css="#email")
	WebElement emailAddress;
	
	@FindBy(css="#passwd")
	WebElement password;
	
	@FindBy(css="#SubmitLogin")
	WebElement submitButton;
	
	@FindBy (css="ol li")
	WebElement authenticationError;
	
	@FindBy(css="#email_create")
	WebElement registration_email;
	
	@FindBy(css=".button-medium.exclusive")
	WebElement create_an_account;
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}
	
	public void gotoAccountCreationPage(String email) {
		
		log.info("navigating to registration page here we i proving email address");
		signin.click();
		registration_email.sendKeys(email);
		create_an_account.click();
	}
		
		
	public void loginApplication(String email , String passwd) {
		
		log.info("calling the login function");
		
		signin.click();
		emailAddress.sendKeys(email);
		password.sendKeys(passwd);
		submitButton.click();
		
	}
	
	public String invalidLoginText() {
		
		String errorText = authenticationError.getText();
		return errorText;
	}
}
