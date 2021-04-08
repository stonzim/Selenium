package com.test.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtilities extends BaseTest {

	protected void takeScreenShot(String fileName) {
		File sourcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") 
				+ File.separator + "test-output" 
				+ File.separator + "screenshots"
				+ File.separator + getTodaysDate() 
				+ File.separator + testSuiteName 
				+ File.separator + testName 
				+ File.separator + testMethodName 
				+ File.separator + getSystemTime() 
				+ " " + fileName + ".png";
		try {
			FileUtils.copyFile(sourcFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getTodaysDate() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}

	private static String getSystemTime() {
		return new SimpleDateFormat("HHmmss").format(new Date());
	}
	
	protected void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
