package Mlucario;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class validateNavigationBar extends base {
	@BeforeTest
	public void initialize() throws IOException {
		// create WebDriver based on properties file
		driver = initializeDriver();
		LOGGER.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		LOGGER.info("Navigated to Home Page");
	}

	@Test
	public void validateNavigationBar() {

		LandingPage ld = new LandingPage(driver);

		// Test Navigation Bar
		Assert.assertTrue(ld.getNavigationBar().isDisplayed());
		LOGGER.info("Successfully validated Navigation bar - display");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}

}
