package com.chatbot.testscripts;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.chatbot.pojoclass.GetQueries;
import com.chatbot.utils.EndpointURL;
import com.chatbot.utils.URL;
import com.chatbot.webservices.methods.Webservices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;

import ChatBot_API.ChatBot_API.TestCore;

public class TC_001 extends TestCore {

	Response response;

	/*ArrayList<String> brand;*/

	@BeforeClass
	public void setup() {

	}

	@Test(priority = 1)
	public void verifyGetQueries() throws JsonProcessingException, IOException {

		Gson gson = new GsonBuilder().create();
		GetQueries[] getQueries;
		String url = URL.fixURL + EndpointURL.GET_QUERY.getResourcePath();
		System.out.println(url);

		response = Webservices.Get(url);

		if (response.getStatusCode() == 200) {
			getQueries = gson.fromJson(response.getBody().asString(), GetQueries[].class);

			for (int i = 0; i < getQueries.length; i++) {

				System.out.println(getQueries[i].getClientId());
			}
		}
		/*String jSonData = response.getBody().asString();
		
		System.out.println("JSON Data: " + jSonData);
		String sheetName = "Sheet1";
		Object exceldata = null;
		int rows = excel.getRowCount(sheetName);
		
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows - 1][cols];
		
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
		
				exceldata = data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				if (jSonData.contains((CharSequence) exceldata)) {
		
					System.out.println("Validate: " + exceldata);
				}
			}
		}*/

	}
}
