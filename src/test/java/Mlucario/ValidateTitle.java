package Mlucario;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class ValidateTitle extends base {

	@BeforeTest
	public void initialize() throws IOException {
		// create WebDriver based on properties file
		driver = initializeDriver();
		LOGGER.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		LOGGER.info("Navigated to Home Page");
	}

	@Test
	public void basePageNavigation() {

		LandingPage ld = new LandingPage(driver);

		// Test if we see "Featured Courses"
		String expected = "FEATURED COURSES123";
		Assert.assertEquals(ld.getTitleHeader().getText(), expected);
		LOGGER.info("Successfully validated FEATURED COURSES");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}

}
