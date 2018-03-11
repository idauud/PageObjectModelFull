package pageObjects.project.registration;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.project.testbase.TestBase;
import pageObjects.project.uiactions.HomePage;
import pageObjects.project.uiactions.RegistrationPageFailedBecauseitsTooLong;

public class TC002_verifyRegistrationFailed extends TestBase {
	
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	@BeforeTest
	public void setUp() {
		
		driver=initilize();
		driver.get(url);

	}
	
		
//		 
	
	
	@Test(enabled = true)
	public void verifyRegistrationSeccessful() throws IOException{
		
		HomePage hp= new HomePage(driver);
		hp.gotoAccountCreationPage("dada@dada.com");
		log.info("navigating to registration page from homepage");
		
		RegistrationPageFailedBecauseitsTooLong reg = new RegistrationPageFailedBecauseitsTooLong(driver);
		reg.registrationForm();
		log.info("its to long form so cant complete it to failing the test");
		ScreenShot("registrationPage");
		//Assert.assertTrue(reg.failedMessage());
		Assert.assertTrue(false);
	}
	
	
	//@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
