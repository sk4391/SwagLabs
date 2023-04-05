package utility;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import pojo.BaseClass;

public class UtilityMethod extends BaseClass
{
   public static void selectClass(WebElement we,String value)
   {
	   Select s1 = new Select(we);
	   s1.selectByVisibleText(value);
   }
   
   public static void windowHandleTwitter()
   {
	   Set<String> window = driver.getWindowHandles();
	   System.out.println(window.size());
	   
	   Iterator itr = window.iterator();
	   
	   String win[] = new String [window.size()];
	   for(int i=0;i<window.size();i++)
	   {
		   win[i] = (String) itr.next();
		   
	   }
	   driver.switchTo().window(win[0]);
	   System.out.println("URL of win 0 is : "+driver.getCurrentUrl());
	   driver.close();
	   
	   driver.switchTo().window(win[1]);
	   System.out.println("URL of win 1 is : "+driver.getCurrentUrl());
   }
 
}
