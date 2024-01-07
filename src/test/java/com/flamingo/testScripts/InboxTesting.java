package com.flamingo.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class InboxTesting extends BaseClass {
	
	@Test
	public void inboxtesting() throws InterruptedException 
	{
		DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		DriverManager.getDriver().findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Ankit");
		DriverManager.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("fhaksjfgag@hfkjha.com");
		DriverManager.getDriver().findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("756457564");
		DriverManager.getDriver().findElement(By.xpath("//*[@id=\"textarea\"]")).sendKeys("kfewkryiuyr hfkjsdgeryu");
		Thread.sleep(1000);
		
	}
	
	

}
