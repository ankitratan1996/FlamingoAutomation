package com.flamingo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class OrangeHRMHomepage {

	private WebDriver driver;

	public OrangeHRMHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrangeHRMHomepage() {
	}

	@FindBy(xpath = "//*[@class=\"oxd-userdropdown-tab\"]/i")
	public static WebElement underdownIcon;
	
	@FindBy(linkText="About")
	public static WebElement AboutProfile;
	
	@FindBy(linkText="Support")
	public static WebElement SupportProfile;
	
	@FindBy(linkText="Change Password")
	public static WebElement ChangePassword;
	
	@FindBy(linkText="Logout")
	public static WebElement LogoutProfile;
	
	@FindBy(xpath = "//*[@placeholder=\"Search\"]")
	public static WebElement searchTxtbox;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item\"]//span[text()=\"Admin\"]")
	public static WebElement AdminMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item active\"]//span[text()=\"PIM\"]")
	public static WebElement PIMMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item active\"]//span[text()=\"Leave\"]")
	public static WebElement LeaveMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item active\"]//span[text()=\"Time\"]")
	public static WebElement TimeMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item\"]//span[text()=\"Recruitment\"]")
	public static WebElement RecruitmentMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item active\"]//span[text()=\"My Info\"]")
	public static WebElement MyInfoMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item\"]//span[text()=\"Performance\"]")
	public static WebElement PerformanceMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item\"]//span[text()=\"Dashboard\"]")
	public static WebElement DashboardMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item active\"]//span[text()=\"Directory\"]")
	public static WebElement DirectoryMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item\"]//span[text()=\"Maintenance\"]")
	public static WebElement MaintenanceMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item active\"]//span[text()=\"Claim\"]")
	public static WebElement ClaimMenu;

	@FindBy(xpath = "//*[@class=\"oxd-main-menu-item\"]//span[text()=\"Buzz\"]")
	public static WebElement BuzzMenu;
	
	public void enterSearchTxt(String text)
	{
		searchTxtbox.sendKeys(text);
	}
	
	public OrangeHRMAdminPage clickleftAdmin()
	{
		AdminMenu.click();
		return new OrangeHRMAdminPage();
	}
	
	public void clickleftPIMMenu()
	{
		PIMMenu.click();
	}
	
	public void clickleftLeaveMenu()
	{
		LeaveMenu.click();
	}
	public void clickleftTimeMenu()
	{
		TimeMenu.click();
	}
	
	public void clickleftRecruitmentMenu()
	{
		RecruitmentMenu.click();
	}
	public void clickleftMyInfoMenu()
	{
		MyInfoMenu.click();
	}
	public void clickleftPerformanceMenu()
	{
		PerformanceMenu.click();
	}
	public void clickleftDirectoryMenu()
	{
		DirectoryMenu.click();
	}
	public void clickleftDashboardMenu()
	{
		DashboardMenu.click();
	}
	
	public void clickleftMaintenanceMenu()
	{
		MaintenanceMenu.click();
	}
	
	public void clickleftClaimMenu()
	{
		ClaimMenu.click();
	}
	public void clickleftBuzzMenu()
	{
		BuzzMenu.click();
	}
	
	public void clickLogout()
	{
		LogoutProfile.click();
		
	}
	
	public OrangeHRMHomepage clickUnderdownIcon()
	{
		underdownIcon.click();
		return new OrangeHRMHomepage();
	}
	
	public void clickAboutProfile()
	{
		AboutProfile.click();
	}
	public void clickSupportProfile()
	{
		SupportProfile.click();
	}
	public void clickChangePassword()
	{
		ChangePassword.click();
	}

}
