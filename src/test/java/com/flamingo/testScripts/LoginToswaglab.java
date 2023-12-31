package com.flamingo.testScripts;

import org.testng.annotations.Test;
import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;
import com.flamingo.pom.LoginpageSwaglabs;

public class LoginToswaglab extends BaseClass {
	
	@Test
	public void test() throws InterruptedException 
	{
		
		LoginpageSwaglabs loginpageSwaglabs=new LoginpageSwaglabs();
		
		DriverManager.getDriver().get("https://www.saucedemo.com/");

		loginpageSwaglabs.enterUserName("visual_user");

		loginpageSwaglabs.enterPassword("secret_sauce");

		loginpageSwaglabs.clickLogin();
		Thread.sleep(3000);
	}
	

}
