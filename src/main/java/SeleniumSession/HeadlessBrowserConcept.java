package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowserConcept {

	public static void main(String[] args) {
		
		
		//running in headless mode
		//no browser is visible
		//testing is happening in the background
		//fast
		
		
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		co.addArguments("--incognito"); // if you want to run the test in incognito mode
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver(fo);
		
		driver.get("http:\\google.com");
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("google")) {
			System.out.println(title + " : Correct Title");
		}
		else {
			System.out.println(title + " : Incorrect Title");
		}
		
		
		String url = driver.getCurrentUrl();
		if(url.contains("google")) {
			System.out.println(url + " : Correct url");
		}
		driver.close();
		

	}

}
