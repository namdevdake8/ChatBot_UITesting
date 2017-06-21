package com.Abzooba.chatbot.util;

import java.io.FileNotFoundException;

import com.Abzooba.chatbot.core.TestCore;

public class TestUtil extends TestCore {

	public static boolean isExecutable(String TCID) throws FileNotFoundException {

		/*SEPARATOR = System.getProperty("SEPARATOR", "\t").charAt(0);
		 CSVReader reader = new CSVReader(new FileReader(TestCore.QUERY_FILEPATH_COMPARISON), TestCore.SEPARATOR, CSVParser.NULL_CHARACTER, 1);
		*/
		String sheetName = "TestSuite";

		for (int rowNum = 2; rowNum <= excel.getRowCount(sheetName); rowNum++) {
			if (excel.getCellData(sheetName, "TCID", rowNum).equals(TCID)) {
				if (excel.getCellData(sheetName, "RUNMODE", rowNum).equals("Y")) {
					return true;
				} else {
					return false;
				}
			}

		}

		return false;
	}

	//Read the Data From Excel File
	//public static ExcelReader excel = new ExcelReader("D:\\ChatbotTesting\\ChatBot_Auto_UITesting\\src\\main\\java\\com\\Abzooba\\chatbot\\properties\\ChatBot_TestData.xlsx");

	public static Object[][] getData(String sheetName) throws FileNotFoundException {

		/*SEPARATOR = System.getProperty("SEPARATOR", "\t").charAt(0);
		
		CSVReader reader = new CSVReader(new FileReader(TestCore.QUERY_FILEPATH_COMPARISON), TestCore.SEPARATOR, CSVParser.NULL_CHARACTER, 1);
		sheetName = "Test_Suite1";
		return null;
		*/
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
	
		getData("TC_0001");
	}*/
}
