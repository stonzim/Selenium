package com.test.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPageObject extends BasePageObject{
	private By logOutButton = By.xpath("//*[@id=\"content\"]/div/a/i");

	public SecureAreaPageObject(WebDriver driver, Logger logger) {
		super(driver, logger);
	}
	
	public boolean isLogOutButtonVisible() {
		return find(logOutButton).isDisplayed();
	}
	
}
