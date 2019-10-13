package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertPage {
	private WebDriver driver;

	private By firstClickMe = By.xpath("//button[@class='btn btn-default']");
	private By secondClickMe = By.xpath("//button[@class='btn btn-default btn-lg'][contains(text(),'Click me!')]");
	private By thirdClickMe = By.xpath("//button[contains(text(),'Click for Prompt Box')]");
	private By resultDisplay2 = By.cssSelector("#confirm-demo");
	private By resultDisplay3 = By.cssSelector("#prompt-demo");

	public AlertPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstClickMe() {
		return driver.findElement(firstClickMe);
	}

	public WebElement getSecondClickMe() {
		return driver.findElement(secondClickMe);
	}

	public WebElement getThirdClickMe() {
		return driver.findElement(thirdClickMe);
	}

	public WebElement getresultDisplay2() {
		return driver.findElement(resultDisplay2);
	}

	public WebElement getresultDisplay3() {
		return driver.findElement(resultDisplay3);
	}
}
