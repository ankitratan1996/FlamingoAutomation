package com.flamingo.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.flamingo.constant.FrameworkPathConstant;

import com.flamingo.driver.DriverManager;

public final class ExtendReportManager {

	private ExtendReportManager() {
	}

	private static ExtentSparkReporter spark;
	private static ExtentReports extent;

	public static void reportSettingforTest() throws Exception {

		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			spark = new ExtentSparkReporter(FrameworkPathConstant.getExtentReportFilePath());
			spark.config().setCss("css-string");
			spark.config().setDocumentTitle("Web Testing with Selenium");
			spark.config().setTimelineEnabled(true);
			spark.config().setEncoding("utf-8");
			spark.config().setJs("js-string");
			spark.config().setProtocol(Protocol.HTTPS);
			spark.config().setReportName("build name");
			spark.config().setTheme(Theme.DARK);
			extent.attachReporter(spark);
		}
	}

	public static void createTest(String testDetails) {
		ExtentTest test = extent.createTest(testDetails);
		ExtentManager.setExtentTest(test);
	}

	public static final String getScreenByte64() {
		TakesScreenshot scrShot = ((TakesScreenshot) DriverManager.getDriver());
		return scrShot.getScreenshotAs(OutputType.BASE64);
	}

	public static void endReportSetting() throws IOException {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}

}
