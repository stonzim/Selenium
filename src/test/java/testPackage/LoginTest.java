package testPackage;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.pages.LoginPageObject;
import com.test.pages.SecureAreaPageObject;
import com.test.pages.WelcomePageObject;
import com.test.utilities.ExcelReader;
import com.test.utilities.TestUtilities;

public class LoginTest extends TestUtilities {
	ExcelReader testUtil;
	ArrayList<Object[]> cells;
	WelcomePageObject welcomePage;
	LoginPageObject loginPage;
	SecureAreaPageObject secureArea;

	@DataProvider
	public Iterator<Object[]> getTestData() {
		cells = new ArrayList<Object[]>();
		testUtil = new ExcelReader();
		cells = testUtil.getData();
		return cells.iterator();
	}

	@Parameters({ "username", "password" })
	@Test(dataProvider = "getTestData")
	public void login(String username, String password) {
		welcomePage = new WelcomePageObject(driver, logger);
		welcomePage.openPage();
//		takeScreenShot("Welcome Page Open");

		loginPage = welcomePage.clickLoginLink();
//		takeScreenShot("Log In Page Open");
		Cookie cookie = new Cookie("username", "tomsmith", "the-internet.herokuapp.com", "/", null);
		loginPage.setCookie(cookie);

		secureArea = loginPage.logIn(username, password);
//		takeScreenShot("Secure Page Open");

		String cookieUsername = secureArea.getCookie("username");
		logger.info("Username Cookie: " + cookieUsername);
		String userinfo = secureArea.getCookie("rack.session");
		logger.info("[COOKIE \"rack.session\" VALUE: " + userinfo + "]");

		Assert.assertEquals(secureArea.isLogOutButtonVisible(), true);
	}
}
