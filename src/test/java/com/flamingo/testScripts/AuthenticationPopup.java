package com.flamingo.testScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class AuthenticationPopup extends BaseClass{
	
	@Test
	public void authenticationPopup()
	{
		DriverManager.getDriver().get("https://admin:ankit12@testautomationpractice.blogspot.com/");
		
		//https://username:password@test.com
		DriverManager.getDriver().findElement(By.xpath(""));
		
	}

}
