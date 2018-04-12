package Test.Jmathi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TableTest {
	protected WebDriver driver;
	
	@BeforeTest
	public void Startbrowser()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",driverpath.getAbsolutePath());
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
	
	@Test
	public void tabletest()
	{
		String innertext=driver.findElement(By.xpath("//table[@width=\"270\"]/tbody/tr[4]/td[1]")).getText();
		System.out.println(innertext);
	}

}
