package com.test.utilities;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {
	private ThreadLocal<WebDriver> driver;
	private String browser;
	private Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {
		log.info("Create driver: " + browser);
		driver = new ThreadLocal<WebDriver>();
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"/Users/winston/Desktop/AutoWorkspace/MavenAutomation/src/main/resources/chromedriver");
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"/Users/winston/Desktop/AutoWorkspace/MavenAutomation/src/main/resources/geckodriver");
			driver.set(new FirefoxDriver());
			break;
		default:
			break;
		}
		return driver.get();
	}
}
