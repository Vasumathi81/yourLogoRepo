package utilities;

import org.testng.ITestListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	BaseTest bt = new BaseTest();
	
	public void onTestStart(ITestResult result) {
	    // not implemented
	  }
	
	public void onTestSuccess(ITestResult result) {
	    // not implemented
	  }
	
	public void onTestFailure(ITestResult result) {
				
		try {
			bt.takeScreenShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  }	
	
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }
	
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
	
	public void onStart(ITestContext context) {
	    // not implemented
	  }
	
	public void onFinish(ITestContext context) {
	    // not implemented
	  }
	

}
