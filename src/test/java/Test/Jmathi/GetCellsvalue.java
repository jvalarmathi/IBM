package Test.Jmathi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCellsvalue {

	protected WebDriver driver;
	
	@BeforeTest
	public void startbrowser()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
	
	@Test
	public void getcellvalueTest()
	{
		int rows=driver.findElements(By.xpath("html/body/table/tbody/tr")).size();
		System.out.println("Total number of Rows are  "+ rows);
		for(int i=1;i<=rows;i++)
		{
			
			int Cellcount=driver.findElements(By.xpath("html/body/table/tbody/tr["+i+"]/td")).size();
			System.out.println(i+"Row cell count' " + Cellcount);
			int cols=driver.findElements(By.xpath("html/body/table/tbody/tr["+i+"]/td")).size();
			for (int j =1; j<=cols;j++)
			{
				String coltext=driver.findElement(By.xpath("html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println("cell Text for "+i+"th"+ "Column" + j+ "  is  " +coltext);
			}
			
		}
		driver.close();
	}
}
