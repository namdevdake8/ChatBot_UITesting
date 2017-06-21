package com.Abzooba.chatbot.FunctionLibrary;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Abzooba.chatbot.core.TestCore;

import junit.framework.Assert;

public class Keywords extends TestCore {

	//Navigate To
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
			//driver.findElement(by).isEnabled();

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
