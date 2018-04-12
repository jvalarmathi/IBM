package Test.Jmathi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {
	@Test
	public void WriteExcelTest() throws IOException
	{
		File driverpath=new File("C:/Users/IBM_ADMIN/workspace/Jmathi/src/main/java/Utility/Testdata.xlsx");
		FileInputStream inputstream=new FileInputStream(driverpath);
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		XSSFSheet Sheet=workbook.getSheet("data1");
		int Rows=Sheet.getLastRowNum();
		//Row row1=Sheet.getRow(0);
		Row newrow=Sheet.getRow(Rows+2);
		Cell cell=newrow.createCell(1);
		cell.setCellValue("Write");
		inputstream.close();
		FileOutputStream outputStream = new FileOutputStream(driverpath);
		workbook.write(outputStream);
		 outputStream.close();
		 
		
	}

}
