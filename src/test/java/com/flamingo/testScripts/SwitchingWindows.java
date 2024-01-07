package com.flamingo.testScripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class SwitchingWindows extends BaseClass {

	@Test
	public void switchingBetweenWindows() throws InterruptedException {
		DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.getDriver().findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/button")).click();
		Set<String> windowhandles = DriverManager.getDriver().getWindowHandles();
		System.out.println(DriverManager.getDriver().getTitle());
		for (String str : windowhandles) {
			String pageTitle=DriverManager.getDriver().switchTo().window(str).getTitle();
			if(pageTitle.equals("Your Store"))
			{
				DriverManager.getDriver().close();
				Thread.sleep(1000);
			}
		}

	}

}
