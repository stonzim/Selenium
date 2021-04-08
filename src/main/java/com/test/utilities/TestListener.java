package com.test.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	Logger logger;
	String testName;
	String testMethodName;
	
	@Override
	public void onTestStart(ITestResult result) {
		this.testMethodName = result.getMethod().getMethodName();
		logger.info("[Starting " + testMethodName + "]");
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("[Test "+testMethodName + " passed]");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("[Test "+testMethodName + " failed]");
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("[Test "+testMethodName + " skipped]");
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		this.testName = context.getCurrentXmlTest().getName();
		logger = LogManager.getLogger(testName);
		logger.info("[Test " + testName + " started]");
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("[All " + testName + " finished]");
		ITestListener.super.onFinish(context);
	}
	
}
