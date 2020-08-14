package TestNgSessions;

import org.testng.annotations.Test;

public class PriorityConcept {
	
	@Test(priority = 2)
	public void aTest() {
		System.out.println("A .... Test");
	}
	
	@Test
	public void bTest() {
		System.out.println("B .... Test");
	}
	
	@Test(priority = 3)
	public void cTest() {
		System.out.println("C .... Test");
	}
	
	@Test
	public void dTest() {
		System.out.println("D .... Test");
	}
	
	@Test(priority = 1)
	public void eTest() {
		System.out.println("E .... Test");
	}

}
