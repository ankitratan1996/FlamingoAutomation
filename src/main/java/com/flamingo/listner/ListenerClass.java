
package com.flamingo.listner;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.flamingo.reports.ExtendReportManager;
import com.flamingo.reports.ExtentLogger;



public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtendReportManager.reportSettingforTest();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ISuite suite) {

		try {
			ExtendReportManager.endReportSetting();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {

		ExtendReportManager.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		try {
			ExtentLogger.pass(result.getMethod().getMethodName() + "is passed", true);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + "is failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		try {
			ExtentLogger.skip(result.getMethod().getMethodName() + "is skipped", true);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}

}
