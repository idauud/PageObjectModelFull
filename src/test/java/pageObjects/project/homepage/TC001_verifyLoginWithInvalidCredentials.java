package pageObjects.project.homepage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.project.exelreader.Excel_Reader;
import pageObjects.project.testbase.TestBase;
import pageObjects.project.uiactions.HomePage;

public class TC001_verifyLoginWithInvalidCredentials extends TestBase {
	
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	HomePage homepage;
	

	@BeforeTest
	public void setUp() {
		
		driver=initilize();

	}
	
	@Test(dataProvider="loginData", enabled = true)
	public void verifyLoginWithInvalidCradentials(String userEmail, String password, String runMode) {
		
		if(runMode.equalsIgnoreCase("n")) {
			
			throw new SkipException("Test Skipped");
		}
		
		
		driver.get(url);
		homepage = new HomePage(driver);
		homepage.loginApplication(userEmail, password);
		System.out.println(runMode);
		
		log.info("provinding the login cradentials as //"+userEmail+"//"+password );
		log.info("checking for varification if the login is failed");
		
		//Assert.assertEquals(homepage.invalidLoginText(), "Authentication failed.");
		Assert.assertTrue(false);

	}
	
	@DataProvider
	public Object[][] loginData() {
		
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\pageObjects\\project\\data\\testData.xlsx";
		Excel_Reader red = new Excel_Reader();
		log.info("reading user data from the data provider");
		Object[][] dat =red.getExcelData(path, "testDat");
		return dat;
		
	}

	@AfterTest
	public void endTest() throws InterruptedException {
		
		Thread.sleep(1000);
		
		driver.close();

		log.info("closing browser");

	}

}
