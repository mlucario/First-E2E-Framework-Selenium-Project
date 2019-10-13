package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowsPopUp {
	private WebDriver driver;
	private By followOnTwitterButton = By.xpath("//a[contains(text(),'Follow On Twitter')]");

	public WindowsPopUp(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFollowOnTwitterButton() {
		return driver.findElement(followOnTwitterButton);
	}
}
