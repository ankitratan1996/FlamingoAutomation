package com.flamingo.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

	 static ExtentTest getExtentTest() {
		return threadLocal.get();
	}

	 static void setExtentTest(ExtentTest test) {
		threadLocal.set(test);
	}

	 static void removeExtentTest() {
		threadLocal.remove();
	}

}
