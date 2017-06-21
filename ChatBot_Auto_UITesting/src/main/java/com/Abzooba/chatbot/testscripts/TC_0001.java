package com.Abzooba.chatbot.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Abzooba.chatbot.core.TestCore;
import com.Abzooba.chatbot.util.TestUtil;

public class TC_0001 extends TestCore {

	//Executable Method
	@BeforeTest
	public void isSkip() throws FileNotFoundException {

		if (!TestUtil.isExecutable("TC_0001")) {

			throw new SkipException("Skipping the test case as the run mode is set to NO");

		}
	}

	@Test(priority = 1, dataProvider = "getData")
	public static void chatBotLaunched(String PageTitle) throws IOException {
		System.out.println("---------------------TC_0001------------------------");
		app_logs.debug("Executing chatbotLaunched()");

		try {

			String expectedPageTitle = PageTitle;
			String actualPageTitle = driver.getTitle();

			if (expectedPageTitle.equals(actualPageTitle)) {

				System.out.println("Expected Page Title is: " + expectedPageTitle);
				System.out.println("Actual Page Title is: " + actualPageTitle);
				System.out.println("Verification Successful - The correct title is displayed on the web page.");
			}

		} catch (Throwable t) {

			Assert.assertTrue(false, t.getMessage());
		}
	}

	@DataProvider
	public static Object[][] getData() throws FileNotFoundException {
		return TestUtil.getData("TC_0001");
	}
}
