package Test.Jmathi;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Siblingxpath {
	protected WebDriver driver;
	
	@BeforeTest
	public void startbrowser()
		{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/guru99home/");
		
	}
	
@Test
public void siblinxpathTest()
{

	List<WebElement>datebox=driver.findElements(By.xpath("//h2[contains(text(),'A few of our most popular courses')]/parent::div//div[//a[text()='SELENIUM']]/following-sibling::div[@class='rt-grid-2 rt-omega']"));
	System.out.println(datebox.size());
	for (WebElement webElement : datebox) {
        System.out.println(webElement.getText());
    }    
	driver.close();
}

}
