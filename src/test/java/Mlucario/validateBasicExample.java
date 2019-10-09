package Mlucario;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BasicExamplePage;
import pageObject.WelcomePage;
import resources.base;

public class validateBasicExample extends base {

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
		Actions ac = new Actions(driver);
		BasicExamplePage basic = new BasicExamplePage(driver);
		List<WebElement> els = basic.getAllElement();
//		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, "t");

		for (WebElement wepEl : els) {
			ac.keyDown(Keys.CONTROL).build().perform();
			System.out.println(wepEl.getAttribute("href"));
			wepEl.click();
		}
//		ac.release().build().perform();
//		basic.getSimpleForm().click();
	}

	@Test
	public void validateTitlePage() {

	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//		driver = null;
//	}

}
