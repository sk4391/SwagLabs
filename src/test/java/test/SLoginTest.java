
package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.BaseClass;
import pom.SLoginPage;
import utility.CaptureScreenShot;
import utility.ExtentReport;
import utility.ReadData;
@Listeners(utility.Listeners.class)
public class SLoginTest extends BaseClass 
{
     SLoginPage loginPage ;
     ExtentReports reports;
     ExtentTest etest;
     
     @BeforeTest(enabled = true)
     public void configureReport()
     {
  	   reports = ExtentReport.getReports();
     }
     
     @BeforeMethod(alwaysRun = true)
     public void launchBrowser() throws IOException
     {
    	 loginPage = new SLoginPage();
    	 initilization();
     }
     
     @Test(priority = 2,enabled = true)
     public void verifyTitleTest() throws EncryptedDocumentException, IOException
     {
    	 etest = reports.createTest("LoginPageTitle");
    	 String expTitle = ReadData.getExcelData(0, 1);
    	 String actTitle = loginPage.verifyLoginPageTitle();
    	 Assert.assertEquals(actTitle, expTitle);
    	 Reporter.log("Login Page Title is : " +actTitle);
     }
     
     @Test(priority = 4,enabled = true,groups = "Regression")
     public void verifyLoginUrlTest() throws EncryptedDocumentException, IOException
     {
    	 etest = reports.createTest("LoginPageURL");
    	 String expUrl = ReadData.getExcelData(1, 1);
    	 String actUrl =  loginPage.verifyLoginUrl();
    	 Assert.assertEquals(actUrl, expUrl);
    	 Reporter.log("Login Page URL is :" +actUrl);
     }
     @Test(priority = 3,enabled = true,groups="Regression")
     public void verifyLoginLogoTest() throws EncryptedDocumentException, IOException
     {
    	 etest = reports.createTest("LoginPageLogo");
    	 loginPage = new SLoginPage();
    	 String expLogo = ReadData.getExcelData(0, 1);
    	 String actLogo = loginPage.verifyLoginLogo();
    	 Assert.assertEquals(actLogo, expLogo);
    	 Reporter.log("Login Page Logo is :" +actLogo);
     }
     
     @Test(priority = 1,enabled = true)
     public void verifyLoginTest() throws IOException
     {
    	 etest = reports.createTest("LoginPage");
    	 loginPage = new SLoginPage();
    	 String expUrl  =ReadData.getExcelData(4, 1);
    	 String actUrl  =loginPage.verifyLogin();
    	 Assert.assertEquals(actUrl, expUrl);
    	 Reporter.log("Inventory page Url is : " +actUrl);
     }
     
     @AfterMethod(alwaysRun = true)
     public void closeBrowser(ITestResult result) throws IOException
     {
    	 if(result.SUCCESS==result.getStatus())
    	 {
    		 result.getName();
    	 }
    	 else if(result.FAILURE==result.getStatus())
    	 {
    		 CaptureScreenShot.screenShot(driver,result.getName());
    	 }
    	 else if (result.SKIP==result.getStatus())
    	 {
    		 result.getName();
    	 }
    	 driver.close();
     }
     @AfterTest(enabled = true)
     public void flushReports()
     {
   	   reports.flush();
     }
     
     
}
