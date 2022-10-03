package workout.only;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InsertValueInParticularCellExistingSheet {

	public static void main(String[] args) throws IOException {
		File file =new File("C:\\Users\\DELL\\eclipse-workspace\\MavenSeleniumGreen\\TestData for mvn\\basic sheet.xlsx");

		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheet("test1");
		Row row = sheet.createRow(4);
		Cell cell = row.createCell(2);
		cell.setCellValue("testing");

		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
	}

}
