package TestNgSessions;

import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test(enabled = true, dependsOnMethods = {"browserTest", "loginTest"})
	public void homeTest() {
		System.out.println("Home Page Test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("Search Page Test");
	}
	
	@Test
	public void loginTest() {
		System.out.println("Login Page Test");
		//int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void profileTest() {
		System.out.println("Profile Page Test");
	}
	
	@Test
	public void browserTest() {
		System.out.println("Browser Test");
	}
}
