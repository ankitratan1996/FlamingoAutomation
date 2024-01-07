package com.flamingo.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.testng.annotations.Test;

import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class RadioButtonTesting extends BaseClass{
	
	@Test
	public void radioButtonTesting() throws InterruptedException
	{
		DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");
		List<WebElement>listElement=DriverManager.getDriver().findElements(By.xpath("//*[@name=\"gender\"]"));
		for(WebElement ele:listElement)
		{
			
			if(ele.getAttribute("value").equalsIgnoreCase("Female"))
			{
				ele.click();
			}
			
		}
		Thread.sleep(1000);
	}

}
