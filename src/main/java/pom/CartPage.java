package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pojo.BaseClass;

//span[text()='Your Cart'] cart title
//button[@name='remove-sauce-labs-bike-light'] remove order
//button[@name='checkout']   checkout button
//button[@id='react-burger-menu-btn'] menuBar
//a[text()='All Items']  allitems
//button[@name='continue-shopping']

    

public class CartPage extends BaseClass
{
	@FindBy(xpath ="//span[text()='Your Cart']") private WebElement cartTitleElement;
	@FindBy(xpath ="//button[@name='remove-sauce-labs-bike-light']")private WebElement removeOrderElement;
	@FindBy(xpath ="//button[@name='checkout']") private WebElement checkOutBtn;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")private WebElement menuBar;
	@FindBy(xpath = "//a[text()='All Items']")private WebElement allItems;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")private WebElement shopCartElement;
	@FindBy(xpath = "//button[@name='continue-shopping']")private WebElement continueShopElement;
	@FindBy(xpath = "(//button[text()='Add to cart'])[2]")private WebElement btn2Element;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCartTitleElement()
	{
		return cartTitleElement.getText();
	}
	public String verifyRemoveOrderElement()
	{
		removeOrderElement.click();
		return shopCartElement.getText();
	}
	
	public String verifyMenuBar()
	{
		menuBar.click();
		allItems.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyContinueShopElement()
	{
		continueShopElement.click();
		return driver.getCurrentUrl();
	}
	public String verifyCheckOutBtnElement()
	{
		checkOutBtn.click();
		return driver.getCurrentUrl();
	}
}
