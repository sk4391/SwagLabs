package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.node.BooleanNode;

import pojo.BaseClass;

//span[@class='title']
//div[text()='Payment Information']
//div[text()='Shipping Information']
//div[text()='Price Total']
//div[@class='summary_info_label summary_total_label']
//button[@name='finish']
//button[@name='cancel']
public class CheckOutOverview extends BaseClass
{
    @FindBy(xpath = "//span[@class='title']")private WebElement overviewTitleElement;
    @FindBy(xpath = "//div[text()='Payment Information']")private WebElement paymentInfoElement;
    @FindBy(xpath = "//div[text()='Shipping Information']")private WebElement shipInfoElement;
    @FindBy(xpath = "//div[text()='Price Total']")private WebElement priceElement;
    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")private WebElement totalPaymentElement;
    @FindBy(xpath ="//button[@name='finish']")private WebElement finishElement;
    @FindBy(xpath = "//button[@name='cancel']")private WebElement cancelElement;
    
    public CheckOutOverview()
    {
    	PageFactory.initElements(driver, this);
    }
    
    public String verifyOverviewTitle()
    {
    	return overviewTitleElement.getText();
    }
    public boolean verifyPaymentInfo()
    {
    	return paymentInfoElement.isDisplayed();
    }
    public boolean verifyShipInfo()
    {
    	return shipInfoElement.isDisplayed();
    }
    public boolean verifyPrice()
    {
    	return priceElement.isDisplayed();
    }
    public boolean verifyTotalPayment()
    {
    	return totalPaymentElement.isDisplayed();
    }
    public String verifyCancelBtn()
    {
    	 cancelElement.click();
    	 return driver.getCurrentUrl();
    }
    public String verifyfinishBtn()
    {
    	finishElement.click();
    	return driver.getCurrentUrl();
    }
}
