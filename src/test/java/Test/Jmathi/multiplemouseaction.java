package Test.Jmathi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class multiplemouseaction {
	protected WebDriver driver;
	@BeforeTest
	public void startbrowser()
	{
		File driverpath=new File("src/main/java/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath.getAbsolutePath());
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
@Test
public void multipleteactiontest()
{
	WebElement email=driver.findElement(By.xpath(".//*[@id='email']"));
	Actions builder=new Actions(driver);
	Action multipledo=builder.moveToElement(email).click().keyDown(email, Keys.SHIFT).sendKeys("hello").keyUp(email, Keys.SHIFT).doubleClick().contextClick(email).build();
	multipledo.perform();
		}
}
