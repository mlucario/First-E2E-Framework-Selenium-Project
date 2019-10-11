package Mlucario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BasicExamplePage;
import pageObject.WelcomePage;
import resources.base;

public class validateBasicExample extends base {

	/**
	 * Practice with change Tabs and Print out title each tabs
	 * 
	 * @throws IOException
	 */
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

	}

	@Test	
	public void validateListPractice() {
		Actions ac = new Actions(driver);
		BasicExamplePage basic = new BasicExamplePage(driver);
		List<WebElement> els = basic.getAllElement();
//		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, "t");

		for (WebElement wepEl : els) {
			ac.keyDown(Keys.CONTROL).build().perform();
//			System.out.println(wepEl.getAttribute("href"));
			wepEl.click();
			LOGGER.info("Navigated to " + wepEl.getAttribute("href"));

		}
		int numTabs = 8;
		Assert.assertEquals(els.size(), numTabs);
		LOGGER.info("Validated basic sample menu 8 elements");
		
		Set<String> handle =  driver.getWindowHandles();
		Iterator<String> x =   handle.iterator();
		ArrayList<String> actualList = new ArrayList<String>();
		while(x.hasNext()) {
			
			driver.switchTo().window(x.next());
			actualList.add(driver.getTitle());
		}
		ArrayList<String> expectedList = new ArrayList<String>() {
			{
				add("Selenium Easy - Best Demo website to practice Selenium Webdriver Online");
				add("Selenium Easy Demo - Bootstrap Modal Demo to Automate");
				add("Selenium Easy - Bootstrap Alerts Demo for Automation");
				add("Selenium Easy - Window Popup Modal Demo");
				add("Selenium Easy Demo - Automate All Scenarios");
				add("Selenium Easy Demo - Automate All Scenarios");
				add("Selenium Easy Demo - Radio buttons demo for Automation");
				add("Selenium Easy - Checkbox demo for automation using selenium");
				add("Selenium Easy Demo - Simple Form to Automate using Selenium");
			}
		};
		
		Assert.assertTrue(actualList.equals(expectedList));
//		ac.release().build().perform();
//		basic.getSimpleForm().click();
	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}

}
