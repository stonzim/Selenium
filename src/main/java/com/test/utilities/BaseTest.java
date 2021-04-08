package com.test.utilities;

import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(com.test.utilities.TestListener.class)
public class BaseTest {
	protected WebDriver driver;
	protected Logger logger;
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
	BrowserDriverFactory factory;

	@BeforeMethod
	@Parameters({ "browser", "url" })
	public void setUp(Method method, String browser, String url, ITestContext context) {
		String testName = context.getCurrentXmlTest().getName();
		this.logger = LogManager.getLogger(testName);
		this.factory = new BrowserDriverFactory(browser, logger);
		this.testSuiteName = context.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
		this.driver = factory.createDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@AfterMethod
	public void tearDown() {
		logger.info("[QUITTING DRIVER]");
		driver.quit();
	}
}
