package TestNgSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionsConcept {

	@Test(expectedExceptions = Throwable.class)
	public void myTest1(){
		
		System.out.println("my test,,,...");
		int i = 9/0;
		
	}
	
	@Test(expectedExceptions = Exception.class)
	public void myTest2(){
		
		System.out.println("my test,,,...");
		int i = 9/0;
		
	}
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void myTest3(){
		
		System.out.println("my test,,,...");
		int i = 9/0;
		
	}
}
