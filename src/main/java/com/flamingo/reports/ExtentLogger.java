package com.flamingo.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.flamingo.enums.PropertyFilekey;
import com.flamingo.utility.PropertyFileClass;


public class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenShotNeeded) throws Exception {
		if (PropertyFileClass.getPropertiesValue(PropertyFilekey.PASSEDSTEPSCREENSHOTS.toString())
				.equalsIgnoreCase("yes") && isScreenShotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ExtendReportManager.getScreenByte64()).build());

		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenShotNeeded) throws Exception {
		if (PropertyFileClass.getPropertiesValue(PropertyFilekey.FAILEDSTEPSCREENSHOTS.toString())
				.equalsIgnoreCase("yes") && isScreenShotNeeded) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ExtendReportManager.getScreenByte64()).build());

		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenShotNeeded) throws Exception {
		if (PropertyFileClass.getPropertiesValue(PropertyFilekey.SKIPPEDSTEPSCREENSHOTS.toString())
				.equalsIgnoreCase("yes") && isScreenShotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ExtendReportManager.getScreenByte64()).build());

		} else {
			skip(message);
		}
	}


}
