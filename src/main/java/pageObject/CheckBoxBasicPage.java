package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxBasicPage {
	private WebDriver driver;
	private By ageCheckBox = By.cssSelector("#isAgeSelected");
	private By txtAge = By.cssSelector("#txtAge");
	private By checkbox1 = By.xpath("//label[text()='Option 1']//input[@class='cb1-element']");
	private By checkbox2 = By.xpath("//label[text()='Option 2']//input[@class='cb1-element']");
	private By checkbox3 = By.xpath("//label[text()='Option 3']//input[@class='cb1-element']");
	private By checkbox4 = By.xpath("//label[text()='Option 4']//input[@class='cb1-element']");
	
	private By checkButton = By.cssSelector("#check1");
	
	
	public CheckBoxBasicPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getAgeCheckBox() {
		return driver.findElement(ageCheckBox);
	}


	public WebElement getTxtAge() {
		return driver.findElement(txtAge);
	}


	public WebElement getCheckbox1() {
		return driver.findElement(checkbox1);
	}


	public WebElement getCheckbox2() {
		return driver.findElement(checkbox2);
	}


	public WebElement getCheckbox3() {
		return driver.findElement(checkbox3);
	}


	public WebElement getCheckbox4() {
		return driver.findElement(checkbox4);
	}




	public WebElement getCheckButton() {
		return driver.findElement(checkButton);
	}
	
}
