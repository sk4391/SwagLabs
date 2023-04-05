package pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pojo.BaseClass;
import utility.ReadData;

//div[text()='Swag Labs']
//input[@name='user-name']
//input[@name='password']
//input[@name='login-button']
public class SLoginPage extends BaseClass
{
   @FindBy(xpath = "//div[text()='Swag Labs']")private WebElement loginLogo;
   @FindBy(xpath ="//input[@name='user-name']" )private WebElement userId;
   @FindBy(xpath ="//input[@name='password']")private WebElement userpassword;
   @FindBy(xpath = "//input[@name='login-button']") private WebElement loginBtn;
   
   public SLoginPage()
   {
	   PageFactory.initElements(driver, this);
   }
   
   public String verifyLoginPageTitle()
   {
	   return driver.getTitle();
   }
  
   public String verifyLoginUrl()
   {
	   return driver.getCurrentUrl();
   }
  
   public String verifyLoginLogo()
   {
	   return loginLogo.getText();
   }
   
   public String verifyLogin() throws IOException
   {
	   userId.sendKeys(ReadData.readPropertyFile("username"));
	   userpassword.sendKeys(ReadData.readPropertyFile("password"));
	   loginBtn.click();
	   return driver.getCurrentUrl();
	   
   }
   
   
   
}
