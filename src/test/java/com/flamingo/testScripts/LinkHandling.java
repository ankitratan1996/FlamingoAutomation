package com.flamingo.testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class LinkHandling extends BaseClass{

	@Test
	public void linkHandletesting() throws InterruptedException
	{
		DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");
		DriverManager.getDriver().findElement(By.xpath("//*[@id=\"Blog1\"]/div[4]/div/a")).click();
		Set<String>windowhandles=DriverManager.getDriver().getWindowHandles();
		System.out.println(windowhandles);
		for(String window:windowhandles)
		{
			String str=DriverManager.getDriver().switchTo().window(window).getTitle();
			if(str.equalsIgnoreCase("Automation Testing Practice"))
			DriverManager.getDriver().switchTo().window(window).close();

		}
		Thread.sleep(1000);
	}
	
}
