package dataDriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DemoOnSeleniumDrivers {

	public static WebDriver driver;
	
	public static void firefoxBrowser()
	{
		//Selenium-java 2.53 WebDriver 
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Dump_1.0\\Selenium_Dump\\chromedriver_win32\\chromedriver.exe");
		driver=new FirefoxDriver();
	}
	
	
	
	public static void chromeBrowser()
	{
		//Selenium-java 2.53 WebDriver
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Dump_1.0\\Selenium_Dump\\chromedriver_win32\\chromedriver.exe");
		
		
		driver=new ChromeDriver();
	}
	
	
	public static void internetExplorer()
	{
		//Selenium-java 2.53 WebDriver 
		System.setProperty("webdriver.ie.driver", "D:\\Selenium_Dump_1.0\\Selenium_Dump\\IEDriverServer_x64_2.51.0\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
				
	}
	
	
	public static void main(String[] args)
	{
		firefoxBrowser();
		chromeBrowser();
		internetExplorer();
	}
	
	
}
