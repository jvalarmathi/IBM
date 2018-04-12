package Test.Jmathi;

import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TableRowsandColumns {
protected WebDriver driver;
@BeforeTest
public void Browserstart()
{
	File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
	driver=new ChromeDriver();
	driver.get("http://money.rediff.com/gainers/bsc/daily/groupa");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test
 public void RowsColumnsTest() throws ParseException
 {
	 List<WebElement> col=driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
	 int columns= col.size();
	 double r=0,m=0;
	 System.out.println("No.of.Columns : " + columns);
	 List<WebElement> row=driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr"));
	 int rows=row.size();
	 System.out.println("No.of.Rows : " + rows);
	 for(int i=1;i<rows;i++)
	 {
		 String value= driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr["+i+"]/td[3]")).getText();
		 NumberFormat f=NumberFormat.getNumberInstance();
		 Number num=f.parse(value);
		 value=num.toString();
		 m=Double.parseDouble(value);
		 if(m>r)
		 {
			 r=m;
		 }
		 		
	 }
	 System.out.println("Maximum current price is : "+ r);
	 driver.close();
 }
  
}
