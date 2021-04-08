package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.pages.DropdownPageObject;
import com.test.pages.WelcomePageObject;
import com.test.utilities.TestUtilities;

public class DropdownTest extends TestUtilities {
	WelcomePageObject welcomePage;
	DropdownPageObject dropdownPage;

	@Test
	public void selectDropdownOption() {
		welcomePage = new WelcomePageObject(driver, logger);
		welcomePage.openPage();
		logger.info("[WELCOME PAGE OPENED]");

		dropdownPage = welcomePage.clickDropdownLink();
		dropdownPage.selectOption(1);

		String selectedOption = dropdownPage.getSelectedOption();
		sleep(2000);
		Assert.assertTrue(selectedOption.equals("Option 2"),
				"[\"Option 2\" WAS NOT SELECTED. INSTEAD \"" + selectedOption + "\" WAS SELECTED]");
	}
}
