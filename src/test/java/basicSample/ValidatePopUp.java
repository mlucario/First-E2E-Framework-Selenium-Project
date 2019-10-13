package basicSample;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BasicExamplePage;
import pageObject.WelcomePage;
import pageObject.WindowsPopUp;
import resources.base;

public class ValidatePopUp extends base {
	private WindowsPopUp popup;

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
		bs.getPopupModal().click();
		LOGGER.info("Navigated to windows popup practice");
		popup = new WindowsPopUp(driver);
	}

	@Test(priority = 1)
	public void validate_switch_to_child_get_title() {
		popup.getFollowOnTwitterButton().click();
		Assert.assertEquals(driver.getTitle(), "Selenium Easy - Window Popup Modal Demo");
		String mainWindows = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> temp = allWindows.iterator();
		String childWindows = temp.next();
		String childWindows2 = temp.next();
		driver.switchTo().window(mainWindows);

		LOGGER.info("Navigated to parent windows tab");
		Assert.assertEquals(driver.getTitle(), "Selenium Easy - Window Popup Modal Demo");
		driver.switchTo().window(childWindows2);
		Assert.assertEquals(driver.getTitle(), "Selenium Easy (@seleniumeasy) on Twitter");

	}

	@Test(priority = 2)
	public void validate_switch_to_child_and_fill_data() {
		LOGGER.debug("Browser stay at child windows twitter sign in page");
		driver.findElement(By.cssSelector("#username_or_email")).sendKeys("Test@gmail.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("Test@gmail.com");
		driver.findElement(By.cssSelector("#remember")).click();
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		LOGGER.debug("Sign in with invalid info.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#message-drawer")).getText(),
				"The email and password you entered did not match our records. Please double-check and try again");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
