package keywordDrivenFramework;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataDriven.Excel;
import jxl.read.biff.BiffException;

public class TestExecution {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void verifyLuanchapp()
	{
		driver=new FirefoxDriver();
		driver.get("http://192.168.1.4/bhas1/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

	@Test
	public void verifylogin_Rolecreation_logout() throws BiffException, IOException, InterruptedException
	{
		Excel.connectExcel("Input.xls", "role");
		int rc=Excel.rowsCount();
		int cc=Excel.colsCount();
		for(int i=1;i<rc;i++)
		{
		   String locType=Excel.readDataFromCell(2, i);
		   String locValue=Excel.readDataFromCell(3, i);
		   String className=Excel.readDataFromCell(4, i);
		   String input=Excel.readDataFromCell(5, i);
		   
		   switch(className)
		   { 
		      case "editbox":   
		    	  driver.findElement(Kwd_Locators.locator(locType, locValue)).clear();
		    	  driver.findElement(Kwd_Locators.locator(locType, locValue)).sendKeys(input);
		    	  break;
		      case "button":   
		    	  driver.findElement(Kwd_Locators.locator(locType, locValue)).click();
		    	  break;
		      case "dropdown":  
		    	  new Select(driver.findElement(Kwd_Locators.locator(locType, locValue))).selectByVisibleText(input);
		    	  break;
		      case "wait": 
		    	  Thread.sleep(3000);
		    	  break;
		      case "alert":   
		    	  Alert alertText=driver.switchTo().alert();
		    	  System.out.println(alertText.getText());
		    	  alertText.accept();
		    	  break;
		   
		   }
		   
		   
		   
		}
	}

}
