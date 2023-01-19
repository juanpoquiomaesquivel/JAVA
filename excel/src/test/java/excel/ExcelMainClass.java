package excel;

import java.util.Map;
import java.util.TreeMap;

public class ExcelMainClass {

	public static void main(String[] args) {

		String filePath = "C:\\Users\\juanp\\Escritorio\\Java\\excel\\test.xlsx";
		/*
		 * ExcelMethods readExcel = new ExcelMethods();
		 * readExcel.useExistingWorkbook(filePath); readExcel.readFullExcelFile(0);
		 */

		Map<String, Object[]> data = new TreeMap<>();
		data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
		data.put("2", new Object[] { 1, "Shahil", "Kumar" });
		data.put("3", new Object[] { 2, "Ayush", "Prajapati" });
		data.put("4", new Object[] { 3, "Sanjay", "Pandit" });

		ExcelMethods writingExcel = new ExcelMethods();
		writingExcel.createNewExcelFile(filePath);
		writingExcel.writeFullExcel("NameOfPeople", data);
		writingExcel.saveAndCloseTheFile();
	}
}
