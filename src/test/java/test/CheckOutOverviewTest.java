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

import io.netty.handler.codec.http.HttpContentEncoder.Result;
import pojo.BaseClass;
import pom.CartPage;
import pom.CheckOutOverview;
import pom.CheckOutPage;
import pom.InventoryPage;
import pom.SLoginPage;
import utility.CaptureScreenShot;
import utility.ExtentReport;
import utility.ReadData;
import utility.UtilityMethod;
@Listeners(utility.Listeners.class)
public class CheckOutOverviewTest extends BaseClass 
{
   SLoginPage login;
   InventoryPage inventory;
   CartPage cart;
   CheckOutPage checkCart;
   CheckOutOverview checkOverview;
   UtilityMethod utility;
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
	   
	   checkCart = new CheckOutPage();
	   checkCart.verifyInfo();
	   
	   checkOverview = new CheckOutOverview();
	   	   
   }
   @Test(priority = 1,enabled = true)
   public void verifyOverviewTitleTest()
   {
	   eTest = reports.createTest("CheckOutOverViewTest");
	   String expTitle = "Checkout: Overview";
	   String actTitle =  checkOverview.verifyOverviewTitle();
	   Assert.assertEquals(expTitle, actTitle);
	   Reporter.log("The Overview Page TItle is " +actTitle);
	   
   }
   @Test(priority = 2,enabled = true)
   public void verifyPaymentInfoTest()
   {
	   eTest = reports.createTest("CheckOutOverViewTest");
	   boolean actpaymentInfo = checkOverview.verifyPaymentInfo();
	   Assert.assertEquals(actpaymentInfo, true);
	   Reporter.log("the Payment info is "+actpaymentInfo);
   }
   @Test(priority = 3,enabled = true)
   public void verifyShipInfoTest()
   {
	   eTest = reports.createTest("CheckOutOverViewTest");
	   boolean actShipInfo = checkOverview.verifyShipInfo();
	   Assert.assertEquals(actShipInfo, true);
	   Reporter.log("The shipment Info is : "+actShipInfo);
   }
   @Test(priority = 4,enabled = true)
   public void verifyPriceTest()
   {
	   eTest = reports.createTest("CheckOutOverViewTest");
	   boolean actPrice = checkOverview.verifyPrice();
	   Assert.assertEquals(actPrice, true);
	   Reporter.log("The price Info is  : "+actPrice);
	   
   }
   @Test(priority = 5,enabled = true)
   public void verifytotalPaymentinfoTest()
   {
	   eTest = reports.createTest("CheckOutOverViewTest");
	   boolean actTotalPayment = checkOverview.verifyPaymentInfo();
	   Assert.assertEquals(actTotalPayment, true);
	   Reporter.log("The Total payment info is :" +actTotalPayment);   
   }
   @Test(priority = 6,enabled = true)
   public void verifyCancelBtnTest() throws EncryptedDocumentException, IOException
   {
	   eTest = reports.createTest("CheckOutOverViewTest");
	   String expURL = ReadData.getExcelData(4, 1);
	   String actURL = checkOverview.verifyCancelBtn();
	   Assert.assertEquals(actURL, expURL);
	   Reporter.log("After click Cancel button URl shows "+actURL);
   }
   @Test(priority = 7,enabled = true)
   public void verifyFinishBtnTest() throws EncryptedDocumentException, IOException
   {
	   eTest = reports.createTest("CheckOutOverViewTest");
	   String expUrl = ReadData.getExcelData(12, 1);
	   String actURL = checkOverview.verifyfinishBtn();
	   Assert.assertEquals(actURL, expUrl);
	   Reporter.log("After click finish Button Url Shows "+actURL);
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
