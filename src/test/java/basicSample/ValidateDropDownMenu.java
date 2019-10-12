package basicSample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BasicExamplePage;
import pageObject.DropdownMenu;
import pageObject.WelcomePage;
import resources.base;

public class ValidateDropDownMenu extends base {
	private DropdownMenu dropDown;

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
		bs.getDropDownList().click();
		LOGGER.info("Navigated to drop down page practice");
		dropDown = new DropdownMenu(driver);
	}

	@Test
	public void validated_select_Sunday_of_dropdown_menu() {
		// Step 1: create Select object
		Select s = new Select(dropDown.getFirstDropDownMenu());
		// Step 2: select visible value
		s.selectByVisibleText("Sunday");
		Assert.assertEquals(dropDown.getFirstResultDisplay().getText(), "Day selected :- Sunday");
		LOGGER.info("Selected Sunday in the list");
	}

	@Test
	public void validated_select_Monday_of_dropdown_menu() {
		// Step 1: create Select object
		Select s = new Select(dropDown.getFirstDropDownMenu());
		// Step 2: select value
		s.selectByValue("Monday");
		Assert.assertEquals(dropDown.getFirstResultDisplay().getText(), "Day selected :- Monday");
		LOGGER.info("Selected Monday in the list");
	}

	@Test
	public void validated_select_Wednesday_of_dropdown_menu() {
		// Step 1: create Select object
		Select s = new Select(dropDown.getFirstDropDownMenu());
		// Step 2: select index
		s.selectByIndex(4);
		Assert.assertEquals(dropDown.getFirstResultDisplay().getText(), "Day selected :- Wednesday");
		LOGGER.info("Selected Wednesday in the list");
	}

	@Test
	public void validated_multi_selected_value_of_dropdown_menu_1() {
		// Step 1: create Action Object to handle Ctrl Key
		Actions ac = new Actions(driver);
		ac.keyDown(Keys.LEFT_CONTROL);
		ac.moveToElement(driver.findElement(By.xpath("//option[contains(text(),'California')]"))).click();
		ac.moveToElement(driver.findElement(By.xpath("//option[contains(text(),'Pennsylvania')]"))).click();
		ac.moveToElement(driver.findElement(By.xpath("//option[contains(text(),'Washington')]"))).click();
		ac.build().perform();
		dropDown.getFirstSelectedBTN().click();
		String exptected = "First selected option is : California";
		Assert.assertEquals(dropDown.getSecondResultDisplay().getText(), exptected);
		LOGGER.info("Validate first selected is California");
	}

	@Test
	public void validated_multi_selected_value_of_dropdown_menu_2() {

		// Step 1: create Action Object to handle Ctrl Key
		driver.navigate().refresh();
		Actions ac = new Actions(driver);
		ac.keyDown(Keys.LEFT_CONTROL);
		ac.moveToElement(driver.findElement(By.xpath("//option[contains(text(),'California')]"))).click();
		ac.moveToElement(driver.findElement(By.xpath("//option[contains(text(),'Pennsylvania')]"))).click();
		ac.moveToElement(driver.findElement(By.xpath("//option[contains(text(),'Washington')]"))).click();
		ac.build().perform();
		dropDown.getGetAllSelectedBTN().click();
		String exptected = "Options selected are : California,Pennsylvania,Washington";
		Assert.assertEquals(dropDown.getSecondResultDisplay().getText(), exptected);
		LOGGER.info("Validate result as : Options selected are : California,Pennsylvania,Washington");
	}

	@AfterTest
	public void tearDown() {
//		driver.quit();
		driver = null;
	}
}
