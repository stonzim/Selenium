package com.test.utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	int rowCount;
	
	public ExcelConfig(String excelPath) {
		try {
			File file = new File(excelPath);
			FileInputStream fileInputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheetAt(0);
			rowCount = sheet.getLastRowNum() + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readData(int sheetNumber, int row, int column) {
		sheet = workbook.getSheetAt(sheetNumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
}
