package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public static WebDriver driver;
	private int implicitlyWaitTime = 10;
	public Properties prop = new Properties();
	public final Logger LOGGER = LogManager.getLogger(base.class.getName());
	private static String os = System.getProperty("os.name");

	/**
	 * initializeDriver method will setup WebDriver base on clien Broswer (chrome.
	 * firefox, IE..)
	 * 
	 * @throws IOException
	 */
	public WebDriver initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream("src/main/java/resources/enviroment.properties");

		prop.load(fis);

		// Read propertise file
//		String broswerName = prop.getProperty("browser");

		/**
		 * Update Optimze with Jenkin
		 */

		String broswerName = System.getProperty("browser");

		// Set System Property base on system and browser
		switch (broswerName.toLowerCase()) {
		// Run with Chrome Browser
		case "chrome":

			driver = initChromeDriver();
			break;
		// Run with Firefox Browser
		case "firefox":

			driver = initFirefoxDriver();
			break;
		// Run with ie Browser, support for Windows only
		case "ie":
			System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
//			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver = initChromeDriver();
			break;
		}

		// Add waiting time implicitlywait
		driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	private static WebDriver initChromeDriver() {
		System.out.println("Launching google chrome with new profile..");
		if (os.contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		} else if (os.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		} else {
			System.out.println("Other OS. Please contact with Admin to open this features==========");
		}
		return driver = new ChromeDriver();
	}

	private static WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser..");
		if (os.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		} else if (os.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", "drivers//geckodriver.exe");
		} else {
			System.out.println("Other OS. Please contact with Admin to open this features==========");
		}
		return driver = new FirefoxDriver();

	}

	public void getScreenShot(String dest) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(dest));
	}

}
