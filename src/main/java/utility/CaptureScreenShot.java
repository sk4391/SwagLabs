package utility;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import pojo.BaseClass;

public class CaptureScreenShot extends BaseClass
{
   public static void screenShot(WebDriver driver,String name) throws IOException
   {
	   File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File destination = new File("C:\\Users\\khama\\testingpractice\\ProjectSwagLab\\ScreenShot\\"+name+" .jpeg");
	   FileHandler.copy(source, destination);
   }
}
