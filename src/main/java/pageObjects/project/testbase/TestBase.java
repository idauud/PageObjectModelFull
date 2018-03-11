package pageObjects.project.testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class TestBase {

	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	public static WebDriver driver;
	public String url ="http://automationpractice.com/";
	String browser = "chrome";
	WebDriverWait wait;
	
	public WebDriver initilize() {
		log.info("******************************************************************8");
		selectBrowser();
		getUrl();
		String log4jConfPath= "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		return driver;
		
	
		
	}
	
	public void selectBrowser() {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		log.info("creating the object of "+ browser);
		driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			log.info("creating the object of "+ browser);
			driver = new FirefoxDriver();
			}
		}
	
	
	public void getUrl() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get(url);
		//log.info("navigating to url ");
	}
	
	public void waitForElement(int Seconds,WebElement element ) {
		
		wait = new WebDriverWait(driver, Seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void ScreenShot(String testName) throws IOException {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String location = new File(System.getProperty("user.dir")).getAbsolutePath()+"/screenShots/";
		
		File destFile = new File((String)location+testName+formater.format(calendar.getTime())+".png");
		
		FileUtils.copyFile(src, destFile);
		
		Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src'"+destFile.getAbsolutePath()+"'height ='156' width='342'/></a>");
	}

}
