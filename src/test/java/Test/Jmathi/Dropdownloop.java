package Test.Jmathi;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dropdownloop {
	@Test
	public void dropdowntest()
	{
	File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
    WebDriver driver= new ChromeDriver();
    driver.get("http://demo.guru99.com/test/newtours/register.php");
    List<WebElement> country=driver.findElements(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select/option"));
    int count=country.size();
    System.out.println(count);
    for(int i=1;i<=count;i++)
    {
    	String countries=driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select/option["+i+"]")).getText();
        System.out.println(countries);
    }
    driver.close();
	}
  
}
