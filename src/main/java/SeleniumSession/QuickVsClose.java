package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuickVsClose {
	
		static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
		driver.quit(); ////NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()? -- for quit
		//driver.close(); //NoSuchSessionException: invalid session id -- for close
		
		//But I want title again after closing/quitting browser
		driver = new ChromeDriver();
		driver.get("http://www.amazon.in");
		System.out.println(driver.getTitle());
		
	
		

	}

}
