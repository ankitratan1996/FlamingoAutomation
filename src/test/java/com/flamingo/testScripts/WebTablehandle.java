package com.flamingo.testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class WebTablehandle extends BaseClass{
	@Test
	public void getWebtableHandle()
	{
		DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");
		List<WebElement>allheader=DriverManager.getDriver().findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr"));
		List<WebElement>list =DriverManager.getDriver().findElements(By.xpath("//*[@name=\"BookTable\"]/tbody/tr/th"));
		System.out.println(allheader.size());
		System.out.println(list.size());
		for(int i=2;i<=allheader.size();i++)
		{
			for(int j=1;j<=list.size();j++)
			{
				String str=DriverManager.getDriver().findElement(By.xpath("//*[@name=\"BookTable\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(str+" ");
			}
			System.out.println();
		}
		
	}

}
