package Test.Jmathi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizationwithTesgNGxml {
	protected WebDriver driver;
	@BeforeTest
	public void ParameterizationTest()
	{
		File driverpath=new File ("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
	}
	@Test
	@Parameters({"author","searchkey"})
	public void ParametrizationwithTesgNGxmlTest(@Optional("ABC") String author, String searchkey)
	{
		driver.findElement(By.id("lst-ib")).sendKeys(searchkey);
		System.out.println(searchkey);
		
	}
}
