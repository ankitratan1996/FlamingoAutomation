package com.flamingo.constant;

import com.flamingo.enums.PropertyFilekey;
import com.flamingo.utility.PropertyFileClass;

public final class FrameworkPathConstant {
	
	private FrameworkPathConstant() {}
	
	public static final String propertyFilepath =System.getProperty("user.dir")+
			"/src/main/resources/configuration.properties";
	
	private static final String extentReportPath = System.getProperty("user.dir") 
			+ "/extent-report";

	private static String extentReportFilePath = "";
	
	public static String getExtentReportFilePath() throws Exception {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() throws Exception {
		if (PropertyFileClass.getPropertiesValue(PropertyFilekey.OVERRIDEREPORTS.toString())
				.equalsIgnoreCase("yes")) {
			return extentReportPath + "/" + System.currentTimeMillis() + "index.html";
		}

		return extentReportPath + "/" + "index.html";
	}
	
	
	

}
