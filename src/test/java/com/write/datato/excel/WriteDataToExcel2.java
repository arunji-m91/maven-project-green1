package com.write.datato.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel2 {

	public static void main(String[] args) throws IOException {
/*
 * write data to empty cell in excel
 * if the row 3 cell having value if you insert value in another empty cell in that row 
 * that 3 cell value is overrided which means delete and added we given value only 
 * 
 * 
 * but incase of column it not delete any other add value to given empty column
 */
File file = new File("F:\\TestData for mvn\\basic operation.xlsx");
FileInputStream stream = new FileInputStream(file);
Workbook workbook = new XSSFWorkbook(stream);
Sheet sheet = workbook.getSheet("InsertValueInCell");
Row row = sheet.createRow(0);
Cell cell = row.createCell(3);
cell.setCellValue("check1");
FileOutputStream fos = new FileOutputStream(file);
workbook.write(fos);
	}

}
