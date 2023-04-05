package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pojo.BaseClass;

//span[text()='Checkout: Complete!']
//h2[@class='complete-header']
//div[@class='complete-text']
//button[@id='back-to-products']
public class CheckOutComplete extends BaseClass
{
  @FindBy(xpath ="//span[text()='Checkout: Complete!']" )private WebElement completeTitleElement;
  @FindBy(xpath = "//h2[@class='complete-header']" )private WebElement completeHeaderElement;
  @FindBy(xpath = "//div[@class='complete-text']")private WebElement completeTextElement;
  @FindBy(xpath = "//button[@id='back-to-products']")private WebElement backToHomeBtn;
  @FindBy(xpath = "//img[@class='pony_express']")private WebElement logoElement;
  
  public CheckOutComplete()
  {
	  PageFactory.initElements(driver, this);
	  
			  
  }
  
  public String verifyTitleText()
  {
	  return completeTitleElement.getText();
  }
  public String verifyHeader()
  {
	  return completeHeaderElement.getText();
  }
  public boolean verifyText()
  {
	  return completeTextElement.isDisplayed();
  }
  
  public boolean verifyLogo()
  {
	  return logoElement.isDisplayed();
  }
  
  public String verifyBackBtn()
  {
	  backToHomeBtn.click();
	  return driver.getCurrentUrl();
  }
	  
}
