package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonPage {
	private WebDriver driver;
	private By maleRadio1 = By.xpath("//body/div/div/div/div/div/label[contains(text(),'Male')]/input[1]");
	private By femaleRadio1 = By.xpath("//body/div/div/div/div/div/label[contains(text(),'Female')]/input[1]");
	private By femaleRadio2 = By
			.xpath("//html//body//div//div//div//div//div//div//label[contains(text(),'Female')]//input");
	private By maleRadio2 = By
			.xpath("//html//body//div//div//div//div//div//div//label[contains(text(),'Male')]//input");

	private By radioResult1 = By.xpath("//p[@class='radiobutton']");
	private By checkedValueButton = By.xpath("//button[@id='buttoncheck']");
	private By age0to5 = By.xpath("//label[contains(text(),'0 to 5')]");
	private By age5to15 = By.xpath("//label[contains(text(),'5 to 15')]");
	private By age15to50 = By.xpath("//label[contains(text(),'15 to 50')]");
	private By groupRadioResults = By.xpath("//p[@class='groupradiobutton']");
	private By valueButton = By.xpath("//button[contains(text(),'Get values')]");

	public RadioButtonPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMaleRadio1() {
		return driver.findElement(maleRadio1);
	}

	public WebElement getFemaleRadio1() {
		return driver.findElement(femaleRadio1);
	}

	public WebElement getFemaleRadio2() {
		return driver.findElement(femaleRadio2);
	}

	public WebElement getMaleRadio2() {
		return driver.findElement(maleRadio2);
	}

	public WebElement getAge0to5() {
		return driver.findElement(age0to5);
	}

	public WebElement getAge5to15() {
		return driver.findElement(age5to15);
	}

	public WebElement getAge15to50() {
		return driver.findElement(age15to50);
	}

	public WebElement getGroupRadioResults() {
		return driver.findElement(groupRadioResults);
	}

	public WebElement getradioResult1() {
		return driver.findElement(radioResult1);
	}

	public WebElement getcheckedValueButton() {
		return driver.findElement(checkedValueButton);
	}

	public WebElement getValueButton() {
		return driver.findElement(valueButton);
	}

}
