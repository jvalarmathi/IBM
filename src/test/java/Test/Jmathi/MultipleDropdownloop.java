package Test.Jmathi;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultipleDropdownloop {
	@Test
	public void dropdowntest()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		WebDriver driver=new ChromeDriver();
		driver.get("http://output.jsbin.com/osebed/2");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> list=driver.findElements(By.xpath(".//*[@id='fruits']/option"));
		int count= list.size();
		for(int i=0;i<count;i++)
		{
			Select DD= new Select(driver.findElement(By.xpath(".//*[@id='fruits']")));
			DD.selectByIndex(i);
					}
		driver.close();
	}

}
