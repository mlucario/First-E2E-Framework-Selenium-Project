package Mlucario;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;

public class ValidateLandingPage extends base {

	@Test
	public void basePageNavigation() throws IOException {
		// create WebDriver based on properties file
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		LandingPage ld = new LandingPage(driver);

		// Test if we see "Featured Courses"
		String expected = "FEATURED COURSES";
		AssertJUnit.assertEquals(ld.getTitleHeader().getText(), expected);

		// Test Navigation Bar
		AssertJUnit.assertTrue(ld.getNavigationBar().isDisplayed());
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
}
