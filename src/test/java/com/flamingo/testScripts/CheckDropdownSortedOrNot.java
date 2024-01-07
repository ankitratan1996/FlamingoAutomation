package com.flamingo.testScripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.flamingo.driver.DriverManager;
import com.flamingo.pom.BaseClass;

public class CheckDropdownSortedOrNot extends BaseClass{
	
	@Test
	public void checkDropDown()
	{
		DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");
		WebElement country=DriverManager.getDriver().findElement(By.xpath("//*[@class=\"form-control\" and @id=\"country\"]"));
		Select select =new Select(country);
		List<String> listCountry =new ArrayList();
		List<WebElement>listOriginalCountry=select.getOptions();
		
		for(WebElement element:listOriginalCountry)
		{
			listCountry.add(element.getText());
		}
		
		List<String>copyList=new ArrayList<>(listCountry);
		
		Collections.sort(copyList);
		System.out.print(copyList);
		System.out.print("------------------------------------");
		System.out.print(listCountry);
		
		System.out.print(copyList.equals(listCountry));	
		
	}

}
