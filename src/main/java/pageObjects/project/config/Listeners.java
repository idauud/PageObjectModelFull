package pageObjects.project.config;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pageObjects.project.testbase.TestBase;

public class Listeners implements ITestListener {
	
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	TestBase tb = new TestBase();

	public void onTestStart(ITestResult result) {
			
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			log.info("On test Failure function is called for "+result.getName());
			log.info("Taking the screenshot of the failed testcase : "+ result.getName());
			tb.ScreenShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
