package TestNgSessions;

import org.testng.annotations.Test;

public class DisableTestCases {
	
	@Test()
	public void aTest() {
		System.out.println("A .... Test");
	}
	
	@Test(enabled = false)
	public void bTest() {
		System.out.println("B .... Test");
	}
	
	@Test
	public void cTest() {
		System.out.println("C .... Test");
	}

}
