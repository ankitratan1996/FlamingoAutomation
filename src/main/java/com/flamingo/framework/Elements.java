package com.flamingo.framework;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.flamingo.driver.DriverManager;


public final class Elements {

	private Elements() {
	}

	private static final Logger log = LogManager.getLogger(Elements.class);

	public static void TypeText(WebElement element, String data) {
		log.info("entering the text: "+ data);
		element.sendKeys(data);
	}

	public static void TypeTextIfElementPresent(WebElement element, String data) {
		if (element.isDisplayed()) {
			log.info("entering the text: "+ data);
			element.sendKeys(data);
		}
	}

	public static void clearTxtBox(WebElement element) {
		element.clear();
	}

	public static void typeRandomNumber(WebElement element, int data) {
		Random random = new Random();
		int rn = random.nextInt(100);
		String randomNumber = Integer.toString(rn);
		log.info("enter random number: "+randomNumber);
		element.sendKeys(randomNumber);
	}

	public static String getTextBoxValue(WebElement element) {
		return element.getAttribute("value");
	}

	public static String getText(WebElement element) {
		return element.getText();
	}

	public static boolean VerifyTextEquals(WebElement element, String expected) {
		boolean flag = false;
		if (element.getText().equals(expected))
			return flag = true;
		return flag;
	}

	public static String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public static String getCurrentUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}

	public static boolean isSelected(WebElement element) {
		if (element.isSelected())
			return true;
		return false;
	}

	public static void selectCheckBox(WebElement element) {
		if (!isSelected(element))
			element.click();
	}

	public static void deSelectCheckbox(WebElement element) {
		if (isSelected(element))
			element.click();
	}

	public static void selectRadioButton(WebElement element) {
		if (!isSelected(element))
			element.click();
	}

	public static void deSelectRadioButton(WebElement element) {
		if (isSelected(element))
			element.click();
	}

	public static boolean isEnabled(WebElement element) {
		if (element.isEnabled())
			return true;
		return false;
	}

	public static boolean isDisplayed(WebElement element) {
		if (element.isDisplayed())
			return true;
		return false;
	}

	public static void selectByText(WebElement element, String text) {
		Select select = new Select(element);
		log.info("selecting the text: "+text);
		select.selectByVisibleText(text);
	}

	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("selecting the index: "+index);
		select.selectByIndex(index);
	}

	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		log.info("selecting the index: "+value);
		select.selectByValue(value);
	}

	public static String getFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public static List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions();
	}

	public static List<WebElement> getAllOptions(WebElement element) {
		Select select = new Select(element);
		return select.getOptions();
	}

	public static void deSelectByText(WebElement element, String text) {
		Select select = new Select(element);
		log.info("deselecting the text: "+text);
		select.deselectByVisibleText(text);
	}

	public static void deSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("deselecting the index: "+index);
		select.deselectByIndex(index);
	}

	public static void deSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		log.info("deselecting the value: "+value);
		select.deselectByValue(value);
	}

	public static void click(WebElement element) {
		Waits.waitUntil(() -> isDisplayed(element));
		element.click();
	}

	public static void clickOnlyIfElementPresent(WebElement element) {
		if (isDisplayed(element))
			element.click();
	}

	public static Alert getAlert() {
		return DriverManager.getDriver().switchTo().alert();
	}

	public static void AcceptAlert() {
		getAlert().accept();
	}

	public static void DismissAlert() {
		getAlert().dismiss();
	}

	public static String getAlertText() {
		String text = getAlert().getText();
		return text;
	}

	public static boolean isAlertPresent() {
		try {
			DriverManager.getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		AcceptAlert();
	}

	public static void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		DismissAlert();
	}

	public static void AcceptPrompt(String text) {

		if (!isAlertPresent())
			return;

		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
	}

	public static void scrollToElemet(WebElement element) {
		Waits.tryJavascript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
				element.getLocation().y);
	}
	
	public static void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
	}
	
	public static void scrollIntoView(WebElement element) {
		Waits.tryJavascript("arguments[0].scrollIntoView()", element);
	}
	
	public static void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
	}
	
	public static void scrollDownVertically() {
		Waits.tryJavascript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollUpVertically() {
		Waits.tryJavascript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public static void scrollDownByPixel() {
		Waits.tryJavascript("window.scrollBy(0,1500)");
	}

	public static void scrollUpByPixel() {
		Waits.tryJavascript("window.scrollBy(0,-1500)");
	}
	
	public static void ZoomInBypercentage() {
		Waits.tryJavascript("document.body.style.zoom='40%'");
	}

	public static void ZoomBy100percentage() {
		Waits.tryJavascript("document.body.style.zoom='100%'");
	}
	

}
