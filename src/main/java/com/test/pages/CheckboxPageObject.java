package com.test.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPageObject extends BasePageObject {
	private String url = "http://the-internet.herokuapp.com/checkboxes";
	private By firstCheckboxLocator = By.xpath("/html/body/div[2]/div/div/form/input[1]");
	private By secondCheckboxLocator = By.xpath("/html/body/div[2]/div/div/form/input[2]");
	private By checkbox = By.xpath("//input[@type='checkbox']");
	private List<WebElement> checkboxes;

	public CheckboxPageObject(WebDriver driver, Logger logger) {
		super(driver, logger);
	}

	public String getUrl() {
		return url;
	}
	
	public void clickFirstCheckbox() {
		click(firstCheckboxLocator);
	}
	
	public void clickSecondCheckbox( ) {
		click(secondCheckboxLocator);
	}
	
	public void selectAllCheckBox() {
		logger.info("[CHECKING ALL UNCHECKED CHECKBOXES]");
		checkboxes = findAll(checkbox);
		for(WebElement checkbox: checkboxes) {
			if(!checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}
	
	public boolean areAllCheckboxesChecked() {
		logger.info("[VERIFYING ALL CHECKBOXES CHECKED]");
		checkboxes = findAll(checkbox);
		for(WebElement checkbox: checkboxes) {
			if(!checkbox.isSelected()) {
				return false;
			}
		}
		return true;
	}
}
