package pojo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadData;

public class BaseClass 
{
	public static WebDriver driver;
	
   public void initilization() throws IOException
   {
	   String Browser = ReadData.readPropertyFile("browser");
	   if(Browser.equals("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   ChromeOptions co = new ChromeOptions();
		   co.addArguments("--remote-allow-origins=*");
		   driver = new ChromeDriver(co);
	   }
	   else if(Browser.equals("firefox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
	   }
	   else if(Browser.equals("Edge"))
	   {
		   WebDriverManager.edgedriver().setup();
		   driver = new EdgeDriver();
	   }
	   
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get(ReadData.readPropertyFile("url"));
   }
}
