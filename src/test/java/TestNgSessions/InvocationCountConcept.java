package TestNgSessions;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class InvocationCountConcept {

	@BeforeSuite(enabled = true)
	public void setup() {
		System.out.println("Setup");
	}
	
	@Test(priority = 2)
	public void aTest() {
		System.out.println("A .... Test");
	}
	
	@Test(enabled = false)
	public void bTest() {
		System.out.println("B .... Test");
	}
	
	@Test(invocationCount = 2, priority = 1, enabled = true)
	public void cTest() {
		System.out.println("C .... Test");
	}
	
	@Test
	public void dTest() {
		System.out.println("D .... Test");
	}
}
