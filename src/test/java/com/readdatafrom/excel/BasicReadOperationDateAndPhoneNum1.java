package com.readdatafrom.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BasicReadOperationDateAndPhoneNum1 {

	public static void main(String[] args) throws IOException {
		/*
		 * In first basic, we read data from the particular cell or 
		 * entire row or entrie colum like that
		 * 
		 *  here we check the particular cell having which type of data
		 * if the cell have phone number,date,password or formula anything
		 * in any case it is either STRING or NUMERIC
		 * String means that cell contains text
		 * Numeric means that cell contains number 
		 * 
		 *  Cell --Interface methods uses
		 *  1 getCellType(); return type is CellType(Ennum)
		 *  find either the cell is STRING or NUMERIC 
		 *  find the cell type by using the above  method.
		 * 
		 *  2 getStringCellValue() return type is String
		 *  if the cell is string get text value from the cell using 
		 *  getStringCellValue()
		 * 
		 * 3 getNumericCellValue()
		 * if the cell  having numeric value get the numeric value using this mtd
		 * 
		 * if the cell have in date formatted see in next program
		 * here the cell contain date format ouput came but not in date format
		 * output as comes like this (44706.0)
		 */
		
		
		File file =new File("F:\\\\TestData for mvn\\\\phonenumdate format.xlsx");
		FileInputStream stream =new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("test1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		/*
		 * (here i  put phone number in that mentioned cell)
		 * if we see the cell in excel whether which is text, date format or phone number
		 * or some formulas  something
		 * how we find without seeing in excel using getCellType()
		 * 
		 * given switch case we check that cell contains either text or number 
		 * if number means it goes case NUMERIC
		 * and excute the given steps
		 * */
		
		//1 use getCellType() to find type of the cell
		CellType cellType = cell.getCellType();
		switch(cellType){
		case STRING : 
			//2 getStringCellValue() 
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
			break;
		case NUMERIC : 
	/*	here this exceute only the cell having phone num like value(if it is in date format
	 * here we add if statement,if the cell is date format it goes inside if are goes else part
	 * that i writet in next program
	 */
			//3 getNumericCellValue()
			double numericCellValue = cell.getNumericCellValue();
			System.out.println(numericCellValue);// o/p decimal value not original
			BigDecimal b=BigDecimal.valueOf(numericCellValue);
			System.out.println(b);//o/p exact number in that cell
			String string = b.toString();
			System.out.println(string);//o/p exact number in that cell
			break;
		}
	}

}
