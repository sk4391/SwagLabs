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
import pom.CartPage;
import pom.CheckOutComplete;
import pom.CheckOutOverview;
import pom.CheckOutPage;
import pom.InventoryPage;
import pom.SLoginPage;
import utility.CaptureScreenShot;
import utility.ExtentReport;
import utility.ReadData;
@Listeners(utility.Listeners.class)
public class CheckOutCompleteTest extends BaseClass
{
   SLoginPage login;
   InventoryPage inventory;
   CartPage cart;
   CheckOutPage check;
   CheckOutOverview overview;
   CheckOutComplete complete;
   ExtentReports reports;
   ExtentTest eTest;
   
   @BeforeTest(enabled = true)
   public void configureReport()
   {
	   reports = ExtentReport.getReports();
   }
   
   @BeforeMethod(alwaysRun = true)
   public void launchApplication() throws IOException
   {
	   initilization();
	   
	   login = new SLoginPage();
	   login.verifyLogin();
	   
	   inventory = new InventoryPage();
	   inventory.verifyCartPage();
	   
	   cart = new CartPage();
	   cart.verifyCheckOutBtnElement();
	   
	   check = new CheckOutPage();
	   check.verifyInfo();
	   
	   overview=new CheckOutOverview();
	   overview.verifyfinishBtn();
	   
	   complete = new CheckOutComplete();   
   }
   @Test(priority = 1,enabled = true)
   public void verifyTitleTest()
   {
	   eTest = reports.createTest("CheckOutCompleteTest");
	   String expTitle = "Checkout: Complete!";
	   String actTitle = complete.verifyTitleText();
	   Assert.assertEquals(actTitle, expTitle);
	   Reporter.log("complete TItle is "+actTitle);
   }
   @Test(priority = 2,enabled = true)
   public void verifyHeaderTest()
   {
	   eTest = reports.createTest("CheckOutCompleteTest");
	   String expHeader = "Thank you for your order!";
	   String actHeader = complete.verifyHeader();
	   Assert.assertEquals(actHeader, expHeader);
	   Reporter.log("The complete Page Header is : "+actHeader);
   }
   @Test(priority = 3,enabled = true)
   public void verifyLogoTest()
   {
	   eTest = reports.createTest("CheckOutCompleteTest");
	   boolean actLogo = complete.verifyLogo();
	   Assert.assertEquals(actLogo, true);
	   Reporter.log("Logo" +actLogo);
   }
   @Test(priority = 4,enabled = true)
   public void verifyTextTest()
   {
	   eTest = reports.createTest("CheckOutCompleteTest");
	   boolean actText = complete.verifyText();
	   Assert.assertEquals(actText, true);
	   Reporter.log("TEXT "+actText);
   }
   @Test(priority = 5,enabled = true)
   public void verifyBackBtn() throws EncryptedDocumentException, IOException
   {
	   eTest = reports.createTest("CheckOutCompleteTest");
	   String expURL = ReadData.getExcelData(4, 1);
	   String actURL = complete.verifyBackBtn();
	   Assert.assertEquals(actURL, expURL);
	   Reporter.log("After click on Back Button :" +actURL);
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
