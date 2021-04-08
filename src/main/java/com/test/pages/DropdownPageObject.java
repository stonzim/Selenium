package com.test.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPageObject extends BasePageObject {
	private By dropdown = By.xpath("//*[@id=\"dropdown\"]");
	
	public DropdownPageObject(WebDriver driver, Logger logger) {
		super(driver, logger);
	}

	public void selectOption(int i) {
		logger.info("[SELECT OPTION " + i + " FROM DROPDOWN]");
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue(Integer.toString(i));	
	}
	
	public String getSelectedOption() {
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		logger.info("[" + selectedOption + " IS SELECTED IN DROPDOWN]");
		return selectedOption;
	}

}
