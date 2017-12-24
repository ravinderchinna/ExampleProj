package dataDriven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import jxl.read.biff.BiffException;



public class Repository {
	public static WebDriver driver;
	
	public static void logIn() {
		driver.findElement(Locator.txt_Username).sendKeys(InputData.txt_Username);
		driver.findElement(Locator.txt_Password).sendKeys(InputData.txt_Password);
		driver.findElement(Locator.btn_Login).click();
	}

	// Expand tree in the left frame by switching to the frame
	public static void expand() {
		driver.switchTo().frame("left");
		driver.findElement(Locator.expand_reception).click();
		driver.findElement(Locator.expand_registration).click();
		driver.findElement(Locator.click_PatientRegistration).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("display");
		driver.findElement(Locator.click_New).click();	
		
	}
	
	public static void ExcelpatientRegistration(String Name,String Age,String Sex,String Mobile,String Address, String State,String doctorName)
	{
		
		// Enter patient Name
		driver.findElement(Locator.txt_name).sendKeys(Name);
		// Enter Patient Age
		driver.findElement(Locator.txt_age).sendKeys(Age);
		// Select Sex as Female
		Select selSex = new Select(driver.findElement(Locator.ddl_sex));
		selSex.selectByVisibleText(Sex);
		// Enter Mobile Number
		driver.findElement(Locator.txt_mobile).sendKeys(Mobile);
		// Enter Address 1
		driver.findElement(Locator.txt_address).sendKeys(Address);

		// Select State as AP
		Select selState = new Select(driver.findElement(Locator.ddl_state));
		selState.selectByVisibleText(State);

		driver.findElement(Locator.window_doctor).sendKeys(Keys.F2);
        driver.switchTo().alert().accept();

		ArrayList<String> wh = new ArrayList<>(driver.getWindowHandles());
		System.out.println("Total no .of child windows are: " + wh.size());
		// Focus cursor from Parent window to child window
		driver.switchTo().window(wh.get(1));
		selectDoctorFromWebTable(doctorName);
		driver.findElement(Locator.btn_ok).click();

		// Focus cursor from child window[index 1] to parent window [index 0 ]
		driver.switchTo().window(wh.get(0));
		driver.switchTo().frame("display");

		driver.findElement(Locator.btn_submit).click();

	}
	
	public static void selectDoctorFromWebTable(String doctorName) {

		// Initializing boolean variable
		boolean flag = false;
		// Identify the webtable
		driver.findElement(Locator.webtable_table);

		// Count total rows in the webtable
		List<WebElement> tRows = driver.findElements(Locator.webtable_tr);
		System.out.println("Total no.of rows in the webtable are : " + tRows.size());

		// For Loop for rows iteration
		for (int i = 2; i < tRows.size(); i++) {
			List<WebElement> tCells = tRows.get(i).findElements(Locator.webtable_td);
			System.out.println("The total no of columns for each row: " + tCells.size());
			// For loop for Cells iteration for each row
			for (WebElement td : tCells) {
				String data = td.getText();
				System.out.println("The value in the cell is : " + data);
				if (data.equalsIgnoreCase(doctorName)) {
					tRows.get(i).findElement(Locator.webtable_select).click();
					// Break from the loop
					flag = true;
					break;
				}
			}
			if (flag == true) {
				break;
			}

		}
	}
	
	public Object[][] getExcelContents(String fileName,String sheetName) throws BiffException, IOException{
		Excel.connectExcel(fileName, sheetName);
		int rc = Excel.rowsCount();
		int cc = Excel.colsCount();
		String[][] val = new String[rc-1][cc];
		for(int i=1;i<rc;i++){
			for(int j=1;j<cc;j++){
				val[i-1][j]=Excel.readDataFromCell(j,i);
				System.out.println(val);
			}
		}
		return val;
	}
	
	public static void crossBrowser(String browser,String url){
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Dump_1.0\\Selenium_Dump\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
	}
	
	
	
	//*************** 21-Apr-2017 ********
	
	public static void enquiry() throws FindFailed, InterruptedException
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("left");
		driver.findElement(By.xpath("//*[@alt='Expand Enquiry']")).click();
		driver.findElement(By.id("TreeView1t6")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("display");
		driver.findElement(By.name("txtRegNo")).sendKeys("12452");
		driver.findElement(By.name("btnSearch")).click();
		//Silkuli Operations
		Thread.sleep(3000);
		Screen s=new Screen();
		s.click("X:\\Swathi_Workspace\\Data_Driven\\Sikuli_Images\\btnPrint_1.PNG");
		Thread.sleep(3000);
		s.click("X:\\Swathi_Workspace\\Data_Driven\\Sikuli_Images\\btnChange_2.PNG");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
