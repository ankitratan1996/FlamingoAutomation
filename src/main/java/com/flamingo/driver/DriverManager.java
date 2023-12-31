package com.flamingo.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager() {
	}

	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return threadLocal.get();
	}

	public static void setDriver(WebDriver driver) {
		threadLocal.set(driver);
	}

	public static void unload() {
		threadLocal.remove();
	}

}
