package com.Abzooba.chatbot.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

import com.Abzooba.chatbot.util.ExcelReader;

import junit.framework.Assert;

public class TestCore {

	/*
	 * Initializing Properties, Excel File,Creating DB Connection,
	 * Generating logs,
	 * Initialize WebDriver
	 */

	public static Properties config = new Properties();
	public static Properties object = new Properties();
	public static ExcelReader excel = null;
	public static WebDriver driver = null;
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");

	/*
		public static String QUERY_FILEPATH_COMPARISON;
		public static char SEPARATOR = '\t';
	*/
	@BeforeSuite
	public static void init() throws IOException {

		if (driver == null) {

			//Loading Config Property File

			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\Abzooba\\chatbot\\properties\\Config.properties");

			config.load(fis);

			app_logs.debug("Loading the config properties file");

			//Loading object property file

			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\Abzooba\\chatbot\\properties\\Objects.properties");

			object.load(fis);

			app_logs.debug("Loading the object properties file");

			//Loading excel file
			excel = new ExcelReader("D:\\ChatbotTesting\\ChatBot_Auto_UITesting\\src\\main\\java\\com\\Abzooba\\chatbot\\properties\\ChatBot_TestData.xlsx");

			app_logs.debug("Loading the Excel file");

			if (config.getProperty("browser").equals("firefox")) {

				driver = new FirefoxDriver();
				app_logs.debug("Launching Firefox Browser");

			} else if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", "D:\\ChatbotTesting\\ChatBot_Auto_UITesting\\chromedriver.exe");
				driver = new ChromeDriver();
				app_logs.debug("Launching Chrome Browser");

			} else if (config.getProperty("browser").equals("InternetExploer")) {

				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				app_logs.debug("Launching InternetExploer Browser");
			}

			driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

			driver.get(config.getProperty("testURL"));

			driver.manage().window().maximize();
		}

	}

	//@AfterSuite
	public static void QuitDriver() {

		driver.quit();

		/*monitoringMail mail = new monitoringMail();
		
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);*/

	}

	public static void navigateTo() {

		driver.navigate().to("https://www.messenger.com/");
	}

	// Get the Title
	public static String getTitle() {

		return driver.getTitle();
	}

	//Get the Page Text
	public static String getText(By by) {

		return driver.findElement(by).getText();
	}

	//isElementPresent

	public static boolean isElementPresent(By by) {

		try {

			driver.findElement(by).isDisplayed();
			driver.findElement(by).isEnabled();

			return true;

		} catch (NoSuchElementException e) {

			e.printStackTrace();

			Assert.assertTrue(e.getMessage(), false);
		}

		return false;
	}

	//isElementPresentclick
	public static boolean isElementPresentClick(By by) {

		try {

			driver.findElement(by).isDisplayed();
			driver.findElement(by).click();
			System.out.println("Element is clicked");

			return true;

		} catch (NoSuchElementException e) {

			e.printStackTrace();

			Assert.assertTrue(e.getMessage(), false);
		}

		return false;
	}

	//isDisplay
	public static boolean isDisplay(By by) {

		try {

			driver.findElement(by).isDisplayed();

			return true;

		} catch (NoSuchElementException e) {

			e.printStackTrace();

			Assert.assertTrue(e.getMessage(), false);
		}

		return false;
	}
	//get All Links

	public static String getAllLinks(By by) {

		WebElement element = driver.findElement(by);
		List<WebElement> links = element.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement link : links) {

			System.out.println(link.getText());
		}

		return null;
	}

}
