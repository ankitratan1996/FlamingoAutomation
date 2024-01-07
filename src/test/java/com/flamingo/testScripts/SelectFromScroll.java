package com.flamingo.testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class SelectFromScroll extends BaseClass{
	
	@Test
	public void selectFromScroll() throws InterruptedException
	{
		DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");
		WebElement ele=DriverManager.getDriver().findElement(By.xpath("//*[@id=\"colors\"]"));
		Select select =new Select(ele);
		List<WebElement>list=select.getOptions();
		System.out.println(list);
		select.selectByVisibleText("Green");
		Thread.sleep(1000);
		
	}

}
