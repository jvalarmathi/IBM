package Test.Jmathi;

import java.io.File;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowPopup {
	protected WebDriver driver;

	@BeforeTest
	public void startbrowser()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
	
	@Test
	public void WindowpopupTest()
	{
		driver.findElement(By.xpath(".//*[contains(text(),'Click Here')]")).click();
		String Mainwindow = driver.getWindowHandle();
		Iterator<String> it=driver.getWindowHandles().iterator();
		
		while(it.hasNext())
		{
			String Childwindow=it.next();
			if(!Mainwindow.equalsIgnoreCase(Childwindow))
			{
				driver.switchTo().window(Childwindow);
				driver.findElement(By.name("emailid")).sendKeys("testggd2gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				driver.close();
			}
			driver.switchTo().window(Mainwindow);
		}
		driver.close();
	}
}
