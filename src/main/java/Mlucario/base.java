package Mlucario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	private int implicitlyWaitTime = 10;
	public Properties prop = new Properties();

	/**
	 * initializeDriver method will setup WebDriver base on clien Broswer (chrome.
	 * firefox, IE..)
	 * 
	 * @throws IOException
	 */
	public WebDriver initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream("resources/enviroment.properties");

		prop.load(fis);

		String broswerName = prop.getProperty("browser");
		String os = System.getProperty("os.name");

		// Set System Property base on system and browser
		switch (broswerName.toLowerCase()) {
		// Run with Chrome Browser
		case "chrome":
			if (os.contains("Mac")) {
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			} else if (os.contains("Windows")) {
				System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			} else {
				System.out.println("Other OS. Please contact with Admin to open this features==========");
			}
			driver = new ChromeDriver();
			break;
		// Run with Firefox Browser
		case "firefox":
			if (os.contains("Mac")) {
				System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			} else if (os.contains("Windows")) {
				System.setProperty("webdriver.gecko.driver", "drivers//geckodriver.exe");
			} else {
				System.out.println("Other OS. Please contact with Admin to open this features==========");
			}
			driver = new FirefoxDriver();
			break;
		// Run with ie Browser, support for Windows only
		case "ie":
			System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		// Add waiting time implicitlywait
		driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

}
