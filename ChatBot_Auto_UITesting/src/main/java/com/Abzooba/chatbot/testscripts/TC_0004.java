package com.Abzooba.chatbot.testscripts;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Abzooba.chatbot.core.TestCore;
import com.Abzooba.chatbot.util.TestUtil;

public class TC_0004 extends TestCore {

	@BeforeTest
	public void isSkip() throws FileNotFoundException {

		if (!TestUtil.isExecutable("TC_0004")) {

			throw new SkipException("Skipping the test case as the run mode is set to NO");

		}
	}

	@Test(priority = 4, dataProvider = "getData")
	public static void verifySearchForAnItem(String query) {

		System.out.println("---------------------TC_0004------------------------");

		try {

			String Query = query;
			System.out.println("Query====> " + Query);
			WebElement BotInputBox;
			boolean Searched_Result, Searched_ResultText, View_Similar_Btn;

			TC_0003.Search_For_An_Item_Btn = isElementPresentClick(By.xpath(object.getProperty("Search_For_An_Item_Btn")));
			/*TC_0003.Upload_PhotoBtn = isElementPresentClick(By.xpath(object.getProperty("Upload_PhotoBtn")));
			TC_0003.Be_My_Guide_Btn = isElementPresentClick(By.xpath(object.getProperty("Upload_PhotoBtn")));*/

			Thread.sleep(2000);
			BotInputBox = driver.findElement(By.xpath(object.getProperty("BotInputBox")));

			Actions actions = new Actions(driver);

			actions.moveToElement(BotInputBox);

			actions.click();

			actions.sendKeys(Query, Keys.ENTER);

			actions.build().perform();

			Thread.sleep(2000);

			Searched_Result = isDisplay(By.xpath(object.getProperty("Searched_Result")));

			Searched_ResultText = isDisplay(By.xpath(object.getProperty("Searched_ResultText")));

			View_Similar_Btn = isDisplay(By.xpath(object.getProperty("View_Similar_Btn")));

			if (Searched_Result && Searched_ResultText && View_Similar_Btn) {

				System.out.println("Searched Result is successful.");
			}
		} catch (Throwable t) {

			Assert.assertTrue(false, t.getMessage());
		}
	}

	@DataProvider
	public static Object[][] getData() throws FileNotFoundException {
		return TestUtil.getData("TC_0004");
	}

}
