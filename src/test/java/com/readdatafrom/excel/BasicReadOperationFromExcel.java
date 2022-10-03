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

public class BasicReadOperationFromExcel {
	public static void main(String[] args) throws IOException {
		
/*
 * get objects from the excel file we use FileInputStream -->class
 * if the file is .xls --> we add jxl dependency
 * 
 * if the file is either .xls or .xlsx we add poi-ooxml dependency it will work on both
 *                  the stable version of poi-ooxml is v4.1.2 use after this only
 */
		

/*
 * so our requirement is read the data from excel it may cell or row or column  
 */

		
/*
 * Workbook is an interface having  getSheet() method
 * Sheet is an interface having getRow() method
 * Row is an interface having getCell() method
 * 
 * 
 * if we want to go a particular cell in excel sheet 
 * Workbook(I)-->Sheet(I)-->Row(I)-->Cell(I) this is the way we go by using consultant mtd
 * 
 * Workbook is collections of sheets
 * Workbook is an interface we wont create obj we use particular class
 * and the class is 
 * for .xls -->HSSFWorkbook(class)
 * for .xlsx -->XSSFWorkbook(class)
 */
		

//give path of file
File file = new File("F:\\TestData for mvn\\Select.xlsx");
FileInputStream stream =new FileInputStream(file);
Workbook workBook = new XSSFWorkbook(stream);
/*
 * Workbook interface having getSheet() to get the particular sheet
 */
Sheet sheet = workBook.getSheet("selectdata");//return type is sheet
/*
 * in Sheet interface getRow() is to get row of the sheet
 */
Row row = sheet.getRow(0);//here we pass row index and return type is row
/*
 * in Row interface getCell() is to find particulalr cell value
 */
		Cell cell = row.getCell(0);//here we pass cell index and return type is cell
		System.out.println(cell);
		Cell cell2 = row.getCell(1);
		System.out.println(cell2);
		Cell cell3 = row.getCell(2);
		System.out.println(cell3);//because no data available so null
		
		
		/*
		 * we have to find how many rows contains data in the sheet
		 * inside the sheet we find how many rows contains data 
		 * return type is int
		 * 
		 * if some row not having data after that we have data means it doesnot count
		 * the empty row it count only row having data
		 */
		
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(physicalNumberOfRows);
		/*
		 * we have to find how many column has contains data
		 * for that we go particular row and find that row having how many
		 *  cells(data containing cell only)
		 */
		int physicalNumberOfCells = row.getPhysicalNumberOfCells();
		System.out.println(physicalNumberOfCells);
		
		/*
		 * find particular row all cell values iterate
		 */
		System.out.println("=========================");
		Row row3 = sheet.getRow(2);
	                         //2	
		for(int i=0;i<row3.getPhysicalNumberOfCells();i++) {
			
			Cell cell4 = row3.getCell(i);
			System.out.println(cell4);
		}
		System.out.println("================================");
		/*
		 *to print particular colum only 
		 */
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			Row row2 = sheet.getRow(i);
			Cell cell4 = row2.getCell(0);
		System.out.println(cell4);
		}
		
		/*
		 * iterate both row and column
		 */
		System.out.println("=================================");
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			
			Row row2 = sheet.getRow(i);
			 for(int j=0;j<row2.getPhysicalNumberOfCells();j++) {
				 Cell cell4 = row2.getCell(j);
				 System.out.println(cell4);
			 }
		}
			

	}

}
