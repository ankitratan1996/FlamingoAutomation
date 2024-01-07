package com.flamingo.testScripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class CalenderClass extends BaseClass {

	By yearpicker=By.xpath("//*[@class=\"ui-datepicker-year\"]");

	@Test
	public void datePickerDefaultFunctionality() throws InterruptedException
	{
		DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		DriverManager.getDriver().findElement(By.xpath("//span[@Class=\"icon_calendar\"]")).click();
		
		WebElement year=DriverManager.getDriver().findElement(yearpicker);
		Select select =new Select(year);
		select.selectByVisibleText("1990");
		
	}

}
