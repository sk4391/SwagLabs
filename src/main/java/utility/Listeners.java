package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pojo.BaseClass;

public class Listeners extends BaseClass implements ITestListener 
{
	WebDriver driver;
    
    public void onTestSuccess(ITestResult result)
    {
    	System.out.println("Test is Successfull "+result.getName());
    }
    public void OnTestFailure(ITestResult result)
    {
    	try
    	{
    		CaptureScreenShot.screenShot(driver,result.getName());
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test is Skipped " +result.getName());
	}
    public void onTestStart(ITestResult result)
    {
    	System.out.println("Test is started" +result.getName());
    }
}
