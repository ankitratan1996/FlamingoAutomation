package com.flamingo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.flamingo.reports.ExtentLogger;

public final class OrangeHRMLoginpage {

	private WebDriver driver;
	
	@FindBy(xpath = "//*[@name=\"username\" and @placeholder=\"Username\"]")
	public static WebElement usernameInput;

	@FindBy(xpath = "//*[@name=\"password\" and @placeholder=\"Password\"]")
	public static WebElement passwordInput;

	@FindBy(xpath = "//*[@type=\"submit\"]")
	public static WebElement loginButton;

	@FindBy(xpath = "//*[@class=\"orangehrm-login-forgot\"]/p")
	public static WebElement forgetPassword;

	public OrangeHRMLoginpage(WebDriver driver) {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	}

	public OrangeHRMLoginpage enterUsername(String username) {
		usernameInput.sendKeys(username);
		ExtentLogger.pass("username has entered"+ username);
		return this;
	}

	public OrangeHRMLoginpage enterPassword(String password) {
		passwordInput.sendKeys(password);
		ExtentLogger.pass("password has entered"+ password);
		return this;
	}

	public OrangeHRMHomepage clickLogin() {
		loginButton.click();
		ExtentLogger.pass("submit has clicked");
		return new OrangeHRMHomepage();
	}

	public void clickforgetPassword() {
		forgetPassword.click();
	}

}
