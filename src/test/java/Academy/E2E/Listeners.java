package Academy.E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import resources.ExtentreporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	 ExtentTest test;
	ExtentReports extent=ExtentreporterNG.getreportobject();
	ThreadLocal<ExtentTest> extenTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test =  extent.createTest(result.getMethod().getMethodName());
		extenTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		extenTest.get().log(Status.PASS, "Test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extenTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testmethodName = result.getMethod().getMethodName();
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e) {
			
		}
		try {
			//getscreenshotpath(testmethodName,driver);
			extenTest.get().addScreenCaptureFromPath(getscreenshotpath(testmethodName,driver), result.getMethod().getMethodName());
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

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
		extent.flush();
	}

}
