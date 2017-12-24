package dataDriven;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DemoOnSwitch {

	@Test
	public void switchcondition()
	{
		Scanner s=new Scanner(System.in);
	
		System.out.println("Enter Color Code");
		String clr=s.nextLine();
		
		switch(clr)
		{
		case "OneColor":
			System.out.println("Red color is Selected");
			break;
			
		case "TwoColor":
			System.out.println("Red color is Selected");
			System.out.println("Blue color is Selected");
			break;
			
		case "ThreeColor":
			System.out.println("Red color is Selected");
			System.out.println("Blue Color is Selected");
			System.out.println("Green color is Selected");
			break;
		}
		
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
