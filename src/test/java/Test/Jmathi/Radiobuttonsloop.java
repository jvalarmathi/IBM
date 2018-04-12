package Test.Jmathi;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Radiobuttonsloop {
	
	@Test
	public void Radiotest()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/radio.html");
		List<WebElement> radios=driver.findElements(By.xpath(".//*[contains(@id,'vfb-7')]"));
		System.out.println(radios.size());
		int count=radios.size();
		
		for(int i=1;i<=count;i++)
		{
			driver.findElement(By.xpath(".//*[contains(@id,'vfb-7')]["+i+"]")).click();
		}
		driver.close();
	}

}
