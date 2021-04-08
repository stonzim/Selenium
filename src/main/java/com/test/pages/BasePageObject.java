package com.test.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	protected WebDriver driver;
	protected Logger logger;

	public BasePageObject(WebDriver driver, Logger logger) {
		this.driver = driver;
		this.logger = logger;
	}

	protected void openUrl(String url) {
		driver.get(url);
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}

	protected void click(By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).click();
	}

	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(text);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	private void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
			attempts++;
		}
	}

	public void setCookie(Cookie cookie) {
		logger.info("Setting Cookie \"" + cookie.getName() + "\"");
		this.driver.manage().addCookie(cookie);
		logger.info("Cookie \"" + cookie.getName() + "\"");
	}

	public String getCookie(String cookie) {
		logger.info("Getting value of Cookie \"" + cookie + "\"");
		return this.driver.manage().getCookieNamed(cookie).getValue();
	}

}
