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

public class BasicReadOperationDatePhoneNum2 {
/*
 * in first program to check the cell contains text or phonenumber format if it is 
 * in date format means it doesnot work for that  
 * we add if statement in numeric case because date is also contains numeric value
 * and we change into our portable date format 
 */
	public static void main(String[] args) throws IOException {
		File file =new File("F:\\\\TestData for mvn\\\\phonenumdate format.xlsx");
		FileInputStream stream =new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("test1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);//here we assume this cell is dateformat
		
		CellType cellType = cell.getCellType();
		switch(cellType){
		case STRING :                 //date format so it not execute
			//2 getStringCellValue() 
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
			break;
		case NUMERIC : //date is also numeric so it excecute
				if(DateUtil.isCellDateFormatted(cell)) {    
					/*
					 * cell is date formated so execute
					 * even the cell is not date formated but the value present
					 * in that cell is date formated also it take no problem
					 */
					//4 getDateCellValue(); return type -->Date
					Date dateCellValue = cell.getDateCellValue();
					System.out.println(dateCellValue);//o/p -->Sat May 28 00:00:00 IST 2022
					/*
					 * o/p this format of date you dont want you can change your
					 * prefered format using SimpleDateFormat -->class
					 */
					SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MMM/yyyy");
					/*
					 * dd(small letter -->refers date
					 * MM(must capital otherwise it take as minues)
					 * MM -->month in number format like 05 ,04 03 
					 * MMM -->month in letter format like Aug , may..
					 * yyyy(small letter) -->like 2022 , 1991 ..
					 * yy(small) -->like last two digit of year 
					 */
					String format = dateFormat.format(dateCellValue);
					System.out.println(format);//o/p -->28/05/22
				}
			
			else { //cell is date formated so it doesnot execute
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
}
