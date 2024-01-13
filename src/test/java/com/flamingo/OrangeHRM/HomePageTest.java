package com.flamingo.OrangeHRM;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.flamingo.driver.DriverManager;
import com.flamingo.enums.PropertyFilekey;
import com.flamingo.framework.Elements;
import com.flamingo.framework.Waits;
import com.flamingo.pom.BaseClass;
import com.flamingo.pom.OrangeHRMHomepage;
import com.flamingo.pom.OrangeHRMLoginpage;
import com.flamingo.utility.PropertyFileClass;


public class HomePageTest extends BaseClass{

	private static final Logger log = LogManager.getLogger(HomePageTest.class);
	
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
		String pageTitle=Elements.getTitle();
		Assertions.assertThat(pageTitle).isEqualTo("OrangeHRM").isNotBlank();
		
	}
	
	@Test(dependsOnMethods="loginWithCorrectCredential",groups="functionality test")
	public void aboutProfileTesting()
	{
		OrangeHRMHomepage orangeHRMHomepage=new OrangeHRMHomepage(DriverManager.getDriver());
		Waits.waitUntilElementLocated(10,orangeHRMHomepage.underdownIcon);
		orangeHRMHomepage.clickUnderdownIcon();
		Waits.waitUntilElementLocated(10,orangeHRMHomepage.AboutProfile);
		orangeHRMHomepage.clickAboutProfile();
		List<WebElement>list=DriverManager.getDriver().findElements(By.xpath("//*[@class=\"oxd-grid-2 orangehrm-about\"]/div"));
		
		for(WebElement ele:list)
		{
			log.info(ele.getText().toString());
		}
	}
}
