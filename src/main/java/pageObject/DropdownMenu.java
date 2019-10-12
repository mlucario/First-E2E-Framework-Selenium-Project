package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownMenu {
	private WebDriver driver;

	private By firstDropDownMenu = By.cssSelector("#select-demo");
	private By secondDropDownMenu = By.cssSelector("#multi-select");
	private By firstResultDisplay = By.xpath("//p[@class='selected-value']");
	private By secondResultDisplay = By.xpath("//p[@class='getall-selected']");
	private By firstSelectedBTN = By.cssSelector("#printMe");
	private By getAllSelectedBTN = By.cssSelector("#printAll");

	public DropdownMenu(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getFirstDropDownMenu() {
		return driver.findElement(firstDropDownMenu);
	}

	public WebElement getSecondDropDownMenu() {
		return driver.findElement(secondDropDownMenu);
	}

	public WebElement getFirstResultDisplay() {
		return driver.findElement(firstResultDisplay);
	}

	public WebElement getSecondResultDisplay() {
		return driver.findElement(secondResultDisplay);
	}

	public WebElement getFirstSelectedBTN() {
		return driver.findElement(firstSelectedBTN);
	}

	public WebElement getGetAllSelectedBTN() {
		return driver.findElement(getAllSelectedBTN);
	}
}
