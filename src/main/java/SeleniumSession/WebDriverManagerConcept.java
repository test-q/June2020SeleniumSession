package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	
	
	public static void main(String[] args) {
		//WebDriver Manager is separate maven dependency ->https://github.com/bonigarcia/webdrivermanager
		
		//This line give u 2 things - 1.Check chromeDrive exe is available on your system or not. 2.If not it will check your browser version first than it will
		//automatically added chrome.exe file for you and place in your laptop m2 folder.
//		WebDriverManager.chromedriver().setup(); 
//		WebDriver driver = new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
		

	}

}
