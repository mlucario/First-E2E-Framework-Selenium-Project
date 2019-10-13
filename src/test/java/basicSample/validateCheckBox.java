package basicSample;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BasicExamplePage;
import pageObject.CheckBoxBasicPage;
import pageObject.WelcomePage;
import resources.base;

public class validateCheckBox extends base {
	private CheckBoxBasicPage cb;

	@BeforeTest
	public void initialize() throws IOException {
		// create WebDriver based on properties file
		driver = initializeDriver();
		LOGGER.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		LOGGER.info("Navigated to Home Page");
		WelcomePage wc = new WelcomePage(driver);
		wc.getBasicPracticeIcon().click();
		LOGGER.info("Navigated to Basic Example Page");
		BasicExamplePage bs = new BasicExamplePage(driver);
		bs.getCheckBox().click();
		LOGGER.info("Navigated to check box practice");
		cb = new CheckBoxBasicPage(driver);
	}

	@Test(priority = 1)
	public void validatedUncheckBox1() {
		Assert.assertFalse(cb.getAgeCheckBox().isSelected());
		LOGGER.info("Checkbox Age is Unselected at begininig");
	}

	@Test(priority = 2)
	public void validatedCheckedkBox1() {
		cb.getAgeCheckBox().click();
		Assert.assertTrue(cb.getAgeCheckBox().isSelected());
		LOGGER.info("Checkbox Age is selected");
		Assert.assertTrue(cb.getTxtAge().isDisplayed());
		LOGGER.info("success message will display!");
		Assert.assertEquals(cb.getTxtAge().getText(), "Success - Check box is checked");
	}

	@Test(priority = 3)
	public void validatedButton1() {
		Assert.assertEquals(cb.getCheckButton().getAttribute("value"), "Check All");
		LOGGER.info("Validated Button Value Text _ Check All");
	}

	@Test(priority = 4)
	public void validateButtonCheckAll() {
		cb.getCheckButton().click();
		Assert.assertEquals(cb.getCheckbox1().isSelected(), true);
		Assert.assertEquals(cb.getCheckbox2().isSelected(), true);
		Assert.assertEquals(cb.getCheckbox3().isSelected(), true);
		Assert.assertEquals(cb.getCheckbox4().isSelected(), true);
		Assert.assertEquals(cb.getCheckButton().getAttribute("value"), "Uncheck All");
	}

	@Test(priority = 5)
	public void validateButtonUnCheckAll() {
		cb.getCheckButton().click();
		Assert.assertEquals(cb.getCheckbox1().isSelected(), false);
		Assert.assertEquals(cb.getCheckbox2().isSelected(), false);
		Assert.assertEquals(cb.getCheckbox3().isSelected(), false);
		Assert.assertEquals(cb.getCheckbox4().isSelected(), false);
		Assert.assertEquals(cb.getCheckButton().getAttribute("value"), "Check All");
	}

	@Test(priority = 6)
	public void validateCheckAllValue() {
		cb.getCheckButton().click();
		Assert.assertEquals(cb.getCheckbox1().isSelected(), true);
		Assert.assertEquals(cb.getCheckbox2().isSelected(), true);
		Assert.assertEquals(cb.getCheckbox3().isSelected(), true);
		Assert.assertEquals(cb.getCheckbox4().isSelected(), true);
		Assert.assertEquals(cb.getCheckButton().getAttribute("value"), "Uncheck All");
		cb.getCheckbox4().click();
		cb.getCheckbox3().click();
		Assert.assertEquals(cb.getCheckButton().getAttribute("value"), "Check All");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
