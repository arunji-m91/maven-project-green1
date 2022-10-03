package com.readdatafrom.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TaskBasicReadOperation {

	public static void main(String[] args) throws IOException {
		
		File file=new File("F:\\TestData for mvn\\basic operation.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workBook=new XSSFWorkbook(stream);
		Sheet sheet = workBook.getSheet("Task");
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			Row row = sheet.getRow(i);
			
			for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
				Cell cell = row.getCell(j);
				System.out.println(cell);
			}
			System.out.println();
		}
		
		
	}

}
