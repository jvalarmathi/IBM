package Test.Jmathi;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class uploadanddownloadfile {
	protected WebDriver driver;
	
	@BeforeTest
		public void startbrowser()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		driver=new ChromeDriver();		
	}
	
	@Test(priority=1)
	public void UploadTest()
	{
		driver.get("http://demo.guru99.com/test/upload/");
		driver.findElement(By.xpath(".//*[@id='uploadfile_0']")).sendKeys("C:\\Users\\IBM_ADMIN\\Desktop\\Regions.xlsx");
		driver.findElement(By.xpath(".//*[@id='terms']")).click();
		driver.findElement(By.xpath(".//*[@id='submitbutton']")).click();
	}
	
	@Test(priority=2)
	public void DownloadTest()
	{
		driver.get("http://demo.guru99.com/test/yahoo.html");
		WebElement download=driver.findElement(By.xpath(".//*[@id='messenger-download']"));
		String sourcelocation=download.getAttribute("href");
		String Wget_command="C:\\Users\\IBM_ADMIN\\workspace\\Jmathi\\src\\main\\java\\Wget\\Wget.exe -P C: --no-check-certificate http://demo.guru99.com/selenium/msgr11us.exe";
		try {
	        Process exec = Runtime.getRuntime().exec(Wget_command);
	        int exitVal = exec.waitFor();
	        System.out.println("Exit value: " + exitVal);
	        } catch (InterruptedException | IOException ex) {
	        System.out.println(ex.toString());
	        }
		
		driver.close();
	}
	

}
