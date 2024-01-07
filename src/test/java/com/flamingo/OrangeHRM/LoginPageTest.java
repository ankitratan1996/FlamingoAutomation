package com.flamingo.OrangeHRM;

import org.testng.annotations.Test;
import com.flamingo.driver.DriverManager;
import com.flamingo.enums.PropertyFilekey;
import com.flamingo.framework.Waits;
import com.flamingo.utility.PropertyFileClass;
import com.flamingo.pom.BaseClass;
import com.flamingo.pom.OrangeHRMLoginpage;

public class LoginPageTest extends BaseClass{
	
	@Test
	public void loginWithCorrectCredential()
	{
		DriverManager.getDriver().get(PropertyFileClass.
				getPropertiesValue(PropertyFilekey.URL.toString().toLowerCase()));
		
		OrangeHRMLoginpage orangeHRMLoginpage =new OrangeHRMLoginpage(DriverManager.getDriver());
		Waits.waitUntilElementLocated(10,OrangeHRMLoginpage.usernameInput);
		orangeHRMLoginpage.enterUsername("Admin");
		Waits.waitUntilElementLocated(10,OrangeHRMLoginpage.passwordInput);
		orangeHRMLoginpage.enterPassword("admin123");
		orangeHRMLoginpage.clickLogin();
		
		
		
	}
	
	
	
	
	
	
}
