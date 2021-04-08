package testPackage;

import com.test.pages.JavaScriptAlertsPageObject;
import com.test.pages.WelcomePageObject;
import com.test.utilities.TestUtilities;

public class AlertsTest extends TestUtilities {
	
	public void jsAlertTest() {
		WelcomePageObject welcomePage = new WelcomePageObject(driver, logger);
		welcomePage.openPage();
		
		JavaScriptAlertsPageObject jsAlertsPage = new JavaScriptAlertsPageObject(driver, logger);
		
	}
	
	public void jsDismissTest() {
		
	}
	
	public void jsPromptTest() {
		
	}
}
