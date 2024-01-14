package com.flamingo.driver;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.flamingo.enums.PropertyFilekey;
import com.flamingo.utility.PropertyFileClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverClass {

	private static final Logger log = LogManager.getLogger();

	private DriverClass() {
	}

	private static WebDriver driver;

	public static void initDriver() {

		String browserName = PropertyFileClass.getPropertiesValue(PropertyFilekey.BROWSER.toString().toLowerCase());
		log.info("selected browser is: "+browserName);
		if (Objects.isNull(driver)) {
			if (browserName.equalsIgnoreCase("chrome")) {
				ChromeOptions chrome = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(chrome);
			} else if (browserName.equalsIgnoreCase("firefox")) {
				FirefoxOptions firefox = new FirefoxOptions();
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(firefox);
			} else if (browserName.equalsIgnoreCase("edge")) {
				EdgeOptions edge = new EdgeOptions();
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(edge);
			}
			DriverManager.setDriver(driver);
		}
	}

	public static void tearDown() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
