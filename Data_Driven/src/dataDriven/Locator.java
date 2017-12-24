package dataDriven;

import org.openqa.selenium.By;

public class Locator {
	// Login Locators
	// Username
	public static By txt_Username = By.id("txtUserName");
	// Password
	public static By txt_Password = By.id("txtPwd");
	// Login
	public static By btn_Login = By.id("btnSignIn");

	// Expand Reception
	public static By expand_reception = By.xpath(".//*[@id='TreeView1n1']/img");
	// Expand Registration
	public static By expand_registration = By.xpath("//*[@id='TreeView1n2']/img");

	// Patient Registration Locator
	public static By click_PatientRegistration = By.id("TreeView1t3");
	// Click on new Link for patient registration
	public static By click_New = By.xpath("html/body/form/center[1]/table/tbody/tr/td/a/img");
	// public static By click_New = By.cssSelector("#hypnew>img");

	// Form Locators
	public static By txt_name = By.id("txtName");
	public static By txt_age = By.id("txtAge");
	// public static By ddl_sex = By.id("ddlSex");
	public static By ddl_sex = By.id("ddlSex");
	public static By txt_mobile = By.id("txtMobile");
	public static By txt_address = By.id("txtAddress1");
	public static By ddl_state = By.id("ddlaspState");
	public static By window_doctor = By.id("txtDoctorName");
	public static By webtable_table = By.id("gvDoctorCode");
	public static By webtable_tr = By.tagName("tr");
	public static By webtable_td = By.tagName("td");
	public static By webtable_select = By.linkText("Select");
	public static By btn_ok = By.id("btnClose");

	// Submit Button
	public static By btn_submit = By.id("btnSubmit");
	public static By RegNo = By.id("lblsPatientRegNo");

	// Patient Search And Edit Locators
	public static By patient_Search = By.linkText("Patient Search & Edit");
	public static By txt_Regno = By.id("txtRegno");
	public static By btn_SearchSubmit = By.id("btnSubmit");

	// LogOut Locator
	public static By log_Out = By.linkText("LogOut");

}
