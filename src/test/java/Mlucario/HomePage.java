package Mlucario;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base {
	@BeforeTest
	public void initialize() throws IOException {
		// create WebDriver based on properties file
		driver = initializeDriver();

	}

	@Test(dataProvider = "getData")
	public void testLoginFeature(String userName, String passWord, String text) throws IOException {
		driver.get(prop.getProperty("url"));

		LandingPage ld = new LandingPage(driver);
		// Go to Login Page
		ld.getLogin().click();

		LoginPage lg = new LoginPage(driver);

		lg.getEmail().sendKeys(userName);
		lg.getPassword().sendKeys(passWord);
		LOGGER.info(text);
		lg.getLoginButton().click();
	}

	@DataProvider
	public Object[][] getData() {
		// Two row with two col
		// 1 row for non restrict user
		// 1 row for restrict user
		// 2 col : username + password

		// HAVE TOO ADD +1 into array SIZE
		Object[][] data = new Object[2][3];
		data[0][0] = "non_restrict_user@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Non restricted user";

		// restricted user
		data[1][0] = "restricted_user@qw.com";
		data[1][1] = "123456";
		data[1][2] = "restricted user";

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}

}
