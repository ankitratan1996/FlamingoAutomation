package com.flamingo.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.flamingo.driver.DriverManager;

public class LoginpageSwaglabs {


	By userNameText = By.id("user-name");
	By passwordText = By.id("password");
	By loginButton = By.id("login-button");

	public void enterUserName(String userName)

	{
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(userNameText));
		DriverManager.getDriver().findElement(userNameText).clear();
		DriverManager.getDriver().findElement(userNameText).sendKeys(userName);
	}

	public void enterPassword(String password) {
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(userNameText));
		DriverManager.getDriver().findElement(passwordText).clear();
		DriverManager.getDriver().findElement(passwordText).sendKeys(password);
	}

	public void clickLogin() {
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(passwordText));
		DriverManager.getDriver().findElement(loginButton).click();
	}
}
