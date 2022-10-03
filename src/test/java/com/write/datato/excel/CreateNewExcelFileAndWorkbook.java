package com.write.datato.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateNewExcelFileAndWorkbook {

	public static void main(String[] args) throws IOException {


		//here give the path of excel
		File file =new File("C:\\Users\\DELL\\eclipse-workspace\\MavenSeleniumGreen\\TestData for mvn\\basic sheet.xlsx");
		//by using Workbook interface  createSheet() we create a new sheet
		Workbook workbook = new XSSFWorkbook();
		//here i have created two worksheet as test 1 and test
		Sheet newSheet = workbook.createSheet("test1");
		Sheet newSheet1 = workbook.createSheet("test");
		
		//to transfer created sheet obj into excel using FileOutputStream class 
		FileOutputStream fos = new FileOutputStream(file);
		//you must write object to create
		workbook.write(fos);

	}

}
