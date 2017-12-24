package dataDriven;

import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExecution extends Repository{

	@BeforeTest
	public void verifylaunchapp()
	{
		crossBrowser("chrome","http://192.168.1.4/hms");
	}
	
	
	@Test(priority=0)
	public void verifylogin()
	{
		logIn();
	}
	
	@Test(priority=1)
	public void verifypatientRegistraion()
	{
		expand();
		ExcelpatientRegistration("SamplePatient", "25", "MALE", "9102435102", "Nellore", "AP", "Ravi");
	}
	
	
	@Test(priority=2)
	public void verifyenquiry() throws FindFailed, InterruptedException
	{
		enquiry();
	}
}
