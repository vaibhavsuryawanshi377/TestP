package utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerSetup implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: "+result.getMethod().getMethodName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: "+result.getMethod().getMethodName());
	}
	

}
