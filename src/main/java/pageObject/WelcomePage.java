package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {

	private WebDriver driver;
	private By headerTitle = By.xpath("//h3[contains(text(),'Welcome to Selenium Easy')]");
	private By introText = By.xpath("//p[contains(text(),'We have listed most of the components that are use')]");
	private By startButton = By.cssSelector("#btn_basic_example");
	private By homeBarIcon = By.cssSelector("#home_bar");
	private By basicIcon = By.cssSelector("#basic_example");
	private By intermediateIcon = By.cssSelector("#inter_example");
	private By advancedIcon = By.cssSelector("#advanced_example");
	private By completeIcon = By.cssSelector("#done_example");

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHeaderTitle() {
		return driver.findElement(headerTitle);
	}

	public WebElement getIntroText() {
		return driver.findElement(introText);
	}

	public WebElement getStartButton() {
		return driver.findElement(startButton);
	}

	public WebElement getHomeIcon() {
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
