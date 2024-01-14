package com.flamingo.constant;
/**
 * This FrameworkPathConstant provides path form configuration
 * @author ankit
 */
import com.flamingo.enums.PropertyFilekey;
import com.flamingo.utility.PropertyFileClass;

public final class FrameworkPathConstant {
	
	private FrameworkPathConstant() {}
	
	private static final String dir=System.getProperty("user.dir");
	
	private static final String testRunnerSheetPath=dir + "/src/test/resources/Testrunner.xlsx";
	
	private static final String propertyFilepath =dir + "/src/main/resources/configuration.properties";
	
	private static final String extentReportPath = dir +"/extent-report";
	
	private static String extentReportFilePath = "";

	public static String getTestrunnersheetpath() {
		return testRunnerSheetPath;
	}

	public static String getPropertyfilepath() {
		return propertyFilepath;
	}
	
	public static String getExtentReportFilePath() throws Exception {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() throws Exception {
		if (PropertyFileClass.getPropertiesValue(PropertyFilekey.OVERRIDEREPORTS.toString())
				.equalsIgnoreCase("no")) {
			return extentReportPath + "/" + System.currentTimeMillis() + "index.html";
		}
		return extentReportPath + "/" + "index.html";
	}	

}
