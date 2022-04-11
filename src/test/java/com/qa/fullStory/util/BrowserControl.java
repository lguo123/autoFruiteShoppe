package com.qa.fullStory.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserControl {
	
	public static WebDriver getDriver() {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver_99");
//		LoggingPreferences logs = new LoggingPreferences();
//		logs.enable(LogType.PERFORMANCE, java.util.logging.Level.ALL);
//		logs.enable(LogType.BROWSER, java.util.logging.Level.ALL);
//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//		caps.setCapability(CapabilityType.LOGGING_PREFS, logs);

		WebDriver driver = new ChromeDriver();

		return driver;
	}

}
