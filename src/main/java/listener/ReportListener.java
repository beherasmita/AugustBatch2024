package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import factory.BrowserFactory;
import helper.Utility;

public class ReportListener extends BrowserFactory implements ITestListener{
	ExtentReports extent = ExtentManager.getInstance();
	ExtentTest extentTest;
	public void onTestSuccess(ITestResult result) {
		extentTest.pass("Test executed successfully");
		//System.out.println("Test Passed"+result.getMethod().getMethodName());
	}
	public void onTestStart(ITestResult result) {
		extentTest=extent.createTest(result.getMethod().getMethodName());
		//System.out.println("Test Start"+result.getMethod().getMethodName());
	}
	public void onTestSkipped(ITestResult result) {
		extentTest.skip(result.getThrowable().getMessage());
	
	}
	public void onTestFailure(ITestResult result) {
	String screenshot = Utility.getScreenshotAsBase64(driver)	;
	extentTest.fail("Test Failed - Getting Info From Listener"+ result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String("screenshot").build());
		
	}
public void onFinish(ITestResult result) {
		
		extent.flush();
		
	}
}
