package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sslCertificate {

	public static void main(String[] args) {
		
		//This is for Chrome browser
		ChromeOptions co = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co.setAcceptInsecureCerts(true));
		driver.get("https://expired.badssl.com/");
		
		//This is for Firefox browser
		FirefoxOptions fo = new FirefoxOptions();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver1 = new FirefoxDriver(fo.setAcceptInsecureCerts(true));
		driver1.get("https://expired.badssl.com/");
	}

}
