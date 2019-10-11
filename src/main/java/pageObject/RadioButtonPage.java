package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage {
	private WebDriver driver;
	private By maleRadio1 = By.xpath("//body/div/div/div/div/div/label[contains(text(),'Male')]/input[1]");
	private By femaleRadio1 = By.xpath("//body/div/div/div/div/div/label[contains(text(),'Female')]/input[1]");
	private By femaleRadio2 = By.xpath("//html//body//div//div//div//div//div//div//label[contains(text(),'Female')]//input");
	private By maleRadio2 = By.xpath("//html//body//div//div//div//div//div//div//label[contains(text(),'Male')]//input");
	private By checkButton1 = By.cssSelector("buttoncheck");
	
}
