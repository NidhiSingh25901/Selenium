package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener interface which implements TestNG Listeners
public class Listeners implements ITestListener{
	@Override
    public void onTestStart(ITestResult result) {
        // Not implemented yet
		
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Not implemented yet
    	System.out.println("Passed Test Case");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Not implemented yet
    	System.out.println("Failed Test Case: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Not implemented yet
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented yet
    }

    @Override
    public void onStart(ITestContext context) {
        // Not implemented yet
    	System.out.println();
		System.out.println("\t Starting Test Case: " + context.getName()+" \t");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Not implemented yet    	
		System.out.println("\t Finished Test Case. \t");
		System.out.println();
    }
}
