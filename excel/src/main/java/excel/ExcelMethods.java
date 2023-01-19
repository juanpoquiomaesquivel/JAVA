package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

	public ExcelMethods createNewExcelFile(String filePath) {
		try {
			this.xlFilePath = filePath;
			workbook = new XSSFWorkbook();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public void saveAndCloseTheFile() {
		try {
			FileOutputStream out = new FileOutputStream(xlFilePath);
			workbook.write(out);
			out.close();
			System.out.println("Your Excel File Is Written");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeFullExcel(String sheetName, Map<String, Object[]> data) {
		sheet = workbook.createSheet(sheetName);
		Set<String> keyset = data.keySet();
		int rowNumber = 0;

		for (String key : keyset) {
			Row row = sheet.createRow(rowNumber++);
			Object[] objArr = data.get(key);
			int cellNumber = 0;

			for (Object obj : objArr) {
				Cell cell = row.createCell(cellNumber++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}
			}
		}
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

	public void readingSpecificCell(int sheetNumber, int row, int cell) {
		try {
			sheet = workbook.getSheetAt(sheetNumber);
			System.out.println(sheet.getRow(row).getCell(cell));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// How to read in excel using Java(apachi poi) => https://youtu.be/mtDWo4CShM4
// How to write in excel file using Java(Apachi poi). => https://youtu.be/_b1aEkTM91o
// How To Read Specific Cell in Excel using Java(Apachi poi) => https://youtu.be/WWZsbfxVedg