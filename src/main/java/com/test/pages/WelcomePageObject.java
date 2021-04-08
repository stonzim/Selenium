package com.test.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {
	private String url = "http://the-internet.herokuapp.com/";
	private By logInLinkLocator = By.xpath("//*[@id=\"content\"]/ul/li[21]/a");
	private By checkBoxLinkLocator = By.xpath("//*[@id=\"content\"]/ul/li[6]/a");
	private By dropdownLinkLocator = By.xpath("//*[@id=\"content\"]/ul/li[11]/a");
	private By jsAlertsLinkLocator = By.xpath("//*[@id=\"content\"]/ul/li[29]/a");
	
	public WelcomePageObject(WebDriver driver, Logger logger) {
		super(driver, logger);
	}

	public String getUrl() {
		return url;
	}
	
	public void openPage() {
		openUrl(url);
		logger.info("[PAGE OPENED: " + url + "]");
	}

	public LoginPageObject clickLoginLink() {
		click(logInLinkLocator);
		logger.info("[CLICKED \"Form Authentication\" LINK ON WELCOME PAGE]");
		return new LoginPageObject(driver, logger);
	}
	
	public CheckboxPageObject clickCheckBoxLink() {
		click(checkBoxLinkLocator);
		logger.info("[CLICKED \"CHECKBOXES\" LINK ON WELCOME PAGE]");
		return new CheckboxPageObject(driver, logger);
	}
	
	public DropdownPageObject clickDropdownLink() {
		click(dropdownLinkLocator);
		logger.info("[CLICKED \"DROPDOWN\" LINK ON WELCOME PAGE]");
		return new DropdownPageObject(driver, logger);
	}
	
	public JavaScriptAlertsPageObject clickJavaScriptAlertsLink() {
		click(jsAlertsLinkLocator);
		logger.info("[CLICKED \"JAVASCRIPT ALERTS\" LINK ON WELCOME PAGE]");
		return new JavaScriptAlertsPageObject(driver, logger);
	}
}
