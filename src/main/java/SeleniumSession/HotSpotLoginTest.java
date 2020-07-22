package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotSpotLoginTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		String browserName = "chrome";
		By userName = By.id("username");
		By password = By.id("password");
		By loginButton  = By.id("loginBtn");
		
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser(browserName);
		br.launchURL("https://app.hubspot.com/login");
		br.getMaximize();
		
		Thread.sleep(5000);
		String title = br.getPageTitle();
		System.out.println("Title of Page is: " +title);
		
		ElementUtils element = new ElementUtils(driver);
		element.doSendKeys(userName, "rupali@gmail.com");
		element.doSendKeys(password, "rup123");
		element.doClick(loginButton);
		br.closeBrowser();	
		
	}

}
