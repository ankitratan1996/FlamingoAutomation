package com.flamingo.pom;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.flamingo.driver.DriverClass;


public class BaseClass {
	
	protected BaseClass() {}
	
	@BeforeTest
	public void driverInitialization()
	{
		DriverClass.initDriver();
	}
	
	@AfterTest
	public void driverClosing()
	{
		DriverClass.tearDown();
	}
	
	

}
