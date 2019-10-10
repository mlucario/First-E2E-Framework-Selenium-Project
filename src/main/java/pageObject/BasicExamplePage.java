package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicExamplePage {
	private WebDriver driver;
	private By simpleForm = By.xpath("//a[@class='list-group-item'][contains(text(),'Simple Form Demo')]");
	private By checkBox = By.xpath("//a[contains(text(),'Check Box Demo')]");
	private By radioButtons = By.cssSelector("//a[@class='list-group-item'][contains(text(),'Radio Buttons Demo')]");
	private By dropDownList = By.cssSelector("//a[@class='list-group-item'][contains(text(),'Select Dropdown List')]");
	private By alertJava = By.cssSelector("#basic_example");
	private By popupModal = By.cssSelector("#inter_example");
	private By bootstrapAlerts = By.cssSelector("#advanced_example");
	private By bootstrapModals = By.cssSelector("#done_example");
	private By listElements = By.xpath("//div[@id='basic']//div[@class='list-group']");

	public BasicExamplePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSimpleForm() {
		return driver.findElement(simpleForm);
	}

	public WebElement getCheckBox() {

		return driver.findElement(checkBox);
	}

	public WebElement getRadioButtons() {
		return driver.findElement(radioButtons);

	}

	public WebElement getDropDownList() {
		return driver.findElement(dropDownList);

	}

	public WebElement getAlertJava() {
		return driver.findElement(alertJava);

	}

	public WebElement getPopupModal() {
		return driver.findElement(popupModal);

	}

	public WebElement getBootstrapAlerts() {
		return driver.findElement(bootstrapAlerts);

	}

	public WebElement getBootstrapModals() {
		return driver.findElement(bootstrapModals);

	}

	public List<WebElement> getAllElement() {
		WebElement basicZ = driver.findElement(listElements);
		// System.out.println("===============================" +
		// basicZ.findElements(By.tagName("a")).size());
		return basicZ.findElements(By.tagName("a"));
	}
}
