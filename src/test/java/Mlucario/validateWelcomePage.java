package Mlucario;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.WelcomePage;
import resources.base;

public class validateWelcomePage extends base {
	@BeforeTest
	public void initialize() throws IOException {
		// create WebDriver based on properties file
		driver = initializeDriver();
		LOGGER.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		LOGGER.info("Navigated to LandingPage");
	}

	@Test
	public void validateHomeIcon() {
		WelcomePage wc = new WelcomePage(driver);
		Assert.assertTrue(wc.getHomeIcon().isEnabled());
		LOGGER.info("Home Button Icon found!");
	}

	@Test
	public void validateBasicPracticeIcon() {
		WelcomePage wc = new WelcomePage(driver);
		Assert.assertTrue(wc.getBasicPracticeIcon().isEnabled());
		LOGGER.info("Basic Button Icon found!");
	}

	@Test
	public void validateIntermediatePracticeIcon() {
		WelcomePage wc = new WelcomePage(driver);
		Assert.assertTrue(wc.getIntermediatePracticeIcon().isEnabled());
		LOGGER.info("Intermediate Button Icon found!");
	}

	@Test
	public void validateAdvantagePracticeIcon() {
		WelcomePage wc = new WelcomePage(driver);
		Assert.assertTrue(wc.getHomeIcon().isEnabled());
		LOGGER.info("Advantage Button Icon found!");
	}

	@Test
	public void validateHeaderTitle() {
		WelcomePage wc = new WelcomePage(driver);
		Assert.assertTrue(wc.getHeaderTitle().isEnabled());
		LOGGER.info("Header Title was found!");
	}

	@Test
	public void validateIntroText() {
		WelcomePage wc = new WelcomePage(driver);
		Assert.assertTrue(wc.getIntroText().isEnabled());
		LOGGER.info("Intro Text was found!");
	}

	@Test
	public void validateStartButton() {
		WelcomePage wc = new WelcomePage(driver);
		Assert.assertTrue(wc.getStartButton().isEnabled());
		LOGGER.info("Start Button was found!");
	}
//	@Test(dataProvider = "getData")
//	public void testLoginFeature(String userName, String passWord, String text) throws IOException {
//		driver.get(prop.getProperty("url"));
//
//		LandingPage ld = new LandingPage(driver);
//		// Go to Login Page
//		ld.getLogin().click();
//
//		WelcomePage lg = new WelcomePage(driver);
//
//		lg.getEmail().sendKeys(userName);
//		lg.getPassword().sendKeys(passWord);
//		LOGGER.info(text);
//		lg.getLoginButton().click();
//	}
//
//	@DataProvider
//	public Object[][] getData() {
//		// Two row with two col
//		// 1 row for non restrict user
//		// 1 row for restrict user
//		// 2 col : username + password
//
//		// HAVE TOO ADD +1 into array SIZE
//		Object[][] data = new Object[2][3];
//		data[0][0] = "non_restrict_user@qw.com";
//		data[0][1] = "123456";
//		data[0][2] = "Non restricted user";
//
//		// restricted user
//		data[1][0] = "restricted_user@qw.com";
//		data[1][1] = "123456";
//		data[1][2] = "restricted user";
//
//		return data;
//	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}

}
