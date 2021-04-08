package com.test.utilities;

import java.util.ArrayList;

public class ExcelReader {
	ExcelConfig reader;
	ArrayList<Object[]> cells;

	public ArrayList<Object[]> getData() {
		reader = new ExcelConfig(
				"/Users/winston/Desktop/AutoWorkspace/MavenAutomation/src/test/resources/DataProviders/PositiveLogin/testData.xlsx");
		cells = new ArrayList<Object[]>();
		for (int i = 1; i < reader.rowCount; i++) {
			Object[] objects = new Object[reader.rowCount];
			for (int j = 0; j < 2; j++) {
				objects[j] = reader.readData(0, i, j);
			}
			cells.add(objects);
		}
		return cells;
	}
}
