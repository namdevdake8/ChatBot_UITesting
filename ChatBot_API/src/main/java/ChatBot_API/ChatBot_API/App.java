package ChatBot_API.ChatBot_API;

import java.io.IOException;

import Utils.ExcelReader;

/**
 * Hello world!
 *
 */
public class App {

	public static ExcelReader excel = new ExcelReader("D:\\ChatbotTesting\\ChatBot_API\\src\\main\\java\\Properties\\ChatBotInputData.xlsx");

	public static Object[][] getData(String sheetName) {

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows][cols];

		System.out.println("Sr.No|Que|Color|Price |Gen |Des | Brand |Entity|Size");
		System.out.println("====================================================");
		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				System.out.print(data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum) + "  ");
			}
		}
		return data;
	}

	/*public static void writeXLSXFile(String sheetName) throws IOException {
	
		String excelFileName = "D:/ChatbotTesting/ChatBot_API/src/main/java/ChatBot_API/ChatBot_API/ChatBotOtput.xlsx";//name of excel file
	
		//String sheetName = "Output";//name of sheet
	
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName);
	
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		//iterating r number of rows
	
		for (int r = 0; r <= 2; r++) {
			XSSFRow row = sheet.createRow(r);
	
			//iterating c number of columns
			for (int c = 0; c < 9; c++) {
				XSSFCell cell = row.createCell(c);
	
				cell.setCellValue("Cell " + r + " " + c);
	
				//System.out.println(excel.getCellData(sheetName, c, r));
	
				//cell.setCellValue(excel.getCellData(sheetName, c, r));
			}
		}
	
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
	
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}*/

	public static void main(String[] args) throws IOException {

		getData("Input");

		//	writeXLSXFile("Output");
	}
}
