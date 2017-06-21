package com.Abzooba.chatbot.testscripts;

import java.io.FileNotFoundException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Abzooba.chatbot.core.TestCore;
import com.Abzooba.chatbot.util.TestUtil;

public class TC_0002 extends TestCore {

	@BeforeTest
	public void isSkip() throws FileNotFoundException {

		if (!TestUtil.isExecutable("TC_0002")) {

			throw new SkipException("Skipping the test case as the run mode is set to NO");

		}
	}

	@Test(priority = 2, dataProvider = "getData")
	public static void doLogin(String UserID, String Password) {

		System.out.println("---------------------TC_0002------------------------");
		try {

			String userEmailId = UserID;
			String userPassword = Password;

			String expectedPageText = "Messenger";

			boolean userID_TextBox, userPass_TextBox, continueBtn;

			userID_TextBox = isElementPresent(By.xpath(object.getProperty("userEmailID")));

			driver.findElement(By.xpath(object.getProperty("userEmailID"))).sendKeys(userEmailId);

			userPass_TextBox = isElementPresent(By.xpath(object.getProperty("userPassword")));

			driver.findElement(By.xpath(object.getProperty("userPassword"))).sendKeys(userPassword);

			continueBtn = isElementPresent(By.xpath(object.getProperty("continueBtn")));

			driver.findElement(By.xpath(object.getProperty("continueBtn"))).click();

			String actualPageText = driver.findElement(By.xpath(object.getProperty("PageText"))).getText();

			if (expectedPageText.equals(actualPageText) && userID_TextBox && userPass_TextBox && continueBtn) {

				System.out.println("Verification Successful - The correct Text is displayed on the web page.");

				System.out.println(driver.getTitle() + " page is launched successfully");

			} else {
				System.out.println(driver.getTitle() + " page is not launched successfully");
			}
		} catch (Throwable t) {

			Assert.assertTrue(false, t.getMessage());
		}

	}

	@DataProvider
	public static Object[][] getData() throws FileNotFoundException {
		return TestUtil.getData("TC_0002");
	}
}
