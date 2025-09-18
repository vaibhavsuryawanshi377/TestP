package utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerSetup implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: "+result.getMethod().getMethodName());
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: "+result.getMethod().getMethodName());
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: "+result.getMethod().getMethodName());
		ITestListener.super.onTestFailure(result);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: "+result.getMethod().getMethodName());
		ITestListener.super.onTestFailure(result);
	}
	

}
