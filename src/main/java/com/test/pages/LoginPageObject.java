package com.test.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePageObject {
	private String url = "http://the-internet.herokuapp.com/login";
	private By usernameLocator = By.xpath("//*[@id=\"username\"]");
	private By passwordLocator = By.xpath("//*[@id=\"password\"]");
	private By logInButtonLocator = By.xpath("//*[@id=\"login\"]/button/i");

	public LoginPageObject(WebDriver driver, Logger logger) {
		super(driver, logger);
	}

	public String getUrl() {
		return url;
	}

	public SecureAreaPageObject logIn(String username, String password) {
		logger.info(
				"[EXECUTING \"logIn\" METHOD WITH USERNAME \"" + username + "\" AND PASSWORD \"" + password + "\"]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);

		return new SecureAreaPageObject(driver, logger);
	}
}
