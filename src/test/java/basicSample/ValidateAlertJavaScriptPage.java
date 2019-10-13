package basicSample;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.AlertPage;
import pageObject.BasicExamplePage;
import pageObject.WelcomePage;
import resources.base;

public class ValidateAlertJavaScriptPage extends base {

	private AlertPage alert;

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
		bs.getAlertJavaScript().click();
		LOGGER.info("Navigated to alert page practice");
		alert = new AlertPage(driver);
	}

	@Test
	public void validated_alertBox() {
		alert.getFirstClickMe().click();
		Assert.assertEquals(driver.switchTo().alert().getText(), "I am an alert box!");
		LOGGER.info("Alert Box is displayed");
		driver.switchTo().alert().accept();
		LOGGER.info("Alert Box is closed");
	}

	@Test
	public void validated_alert_confirm_box_ok_button() {
		alert.getSecondClickMe().click();
		Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!");
		LOGGER.info("Alert Confirm Box is displayed");
		driver.switchTo().alert().accept();
		LOGGER.info("Alert Box is closed");

		// Validate OK Button is Selected
		Assert.assertEquals(alert.getresultDisplay2().getText(), "You pressed OK!");
	}

	@Test
	public void validated_alert_confirm_box_cancel_button() {
		alert.getSecondClickMe().click();
		Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!");
		LOGGER.info("Alert Confirm Box is displayed");
		driver.switchTo().alert().dismiss();
		LOGGER.info("Alert Box is closed");
		// Validate OK Button is Selected
		Assert.assertEquals(alert.getresultDisplay2().getText(), "You pressed Cancel!");
	}

	@Test
	public void validated_alert_javascript_with_input_option_ok_with_name() {
		alert.getThirdClickMe().click();
		LOGGER.info("Alert Confirm Box is displayed");
		String name = "Mlucario";
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		LOGGER.info("Alert Confirm Box is closed");
		Assert.assertEquals(alert.getresultDisplay3().getText(), "You have entered 'Mlucario' !");
	}

	@Test
	public void validated_alert_javascript_with_input_option_cancel() {
		alert.getThirdClickMe().click();
		LOGGER.info("Alert Confirm Box is displayed");
		String name = "Mlucario";
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().dismiss();
		LOGGER.info("Alert Confirm Box is closed");
		Assert.assertEquals(alert.getresultDisplay3().getText(), "");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
