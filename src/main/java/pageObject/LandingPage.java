package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private WebDriver driver;

	private By signIn = By.xpath("//span[contains(text(),'Login')]");
	private By titleHeader = By.xpath("//h2[contains(text(),'Featured Courses')] ");
	private By navBar = By.tagName("nav");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signIn);
	}

	public WebElement getTitleHeader() {
		return driver.findElement(titleHeader);
	}

	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}
}
