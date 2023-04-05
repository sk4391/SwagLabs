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
import pom.InventoryPage;
import pom.SLoginPage;
import utility.CaptureScreenShot;
import utility.ExtentReport;
import utility.ReadData;
@Listeners(utility.Listeners.class)
public class InventoryPageTest extends BaseClass
{
   SLoginPage login;
   InventoryPage inventory;
   ExtentReports reports;
   ExtentTest eTest;
   
   @BeforeTest(enabled = true)
   public void configureReport()
   {
	   reports = ExtentReport.getReports();
   }
   
   @BeforeMethod(alwaysRun = true)
   public void launchBrowser() throws IOException
   {
	   initilization();
	   inventory = new InventoryPage();
	   login  = new SLoginPage();
	   login.verifyLogin();
   }
   @Test(priority = 6,enabled = true,groups = "Regression")
   public void verifyProductLogoTest()
   {
	    eTest = reports.createTest("InventoryPageLogo");
	  boolean result = inventory.verifyProductLabel();
	  Assert.assertEquals(result, true);
	  Reporter.log("Product lebal is : " +result);
	   
   }
   @Test(priority = 5,enabled = true,groups = "Regression")
   public void verifyProductTextTest()
   {
	   eTest = reports.createTest("InventoryPageProduct");
	   String actual = inventory.verifyProductText();
	   String expected = "Products";
	   Assert.assertEquals(expected, actual);
	   Reporter.log("Spelling of product text is : "+actual);
   }
   @Test(priority = 4,enabled = true)
   public void verifyAddTOCart() throws EncryptedDocumentException, IOException
   {
	   eTest = reports.createTest("InventoryPageAdd");
	   String expCount = ReadData.getExcelData(7, 0);
	   String actCount = inventory.verifyAddToCart();
	   Assert.assertEquals(expCount, actCount);
	   Reporter.log("Total count : " +actCount);
   }
    
//   public void verifyItemTshirtTextTest() throws EncryptedDocumentException, IOException
//   {
//	   String expText = ReadData.getExcelData(8, 1);
//	   String actText = inventory.verifyProductText();
//	   Assert.assertEquals(expText, actText);
//	   Reporter.log("The product Text is : "+actText);
//   }
   @Test(priority = 3,enabled = true)
   public void verifyImgTest()
   {
	   eTest = reports.createTest("InventoryPageImage");
	   boolean result = inventory.verifyImage();
	   Assert.assertEquals(result, true);
	   Reporter.log("Product Image is "+result);
   }
   @Test(priority = 2,enabled = true )
   public void verifyProductTshirtTextTest() throws EncryptedDocumentException, IOException
   {
	   eTest = reports.createTest("InventoryPage");
	   String expUrl = ReadData.getExcelData(5, 1);
	   String actUrl = inventory.verifyProductTshirtText();
	   Assert.assertEquals(expUrl, actUrl);
	   Reporter.log("The product url is " +actUrl);
   }
   @Test(priority = 1,enabled = true)
   public void verifyRemoveBtnTest() throws EncryptedDocumentException, IOException
   {
	   eTest = reports.createTest("InventoryPage");
	   String expURL = ReadData.getExcelData(4, 1);
	   String actURL = inventory.verifyRemoveBtn();
	   Assert.assertEquals(expURL, actURL);
	   Reporter.log("The Url is : "+actURL);
   }
   @Test(priority = 7 )
   public void verifySortListTest()
   {
	   eTest = reports.createTest("InventoryPageSortList");
	   String expText = "Name (A to Z) Name (Z to A) Price (low to high) Price (high to low)";
	   String actText = inventory.verifySortList();
	   Assert.assertEquals(expText, actText);
	   Reporter.log("The selected list is "+actText);
   }
   @Test(priority = 8 ,enabled = true)
   public void verifyTwitterElementTest()
   {
	   eTest = reports.createTest("InventoryPageTwitter");
	   String expectedUrl = "https://twitter.com/saucelabs";
	   String actualUrl   = inventory.verifyTwitterElement();
	   Assert.assertEquals(expectedUrl, actualUrl);
	   Reporter.log("Twitter Element is "+actualUrl);
   }
   @Test(enabled = true)
   public void verifyCartPageTest() throws EncryptedDocumentException, IOException
   {
	   eTest = reports.createTest("InventoryPage");
	   String eUrl = ReadData.getExcelData(6, 1);
	   String aUrl = inventory.verifyCartPage();
	   Assert.assertEquals(eUrl, aUrl);
	   Reporter.log("The Cart Page Url is : " +aUrl);
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
