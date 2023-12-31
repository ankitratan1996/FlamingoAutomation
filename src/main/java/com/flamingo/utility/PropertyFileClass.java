package com.flamingo.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.flamingo.constant.FrameworkPathConstant;

public final class PropertyFileClass {
	
	private PropertyFileClass() {}
	
	private static Properties prop;
	
	public static String getPropertiesValue(String key)
	{
		prop=new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FrameworkPathConstant.propertyFilepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	
		
	}
	
	
	
	

}
