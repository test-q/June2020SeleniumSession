package TestNgSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations {
	
	//STCMT
	
	@BeforeSuite
	public void connectDB() {
		System.out.println("BS --- Connect to DB.");
	}
	
	@BeforeTest
	public void createUserInDB() {
		System.out.println("BT --- Create User In DB.");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC --- Launch Browser.");
	}
	
	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM --- Login To App.");
	}
	
	@Test
	public void homePageTitleTest() {
		System.out.println("Home page Title Test.");
	}
	
	@Test
	public void homePageSearchTest() {
		System.out.println("Home page Search Test.");
	}
	
	@Test
	public void homePageAdvSearchTest() {
		System.out.println("Home page Adv Search Test.");
	}
	
	@Test
	public void homePageProfileTest() {
		System.out.println("Home Page Profile Test.");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("AM --- Logout.");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC --- Close Browser.");
	}
	
	@AfterTest
	public void deleteUserInDB() {
		System.out.println("AT --- Delete User In DB.");
	}
	
	@AfterSuite
	public void disconnectDB() {
		System.out.println("AS --- Disconnect DB");
	}
	
	

}
