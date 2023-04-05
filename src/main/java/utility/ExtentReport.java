package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport 
{
   public static ExtentReports getReports()
   {
	   ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReports.html");
	   ExtentReports extent = new ExtentReports();
	   extent.attachReporter(sparkReporter);
	   extent.setSystemInfo("Reported By", "Suprit");
	   extent.setSystemInfo("TestType", "");
	   return extent;
   }
}
