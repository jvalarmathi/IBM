package Test.Jmathi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.dataproviderClass;

public class Gmailloginusingdataprovider {
	protected WebDriver driver;
	@BeforeTest
	public void startbrowser()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		driver=new ChromeDriver();
		driver.get("http://gmail.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider="GmailLogin",dataProviderClass=dataproviderClass.class)
	public void gmailloginTest(String Emailid, String Password) throws InterruptedException
	{
		WebElement Email=driver.findElement(By.id("identifierId"));
		Email.clear();
		Email.sendKeys(Emailid);
		driver.findElement(By.id("identifierNext")).click();
		//WebElement pwd=driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input/following-sibling::div[@class='AxOyFc snByac']"));
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys(Password);
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(5000);
		String url1=driver.getCurrentUrl();
		System.out.println(url1);
		//WebElement compose=driver.findElement(By.xpath(".//*[contains(text(),'COMPOSE')]"));
		if(!url1.contains("https://mail.google.com/mail/u/0/#inbox"))
		{
			System.out.println("Gmailloginfail");
			driver.navigate().back();
			Thread.sleep(3000);
		}
		else
		{
			System.out.println("Gmailloginpass");
		}
	}
}
