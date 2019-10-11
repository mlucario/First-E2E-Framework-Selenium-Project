package basicSample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BasicExamplePage;
import pageObject.WelcomePage;
import resources.base;

public class validatedSimpleForm extends base{
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
		bs.getSimpleForm().click();
		LOGGER.info("Navigated to basic-first-form-demo");
	}
	
	@Test
	public void singleInput() {
		String expectedString = "Test Single Input";
		driver.findElement(By.cssSelector("#user-message")).sendKeys(expectedString);
		driver.findElement(By.xpath("//form[@id='get-input']/button[contains(text(),'Show Message')]")).click();
		String actual = driver.findElement(By.cssSelector(("#display"))).getText();
		Assert.assertEquals(actual, expectedString);
		LOGGER.info("validated Single Input Form");
	}
	
	@Test
	public void validateSumTwoInput() {
		String x = "3";
		String y = "4";
		String result = "7";
		driver.findElement(By.cssSelector("#sum1")).sendKeys(x);
		driver.findElement(By.cssSelector("#sum2")).sendKeys(y);
		driver.findElement(By.xpath("//button[contains(text(),'Get Total')]")).click();
		String actualValue = driver.findElement(By.cssSelector("#displayvalue")).getText();
		Assert.assertEquals(actualValue, result);
		LOGGER.info("validated sum two number");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
