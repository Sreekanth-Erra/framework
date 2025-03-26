package testCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC004_Image {
	
	static void Read() throws IOException
	{
	
	FileInputStream file = new FileInputStream ("/framework/testdata/Opencart Testdata_LoginData.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheetAt(0);
	String cellValue = sheet.getRow(1).getCell(0).getStringCellValue();
	System.out.println(cellValue);
	file.close();
	
	}
	

}
