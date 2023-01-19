package excel;

public class ExcelMainClass {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\juanp\\Escritorio\\Java\\excel\\test.xlsx";
		ExcelMethods readExcel = new ExcelMethods();
		readExcel.useExistingWorkbook(filePath);
		readExcel.readFullExcelFile(0);
	}
}
