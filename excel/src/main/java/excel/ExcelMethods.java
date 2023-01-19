package excel;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelMethods {

	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private String xlFilePath;

	public ExcelMethods() {
		// Do nothing
	}

	public ExcelMethods useExistingWorkbook(String filePath) {
		try {
			this.xlFilePath = filePath;
			file = new FileInputStream(xlFilePath);
			workbook = new XSSFWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public void readFullExcelFile(int sheetNumber) {
		try {
			sheet = workbook.getSheetAt(sheetNumber);
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					}
				}

				System.out.println();
			}

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// How to read in excel using Java(apachi poi) => https://youtu.be/mtDWo4CShM4