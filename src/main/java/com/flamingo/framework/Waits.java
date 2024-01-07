package com.flamingo.framework;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flamingo.driver.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Waits {
	
	private static final Logger log = LogManager.getLogger(Waits.class);
	
	static int timeinSec=30;
	
	
	
	public static void setImplicitWait(int time){
		DriverManager.getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	
	public static void waitUntilElementLocated(int time,WebElement element){
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitUntilElementToClick(int time,WebElement element){
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
	public static synchronized Object execJavascript(String script, Object... args) {
        JavascriptExecutor scriptExe = ((JavascriptExecutor)DriverManager.getDriver());
        return scriptExe.executeScript(script, args);
    }

    public static synchronized Object tryJavascript(String script, Object... args) {
        try {
            return execJavascript(script, args);
        } catch (Exception ignore) {
            return "";
        }
    }

    public static boolean isPageLoaded() {
        String state = (String) tryJavascript("return document.readyState;");
        return state.matches("complete|loaded|interactive");
    }

    public static boolean isJQueryDone() {
        Object jsResponse = tryJavascript("return jQuery.active;");
        if (jsResponse instanceof Long) {
            return ((Long) jsResponse) == 0;
        } else if (jsResponse instanceof String) {
            String response = (String) jsResponse;
            return (response.startsWith("{\"hCode\"") || response.isEmpty());
        } else {
            return true;
        }
    }

    public static boolean isAngularDone() {
        Object jsResponse = tryJavascript("return window.getAllAngularTestabilities().filter(x=>!x.isStable()).length;");
        if (jsResponse instanceof Long) {
            return ((Long) jsResponse) == 0;
        } else if (jsResponse instanceof String) {
            String response = (String) jsResponse;
            return response.isEmpty();
        } else {
            return true;
        }
    }
    
    public static void waitUntil(BooleanSupplier condition, int seconds) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds)).until((WebDriver driver) -> condition.getAsBoolean());
    }

    public static void waitUntil(BooleanSupplier condition) {
        waitUntil(condition, timeinSec);
    }

}
