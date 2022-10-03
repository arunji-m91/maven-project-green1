package com.write.datato.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TaskPrintSelectOptionoExcel {
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		File file =new File("F:\\TestData for mvn\\Select.xlsx");
		
		Workbook workbook =new XSSFWorkbook();
		Sheet createSheet = workbook.createSheet("selectdata");
		//Row createRow = createSheet.createRow(0);
		//Cell createCell = createRow.createCell(0);
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omrbranch.com/apitestingtraininginchennaiomr");
		WebElement drpDown = driver.findElement(By.xpath("//select[@id='skills']"));
		Select select = new Select(drpDown);
		List<WebElement> allDropDown = select.getOptions();
		
		for(int i=0;i<allDropDown.size();i++) {
			String text = allDropDown.get(i).getText();
			Row row = createSheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(text);
			FileOutputStream fos=new FileOutputStream(file);
			workbook.write(fos);
			
		}
		
	}

}
