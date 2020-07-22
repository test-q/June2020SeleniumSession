package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Import all packages in one shot => control+shift+o

public class BrowserUtil {
	

	/**
	 * this is browser util, having different browser related generic functions Please reuse it.
	 * @author rupal
	 */
	
	
	public WebDriver driver;
	
	/**
	 * This method is used to launch the browser on the basis of given browser
	 * @param browserName
	 * @return driver
	 */
	public WebDriver launchBrowser(String browserName) {
		switch(browserName) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
			
		default:
			System.out.println("please pass the correct browser name.....");
			break;
			
		}
		
		return driver;
	}
	
	
	
	/**
	 * This method launch the URL
	 * @param url
	 */
	public void launchURL(String url) {
		
		driver.get(url);
	}
	
	
	
	/**
	 * this is used to get page title
	 * @return page title
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	
	/**
	 * this is used to get page URL
	 * @return page url
	 */
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	
	/**
	 * this is used to check back page in browser history
	 */
	public void backBrowser() {
		driver.navigate().back();
	}
	
	
	/**
	 * this is used to check forward page in browser history
	 */
	public void forwardBrowser() {
		driver.navigate().forward();
	}
	
	
	/**
	 * this is used to close the bowser
	 */
	public void closeBrowser() {
		driver.close();
	}
	
	/**
	 * this is used to quit the browser
	 */
	public void quitBrowser() {
		driver.quit();
	}
	
	public void getMaximize() {
		driver.manage().window().maximize();
	}

}
