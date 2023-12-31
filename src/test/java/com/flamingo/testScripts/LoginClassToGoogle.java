package com.flamingo.testScripts;

import org.testng.annotations.Test;

import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class LoginClassToGoogle extends BaseClass{
	
	@Test
	public void testScenario1()
	{
		DriverManager.getDriver().get("https://www.amazon.in/");
	}
	

}
