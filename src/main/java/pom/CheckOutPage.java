package pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pojo.BaseClass;
import utility.ReadData;

//span[text()='Checkout: Your Information']
//input[@name='firstName']
//input[@name='lastName']
//input[@name='postalCode']
//input[@name='continue']
//button[@name='cancel']
public class CheckOutPage extends BaseClass
{
    @FindBy(xpath = "//span[text()='Checkout: Your Information']")private WebElement checkOutTitleElement;
    @FindBy(xpath = "//input[@name='firstName']")private WebElement fNameElement;
    @FindBy(xpath = "//input[@name='lastName']")private WebElement lNameElement;
    @FindBy(xpath = "//input[@name='postalCode']")private WebElement postalCodeElement;
    @FindBy(xpath = "//input[@name='continue']")private WebElement continuePageElement;
    @FindBy(xpath = "//button[@name='cancel']")private WebElement cancelElement;
    
    public CheckOutPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    public String verifyCheckOutTitleElement()
    {
    	return checkOutTitleElement.getText();
    }
    
    public String verifyCancelElement()
    {
    	cancelElement.click();
    	return driver.getCurrentUrl();
    }
    
    public String verifyInfo() throws IOException
    {
    	fNameElement.sendKeys(ReadData.readPropertyFile("firstname"));
    	lNameElement.sendKeys(ReadData.readPropertyFile("lastname"));
    	postalCodeElement.sendKeys(ReadData.readPropertyFile("postalcode"));
    	continuePageElement.click();
    	return driver.getCurrentUrl();
    	
    }
}
