package Test.Jmathi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class keyboardandmouseevent {
	protected WebDriver driver;
	@BeforeTest
	public void startbrowser()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}

	@Test
	
	public void keyboardtest()
	{
		WebElement link_home=driver.findElement(By.xpath(".//*[contains(text(),'Home')]"));
		WebElement box=driver.findElement(By.xpath("//table[@width=\"110\"]/tbody/tr/td[1]/table/tbody/tr[1]/td[1]"));
		Actions builder=new Actions(driver);
		Action move=builder.moveToElement(link_home).build();
		String bgcolor=box.getCssValue("background-color");
		System.out.println("Back-ground color is  "+ bgcolor);
		move.perform();
		String bgcolor1=box.getCssValue("background-color");
		System.out.println("Back-ground color is  "+ bgcolor1);
		driver.close();
		
	}
}
