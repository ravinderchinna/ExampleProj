package keywordDrivenFramework;

import org.openqa.selenium.By;

public class Kwd_Locators {

	public static By locator(String locType,String locValue)
	{
		By loc=null;
		
		switch(locType)
		{
		  case "id":
			loc=  By.id(locValue);
			  break;
			  
		  case "classname":
			  loc=  By.className(locValue);
			  break;
			  
		  case "name":
			  loc=  By.name(locValue);
			  break;
			  
		  case "xpath":
			  loc=  By.xpath(locValue);
			  break;
			  
		  case "cssSelector":
			  loc=   By.cssSelector(locValue);
			  break;
		}
		
		return loc;
		
	}

}
