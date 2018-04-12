package Test.Jmathi;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.dataproviderClass;

public class ParameterfromDtaProvider {
	protected WebDriver driver;
	@BeforeTest
	public void Startbrowser()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider="searchprovider",dataProviderClass=dataproviderClass.class)
	public void parameterfromdataproviderTest(String author, String searchkey)
	{
		WebElement searchbox=driver.findElement(By.id("lst-ib"));
		searchbox.clear();
		searchbox.sendKeys(searchkey);
		String searchinput=searchbox.getAttribute("value");
		System.out.println("Author is "+author+"  Search Key is "+ searchinput);
		Assert.assertTrue(searchinput.equalsIgnoreCase(searchkey));
	}
}
