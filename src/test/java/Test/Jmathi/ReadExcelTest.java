package Test.Jmathi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ReadExcelTest {
	
		
	@Test
	public void ReadExcel() throws IOException
	{
		 //Create an object of File class to open xlsx file
		File driverpath=new File("C:/Users/IBM_ADMIN/workspace/Jmathi/src/main/java/Utility/Testdata.xlsx");
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputstream=new FileInputStream(driverpath);
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		//Read sheet inside the workbook by its name
		XSSFSheet sheet=workbook.getSheet("data1");
		 //Find number of rows in excel file
		int Rows=sheet.getLastRowNum()+1;
		System.out.println(Rows);
		for(int i=0;i<Rows;i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				String value=row.getCell(j).getStringCellValue();
				System.out.print(value+"|| ");
			}
			System.out.println();
		}
		
				
	}

}
