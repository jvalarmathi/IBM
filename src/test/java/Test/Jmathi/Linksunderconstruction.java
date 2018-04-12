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

public class Linksunderconstruction {
	
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
	public void LinkunderconstuctionTest() throws InterruptedException
	{
		List<WebElement> links=driver.findElements(By.tagName("a"));
		String[] linktexts=new String[links.size()];
		String underconstruction="Under Construction: Mercury Tours";
		int i=0;
		for(WebElement e: links)
		{
			linktexts[i]= e.getText();
			//System.out.println(linktexts[i]);
			i++;
			
		}
		
	for(String T:linktexts)
		{
		
			driver.findElement(By.linkText(T)).click();
			if(driver.getTitle().equals(underconstruction))
			{
				System.out.println("\""+T+"\""+"is under construction");
			}
			else
			{
				System.out.println("\""+T+"\""+"is working");
			}
			
			driver.navigate().back();	
			
					}
			driver.close();	
	}
}

