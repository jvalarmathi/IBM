package Test.Jmathi;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Checkboxloop {
	@Test
	public void checkboxtest()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/radio.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> checkboxes=driver.findElements(By.xpath(".//*[contains(@id,'vfb-6')]"));
		int count=checkboxes.size();
		for(int i=1;i<=count;i++)
		{
			WebElement checkbox=driver.findElement(By.xpath(".//*[contains(@id,'vfb-6')]["+i+"]"));
			checkbox.click();
						if(checkbox.isSelected())
						{
							System.out.println("Checkbox"+ i+" is selected");
						}
						else
						{
							System.out.println("Checkbox"+ i+" is not selected");
						}
		}
		driver.close();
	}

}
