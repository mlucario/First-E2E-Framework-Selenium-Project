package basicSample;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BasicExamplePage;
import pageObject.RadioButtonPage;
import pageObject.WelcomePage;
import resources.base;

public class ValidateRadioButton extends base {
	private RadioButtonPage rdBTN;

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
		bs.getRadioButtons().click();
		LOGGER.info("Navigated to radio page practice");
		rdBTN = new RadioButtonPage(driver);
	}

	@Test(priority = 1)
	public void validatedInitialRadioButton() {
		Assert.assertFalse(rdBTN.getMaleRadio1().isSelected());
		Assert.assertFalse(rdBTN.getMaleRadio2().isSelected());
		Assert.assertFalse(rdBTN.getFemaleRadio1().isSelected());
		Assert.assertFalse(rdBTN.getFemaleRadio2().isSelected());
		Assert.assertFalse(rdBTN.getAge0to5().isSelected());
		Assert.assertFalse(rdBTN.getAge5to15().isSelected());
		Assert.assertFalse(rdBTN.getAge15to50().isSelected());
		Assert.assertFalse(rdBTN.getradioResult1().isDisplayed());
		Assert.assertFalse(rdBTN.getGroupRadioResults().isDisplayed());
		Assert.assertTrue(rdBTN.getcheckedValueButton().isDisplayed());
		Assert.assertTrue(rdBTN.getValueButton().isDisplayed());
		LOGGER.info("Validated all elements before starting test!");
	}

	@Test(priority = 2)
	public void validated_Selected_Male_Radio_Button() {
		rdBTN.getMaleRadio1().click();
		Assert.assertTrue(rdBTN.getMaleRadio1().isSelected());
		LOGGER.info("Select Male Radio Button");
		Assert.assertFalse(rdBTN.getFemaleRadio1().isSelected());
		rdBTN.getcheckedValueButton().click();
		String expectedValue = "Radio button 'Male' is checked";
		Assert.assertEquals(rdBTN.getradioResult1().getText(), expectedValue);
	}

	@Test(priority = 3)
	public void validated_Selected_Female_Radio_Button() {
		rdBTN.getFemaleRadio1().click();
		Assert.assertTrue(rdBTN.getFemaleRadio1().isSelected());
		LOGGER.info("Select Female Radio Button");
		Assert.assertFalse(rdBTN.getMaleRadio1().isSelected());
		rdBTN.getcheckedValueButton().click();
		String expectedValue = "Radio button 'Female' is checked";
		Assert.assertEquals(rdBTN.getradioResult1().getText(), expectedValue);
	}

	@Test(priority = 4)
	public void validated_radio_group() {
		rdBTN.getMaleRadio2().click();
		Assert.assertFalse(rdBTN.getFemaleRadio2().isSelected());
		rdBTN.getAge15to50().click();
		Assert.assertFalse(rdBTN.getGroupRadioResults().isDisplayed());
		rdBTN.getValueButton().click();
		Assert.assertTrue(rdBTN.getGroupRadioResults().isDisplayed());
//		System.out.println("============" + rdBTN.getGroupRadioResults().getText() + "=============");
//		String expected = "Sex : Male\r\n" + "Age group: 15 - 50";
//		Assert.assertEquals(rdBTN.getGroupRadioResults().getText().trim(), expected);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
