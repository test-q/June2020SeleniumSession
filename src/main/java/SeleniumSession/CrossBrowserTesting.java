package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {

	static WebDriver driver;
	
	//WebDriver Manager is separate maven dependency ->https://github.com/bonigarcia/webdrivermanager

	public static void main(String[] args) {

		String browser = "firefox";
		
//		
//		if (browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "D:\\Rupali\\Driver\\chromedriver.exe");
//			driver = new ChromeDriver();
//
//		} else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "D:\\Rupali\\Driver\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		} else {
//			System.out.println("Please pass the correct Browser name...");
//		}
		
		
		switch(browser) {
		case "chrome": 
			//System.setProperty("webdriver.chrome.driver", "D:\\Rupali\\Driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\Rupali\\Driver\\geckodriver.exe");
     		driver = new FirefoxDriver();
     		break;
     	default:
     		System.out.println("Please pass the correct Browser name...");
     		break;
		}
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
