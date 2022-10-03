package com.baseclass;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static  WebDriver driver;

	// basic
	// 1
	public static WebDriver getDriver(String driverName,String url) {
		if(driverName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
		}
		else if(driverName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(url);
		}
		else if(driverName.equalsIgnoreCase("ie")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.get(url);
		}
		return driver;
		
	}

	// 2
	public  void sendUrl(String url) {
		driver.get(url);
	}

	// 3
	public void maxWindow() {
		driver.manage().window().maximize();
	}

	// 4
	public void elementClick(WebElement element) {
		element.click();
	}

	// 5
	public String getTextFromElement(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 6
	public String getAttributeValueFromElement(WebElement element) {
		String value = element.getAttribute("value");
		return value;
	}

	// 7
	public String getParticularAttributeValue(WebElement element, String attributeName) {
		String value = element.getAttribute(attributeName);
		return value;
	}

	// 8
	// locators
	public WebElement findLocatorById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public WebElement findLocatorByClassName(String AttributeValue) {
		WebElement element = driver.findElement(By.className(AttributeValue));
		return element;
	}

	// 9
	public WebElement findLocatorByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	// 10
	public WebElement findLocatorByXpath(String xpath) {

		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	// 11
	public List<WebElement> findMultipleWebElement(String xpath) {
		List<WebElement> findElements = driver.findElements(By.xpath(xpath));
		return findElements;
	}

	// 12
	public static void sendTo(WebElement element, String text) {
		element.sendKeys(text);
	}

	// js
	// 13
	public void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// 14
	public void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// 15
	public void sendToTextboxByJs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
	}

	// 16
	public String getAttributeByJs(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object executeScript = js.executeScript("return arguments[0].getAttribute('value')", element);
		String text = (String) executeScript;
		return text;
	}

	// 17
	// dropdown related
	public void dropDownSelect(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 18
	public void dropDownSelect(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	// 19
	public void dropDownSelect(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// 20
	public List<WebElement> dropDownAllPresentValues(WebElement element) {
		ArrayList<String> al = new ArrayList<String>();
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;

	}

	// 21

	public void dragAndDropOperation(WebElement source, WebElement destination) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).perform();
	}

	// 22
	public void moveToParticularElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// 23
	public void moveToParticularElementAndClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	// 24
	public void moveToParticularElementAndRightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).contextClick().perform();

	}

	// 25
	public void moveToParticularElementAndDoubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).doubleClick().perform();

	}

	// 26
	public static void sendToTextBoxAndEnter(WebElement element, String text) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, "" + text + "", Keys.ENTER).perform();
	}

	// 27
	public void sendToTextByActions(WebElement element, String text) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, text).perform();
	}

	// 28
	public void captureThePage(String path, String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(path, fileName + ".png");
		file.createNewFile();
		FileUtils.copyFile(screenshotAs, file);
	}

	// to store in same directory
	public void captureThePageAutoSaveToDir(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\" + fileName + ".png");
		file.createNewFile();
		FileUtils.copyFile(screenshotAs, file);
	}

	// 29
	// window related
	public String getWindowTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 30
	public String getParentId() {
		String parentId = driver.getWindowHandle();
		return parentId;
	}

	// 31
	public Set<String> getAllWindowId() {
		Set<String> allId = driver.getWindowHandles();
		return allId;
	}

	// 32
	public void backToMainWindow() {
		driver.switchTo().defaultContent();
	}

	// 33
	public void switchToWindowByTitle(String windowTitle) {
		driver.switchTo().window(windowTitle);
	}

	// 34
	public void switchToWindowByUrl(String url) {
		driver.switchTo().window(url);
	}

	// 35
	public static void acceptPopUp() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// 36
	public void dismissPopUp() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// 37
	public void sendTextToPopUpAndOk(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}

//	 public void sendUserAndPassToPopUpAndOk(String url,String userName,String
//	 passWord) {
//	
//	 StringBuilder sb = new StringBuilder(url);
//	 sb.append(userName, 7, end)
//	 }

	public String getTextFromPopUp() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}

	// excel operations
	// read cell from excel
	public String readFromXlOt(String pathOfTheFile, String fileName, String workBookName, int rowNum, int cellNum)
			throws IOException {

		File file = new File(pathOfTheFile, fileName + ".xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(workBookName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		String data = "";
		switch (type) {
		case STRING:
			data = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				data = s.format(dateCellValue);
			}

			else {
				double d = cell.getNumericCellValue();
				long round = Math.round(d);
				BigDecimal b = BigDecimal.valueOf(d);
				data = b.toString();
			}

		default:
			break;

		}
		return data;
	}

	// read cell from excel in same direcory files
	public static String readFromXl(String fileName, String workBookName, int rowNum, int cellNum)
			throws IOException {

		File file = new File(System.getProperty("user.dir"), fileName + ".xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(workBookName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		String data = "";
		switch (type) {
		case STRING:
			data = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				data = s.format(dateCellValue);
			}

			else {
				double d = cell.getNumericCellValue();
				long round = Math.round(d);
				BigDecimal b = BigDecimal.valueOf(d);
				data = b.toString();
			}

		default:
			break;

		}
		return data;
	}

	// write data to excel and return old value
	public String compareXCellWriteOt(String path, String fileName, String sheet, int rowNum, int cellNum,
			String writeData) throws IOException {
		File file = new File(path, fileName + ".xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet2 = workbook.getSheet(sheet);
		Row createRow = sheet2.getRow(rowNum);
		Cell cell = createRow.getCell(cellNum);
		CellType type = cell.getCellType();
		String data = "";

		switch (type) {
		case STRING:
			data = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				data = s.format(dateCellValue);
			}

			else {
				double d = cell.getNumericCellValue();
				BigDecimal b = BigDecimal.valueOf(d);
				data = b.toString();
			}
			break;

		default:
			break;

		}
		if (writeData.equals(data)) {
			System.out.println("you try to write data is same in that cell");

		} else {
			cell.setCellValue(writeData);
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
		}
		return data;

	}

	//// write data to excel and return old value same dir

	public String compareXCellWriteDir(String fileName, String sheet, int rowNum, int cellNum,

			String writeData) throws IOException {
		File file = new File(System.getProperty("user.dir"), fileName + ".xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet2 = workbook.getSheet(sheet);
		Row createRow = sheet2.getRow(rowNum);
		Cell cell = createRow.getCell(cellNum);
		CellType type = cell.getCellType();
		String data = "";

		switch (type) {
		case STRING:
			data = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				data = s.format(dateCellValue);
			}

			else {
				double d = cell.getNumericCellValue();
				BigDecimal b = BigDecimal.valueOf(d);
				data = b.toString();
			}
			break;

		default:
			break;

		}
		if (writeData.equals(data)) {
			System.out.println("you try to write data is same in that cell");

		} else {
			cell.setCellValue(writeData);
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
		}
		return data;

	}

	// create new cell and insert
	public void writeCellOt(String path, String sheetName, int rowNum, int cellNum, String writeData)
			throws IOException {
		File file = new File(path, sheetName + ".xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row createRow = sheet.getRow(rowNum);
		Cell cell = createRow.createCell(cellNum);
		cell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);

	}

	// create new cell and insert in same dir
	public static void writeNewCellDir(String fileName, String sheetName,int rowNum, int cellNum, String writeData)
			throws IOException {
		File file = new File(System.getProperty("user.dir"), fileName + ".xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row createRow = sheet.createRow(rowNum);
		Cell cell = createRow.createCell(cellNum);
		cell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);

	}

	// create new Excel Sheet new cell and new row
	public void createXlCellWriteOt(String path, String fileName, String newSheetName, int rowNum, int cellNum,
			String writeData) throws IOException {

		File file = new File(path, fileName + ".xlsx");
		file.createNewFile();
		Workbook workbook = new XSSFWorkbook();
		Sheet newSheet = workbook.createSheet(newSheetName);
		Row cell = newSheet.createRow(rowNum);
		Cell createCell = cell.createCell(cellNum);
		createCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
	}

	// create new Excel Sheet new cell and new row
	public void createXlCellWriteDir(String fileName, String newSheetName, int rowNum, int cellNum,
			String writeData) throws IOException {

		File file = new File(System.getProperty("user.dir"), fileName + ".xlsx");
		file.createNewFile();
		Workbook workbook = new XSSFWorkbook();
		Sheet newSheet = workbook.createSheet(newSheetName);
		Row cell = newSheet.createRow(rowNum);
		Cell createCell = cell.createCell(cellNum);
		createCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
	}
	
	
//	public void insertValueInCellsSameDir(String fileName,String sheetName,int enterRowNum,int cellCount,List<String> variable) throws IOException {
//		File file = new File(System.getProperty("user.dir"),fileName+".xlsx");
//		FileInputStream fis = new FileInputStream(file);
//		Workbook workbook = new XSSFWorkbook(fis);
//		Sheet sheet = workbook.getSheet(sheetName);
//		Row newRow = sheet.createRow(enterRowNum);
//		for(int i=0;i<cellCount;i++) {
//			Cell createCell = newRow.createCell(i);
//			//createCell.setCellValue(variable); 
//			
//		}
//		newRow.createCell(cellCount);
		
		
//}
	
	
	
	
	
	
	
	
	

	public static void toCloseWindow() {
		driver.close();
	}

	public void toCloseAllWindow() {
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		BaseClass b = new BaseClass();

	}

}
