package com.chatbot.utils;

import java.io.FileNotFoundException;

import ChatBot_API.ChatBot_API.TestCore;

public class TestUtil extends TestCore {

	//Read the Data From Excel File

	public static Object[][] getData(String sheetName) throws FileNotFoundException {

		int rows = excel.getRowCount(sheetName);

		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}

		return data;

	}

	/*public static void main(String[] args) throws FileNotFoundException {
	
		getData("Sheet1");
	}*/
}
