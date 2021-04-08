package com.test.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPageObject extends BasePageObject {
	private By jsAlertButton = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
	private By jsConfirmButton = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
	private By jsPromptButton = By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");

	public JavaScriptAlertsPageObject(WebDriver driver, Logger logger) {
		super(driver, logger);
	}
	
	public void openJSAlert() {
		logger.info("[CLICKING ON \"CLICK ON JS ALERT\" BUTTON]");
		click(jsAlertButton);
	}

}
