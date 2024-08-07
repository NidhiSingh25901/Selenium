package PageObjectModel.MavenSeleniumFrameworkPart3TestComponent.TestComponent;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MavenSeleniumFrameworkPart3TestComponent.resources.ExtentReporterNG;

public class Listeners implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject(); 
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getName());
	} 
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test Passed"); 
	} 
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL, "TEST FAILED");
	} 
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}
}
