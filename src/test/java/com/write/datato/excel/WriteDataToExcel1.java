package com.write.datato.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel1 {

	public static void main(String[] args) throws IOException {
		/*
		 * replace cell value(the cell is already contains value)
		 * need to insert value in particular cell
		 * 1 directly insert value into cell(if cell contains old value that is replaced)
		 *     (i)get the data from the cell 
		 *     (ii)check the equality of cell data
		 *     (iii)insert values 
		 */
		/*
		 * in excel ,InsertValueInCell sheet there  , in this zero th row and zero th colum "java"
		 * is there we will replace "java" into oracle
		 */
		
		/*
		 * Cell interface --> setCellValue() use this method
		 * after replace you must save either same file or different file
		 * for that 
		 * Workbook -->interface  write() whenever update done must write into workbook
		 */
		File file = new File("F:\\TestData for mvn\\basic operation.xlsx");
		FileInputStream stream =new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet("InsertValueInCell");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(cell);//here we find stringCellValue() after compare 
		String stringCellValue = cell.getStringCellValue();
		if(stringCellValue.equals("java")) {
			cell.setCellValue("Oracle");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		}
		
	}
	}


