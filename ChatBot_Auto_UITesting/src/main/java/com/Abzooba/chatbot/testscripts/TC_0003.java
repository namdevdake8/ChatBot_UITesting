package com.Abzooba.chatbot.testscripts;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Abzooba.chatbot.core.TestCore;
import com.Abzooba.chatbot.util.TestUtil;

public class TC_0003 extends TestCore {

	static boolean Flag_search_box, JeanieExp_Icon, Get_Started_Btn;
	static boolean Search_For_An_Item_Btn, Upload_PhotoBtn, Offers_Image, Show_Best_OfferBtn,
			Be_My_Guide_Btn;

	@BeforeTest
	public void isSkip() throws FileNotFoundException {

		if (!TestUtil.isExecutable("TC_0003")) {

			throw new SkipException("Skipping the test case as the run mode is set to NO");

		}
	}

	@Test(priority = 3, dataProvider = "getData")
	public static void verifyChatBotFlow(String BotName) {

		//TC_0002.doLogin("9762209313","namdevdake");
		System.out.println("---------------------TC_0003------------------------");
		try {

			String actual_App_Title, expected_App_Title;

			expected_App_Title = BotName;

			/*Flag_search_box = isElementPresent(By.xpath(object.getProperty("Flag_search_box")));

			driver.findElement(By.xpath(object.getProperty("Flag_search_box"))).sendKeys(BotName, Keys.ENTER);
			Thread.sleep(2000);

			JeanieExp_Icon = isElementPresent(By.xpath(object.getProperty("JeanieExp_App")));

			driver.findElement(By.xpath(object.getProperty("JeanieExp_App"))).click();

			Thread.sleep(2000);*/

			actual_App_Title = driver.findElement(By.xpath(object.getProperty("App_Title"))).getText();

			Get_Started_Btn = isElementPresent(By.xpath(object.getProperty("Get_Started_Btn")));

			driver.findElement(By.xpath(object.getProperty("Get_Started_Btn"))).click();

			Search_For_An_Item_Btn = isElementPresent(By.xpath(object.getProperty("Search_For_An_Item_Btn")));

			Upload_PhotoBtn = isElementPresent(By.xpath(object.getProperty("Upload_PhotoBtn")));

			Be_My_Guide_Btn = isElementPresent(By.xpath(object.getProperty("Be_My_Guide_Btn")));

			Show_Best_OfferBtn = isElementPresent(By.xpath(object.getProperty("Show_Best_OfferBtn")));

			Offers_Image = isElementPresent(By.xpath(object.getProperty("Offers_Image")));

			if (Offers_Image && Show_Best_OfferBtn && Be_My_Guide_Btn) {

				System.out.println("All Buttons are present in the bot");
			}
			if (Search_For_An_Item_Btn && Flag_search_box && actual_App_Title.equals(expected_App_Title)) {

				System.out.println("Verification Successful - The correct App_Title " + expected_App_Title + " is displayed in the Bot");

				System.out.println("Upload_PhotoBtn,Be_My_Guide_Btn,are present");
			} else {
				System.out.println("Error! All Elements are not present in the bot");
			}
		} catch (Throwable t) {

			Assert.assertTrue(false, t.getMessage());
		}

	}

	@DataProvider
	public static Object[][] getData() throws FileNotFoundException {
		return TestUtil.getData("TC_0003");
	}
}
