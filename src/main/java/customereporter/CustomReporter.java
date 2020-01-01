package customereporter;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import baseTest.BaseTestClass;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class CustomReporter implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		ExtentManager.getInstance().flush();

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("***" + result.getName() + " = [Fail]***\n");
		Reporter.log(result.getName() + " = [fail]<br>");
		String className = result.getMethod().getRealClass().getSimpleName();
		ExtentManager.getTest().assignCategory(className);
		ExtentManager.getTest().pass(
				MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
		try {
			ExtentManager.getTest().addScreenCaptureFromPath(BaseTestClass.capture());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getName();
		ExtentTest extentTest = ExtentManager.getInstance().createTest(
				methodName, result.getMethod().getDescription());
		ExtentManager.setTest(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("***" + result.getName() + " = [Pass]***\n");
		Reporter.log(result.getName() + " = [Pass]<br>");
		String className = result.getMethod().getRealClass().getSimpleName();
		ExtentManager.getTest().assignCategory(className);
		ExtentManager.getTest().pass(
				MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));

	}
}
