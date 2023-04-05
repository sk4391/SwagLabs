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
import pom.InventoryPage;
import pom.SLoginPage;
import utility.CaptureScreenShot;
import utility.ExtentReport;
import utility.ReadData;
@Listeners(utility.Listeners.class)
public class CartPageTest extends BaseClass
{
   SLoginPage login;
   InventoryPage inventory;
   CartPage  cart;
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
   }
   @Test(priority = 4,enabled = true)
   public void verifyCartTitkeTest()
   {
	   eTest = reports.createTest("CartPage");
	   String expTitle ="Your Cart";
	   String acttitle = cart.verifyCartTitleElement();
	   Assert.assertEquals(acttitle, expTitle);
	   Reporter.log("The title is : " +acttitle);	   
   }
   @Test(priority = 3,enabled = true)
   public void verifyRemoveOrderTest()
   {
	   eTest = reports.createTest("CartPageTest");
	   String expCount = "1";
	   String actCount = cart.verifyRemoveOrderElement();
	   Assert.assertEquals(actCount, expCount);
	   Reporter.log("The count is :" +actCount);
   }
   @Test(priority = 2,enabled = true)
   public void verifyMenuBarText() throws EncryptedDocumentException, IOException
   {
	   eTest = reports.createTest("CartPageTest");
	   String expURL = ReadData.getExcelData(4, 1);
	   String actURL = cart.verifyMenuBar();
	   Assert.assertEquals(actURL, expURL);
	   Reporter.log("The Url is : "+actURL);
   }
   @Test(priority = 1,enabled = true)
   public void verifyContinueShop() throws EncryptedDocumentException, IOException
   {
	   eTest = reports.createTest("CartPageTest");
	   String expUrl = ReadData.getExcelData(4, 1);
	   String actUrl = cart.verifyContinueShopElement();
	   Assert.assertEquals(actUrl, expUrl);
	   Reporter.log("The Actual Url is : " +actUrl);
   }
   @Test(enabled = true)
   public void verifyCheckOutButton() throws EncryptedDocumentException, IOException
   {
	   eTest = reports.createTest("CartPageTest");
	   String expUrl = ReadData.getExcelData(10, 1);
	   String actUrl = cart.verifyCheckOutBtnElement();
	   Assert.assertEquals(actUrl, expUrl);
	   Reporter.log("The Url of Next Page is " +actUrl);
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
