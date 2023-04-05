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
import pom.CheckOutPage;
import pom.InventoryPage;
import pom.SLoginPage;
import utility.CaptureScreenShot;
import utility.ExtentReport;
import utility.ReadData;
@Listeners(utility.Listeners.class)
public class CheckOutCartTest extends BaseClass
{
	SLoginPage login;
	InventoryPage inventory;
	CartPage   cart;
	CheckOutPage check;
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
	  
   }
   
	@Test(enabled = true)
   public void verifyCheckoutTitleText()
   {
		eTest = reports.createTest("CheckOutCartTest");
	   String expTitle = "Checkout: Your Information";
	   String actTitle = check.verifyCheckOutTitleElement();
	   Assert.assertEquals(actTitle, expTitle);
	   Reporter.log("The Title Of Checkout Page Is :" +actTitle);	  
   }
   @Test(priority = 2,enabled = true)
  public void verifyCancelBtn() throws EncryptedDocumentException, IOException
  {
	   eTest = reports.createTest("CheckOutCartTest");
	  String expUrl = ReadData.getExcelData(6, 1);
	  String actUrl = check.verifyCancelElement();
	  Assert.assertEquals(actUrl, expUrl);
	  Reporter.log("The expected URL is : "+actUrl);
  }
  @Test(priority = 1,enabled = true)
  public void verifyInformation() throws IOException
  {
	  eTest = reports.createTest("CheckOutCartTest");
	  String expURL = ReadData.getExcelData(11, 1);
	  String actURL = check.verifyInfo();
	  Assert.assertEquals(actURL, expURL);
	  Reporter.log("The info URL is " +actURL);
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
