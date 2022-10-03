package com.write.datato.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateNewWorkbookInExistingExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {
/*
 * if you create a new workbook in given excel 
 */
		
//here give the path of excel
File file =new File("F:\\TestData for mvn\\basic sheet.xlsx");
// to get the excel file by using FileInputStream class
FileInputStream fis = new FileInputStream(file);
//by using Workbook interface  createSheet() we create a new sheet
Workbook workbook = new XSSFWorkbook(fis);
//here i have created two worksheet as test 1 and test
Sheet newSheet = workbook.createSheet("test1");
Sheet newSheet1 = workbook.createSheet("test");

//to transfer created sheet obj into excel using FileOutputStream class 

FileOutputStream fos = new FileOutputStream(file);
//you must write object to create
workbook.write(fos);

	}

}
