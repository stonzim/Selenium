package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.pages.CheckboxPageObject;
import com.test.pages.WelcomePageObject;
import com.test.utilities.TestUtilities;

public class CheckboxTest extends TestUtilities {
	WelcomePageObject welcomePage;
	CheckboxPageObject checkboxPage;
	
	@Test
	public void selectCheckBoxes() {
		welcomePage = new WelcomePageObject(driver, logger);
		welcomePage.openPage();
		
		checkboxPage = welcomePage.clickCheckBoxLink();
		checkboxPage.selectAllCheckBox();
		
		Assert.assertEquals(checkboxPage.areAllCheckboxesChecked(), true);
	}

}
