package com.flamingo.testScripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class CheckboxSelection extends BaseClass{
	
	@Test
	public void checkBoxSelection()
	{
		DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");
		List<WebElement>list=DriverManager.getDriver().findElements(By.xpath("//*[@class=\"form-check-input\" and @type=\"checkbox\"]"));
		for(WebElement web:list)
		{
			if(web.getAttribute("value").equalsIgnoreCase("sunday"))
			{
				web.click();
			}
			if(web.getAttribute("value").equalsIgnoreCase("monday"))
			{
				web.click();
			}
			if(web.getAttribute("value").equalsIgnoreCase("tuesday"))
			{
				web.click();
			}
			
		}
	}

}
