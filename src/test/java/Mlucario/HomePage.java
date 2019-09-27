package Mlucario;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.LandingPage;

public class HomePage extends base {

	@Test
	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		driver.get("http://www.qaclickacademy.com/");

		LandingPage ld = new LandingPage(driver);
		ld.getLogin().click();

	}
}
