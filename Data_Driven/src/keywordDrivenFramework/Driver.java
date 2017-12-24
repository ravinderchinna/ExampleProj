package keywordDrivenFramework;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

public class Driver {

	public static WebDriver driver;
	@BeforeTest
	public void launchApp(){
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter browser");
		String br = s.nextLine();
		
		switch(br)
		{
		case "Firefox":
			driver=new FirefoxDriver();
			break;
			
		case "Chrome":
			System.setProperty("webdriver.chrome.driver","D:\\Selenium_Dump_1.0\\Selenium_Dump\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
		
		case "InternetExplorer":
			System.setProperty("webdriver.ie.driver", "D:\\Selenium_Dump_1.0\\Selenium_Dump\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
	}
	
	
	
	
}
