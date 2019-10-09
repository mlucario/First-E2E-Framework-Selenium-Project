package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private WebDriver driver;

	private By homeBarIcon = By.cssSelector("#home_bar");
	private By basicIcon = By.cssSelector("#basic_example");
	private By intermediateIcon = By.cssSelector("#inter_example");
	private By advancedIcon = By.cssSelector("#advanced_example");
	private By completeIcon = By.cssSelector("#done_example");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBeginIcon() {
		return driver.findElement(homeBarIcon);
	}

	public WebElement getDoneIcon() {
		return driver.findElement(completeIcon);
	}

	public WebElement getBasicPracticeIcon() {
		return driver.findElement(basicIcon);
	}

	public WebElement getIntermediatePracticeIcon() {
		return driver.findElement(intermediateIcon);
	}

	public WebElement getAdvantagePracticeIcon() {
		return driver.findElement(advancedIcon);
	}
}
