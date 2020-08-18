package app.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	
	//@Parameters({"browser", "url"})
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {
//		long id = Thread.currentThread().getId();
//		System.out.println("BeforeMethod Id: "+ id);
		switch(browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox": 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Please Enter Correct Browser Name.");	
			break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get(url);
	
	}
	
	@AfterMethod
	public void teardown() {
//		long id = Thread.currentThread().getId();
//		System.out.println("AfterMethod Id: "+ id);
		driver.quit();
	}
}
