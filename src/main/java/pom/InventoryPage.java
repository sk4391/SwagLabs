package pom;

import org.openqa.selenium.WebDriver;
//Price (low to high)
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pojo.BaseClass;
import utility.UtilityMethod;

public class InventoryPage extends BaseClass
{
   @FindBy(xpath = "//div[text()='Swag Labs']")private WebElement productLogoElement;
   @FindBy(xpath = "(//button[text()='Add to cart'])[1]")private WebElement addToCartBtn1Element;
   @FindBy(xpath ="(//button[text()='Add to cart'])[2]")private WebElement addToCartBtn2Element;
   @FindBy(xpath ="//div[text()='Sauce Labs Bolt T-Shirt']")private WebElement productTshirtElement;
   @FindBy(xpath ="//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement addToCartBtn3Element;
   @FindBy(xpath ="//button[@name='remove-sauce-labs-bolt-t-shirt']")private WebElement removeBtnElement;
   @FindBy(xpath ="//img[@alt='Test.allTheThings() T-Shirt (Red)']")private WebElement imgProductElement;
   @FindBy(xpath ="//select[@class='product_sort_container']")private WebElement sortContainerElement;
   @FindBy(xpath ="//a[text()='Twitter']")private WebElement twitterLinkElement;
   @FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement shopingCartElement;
   @FindBy(xpath ="//span[@class='title']")private WebElement productTextElement;
   @FindBy(xpath ="//button[@name='back-to-products']")private WebElement backToProductElement;
   
   public InventoryPage()
   {
	   PageFactory.initElements(driver, this);
   }
   
   public boolean verifyProductLabel()
   {
	   return productLogoElement.isDisplayed();
   }
   
   public String verifyProductText()
   {
	   return productTextElement.getText();
   }
   public String verifyAddToCart()
   {
	   addToCartBtn1Element.click();
	   addToCartBtn2Element.click();
	   System.out.println("count="+shopingCartElement.getText());
	   return shopingCartElement.getText();
	   
	   
   }
   public boolean verifyImage()
   {
	   return imgProductElement.isDisplayed();
   }
   
   public String verifyProductTshirtText()
   {
	   productTshirtElement.click();
	   addToCartBtn3Element.click();
	   return driver.getCurrentUrl();
   }
   
   public String verifyRemoveBtn()
   {
	   productTshirtElement.click();
	   addToCartBtn3Element.click();
	   removeBtnElement.click();
	   backToProductElement.click();
	   return driver.getCurrentUrl();
	   
   }
   public String verifySortList()
   {
	  UtilityMethod.selectClass(sortContainerElement, "Price (low to high)");
	  return sortContainerElement.getText();
   }
   
   public String verifyTwitterElement()
   {
	   twitterLinkElement.click();
	   UtilityMethod.windowHandleTwitter();
	   return driver.getCurrentUrl();
   }
   public String verifyCartPage()
   {
	   addToCartBtn1Element.click();
	   addToCartBtn2Element.click();
	   shopingCartElement.click();
	   return driver.getCurrentUrl();
   }
   
   
}
