package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
		public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
		By email = By.id("username");
		By password = By.id("password");
		By loginBtn = By.xpath("//button[@id='loginBtn']");
		By signUpLink = By.linkText("Sign up");
		By firstName = By.id("uid-firstName-5");
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(email));
//		driver.findElement(email).sendKeys("test@gmail.com");
//		driver.findElement(password).sendKeys("123456");
//		driver.findElement(loginBtn).click();
		
		WebElement username = waitForElementPresent(email,10);
		username.sendKeys("rupali@gmail.com");
		driver.findElement(password).sendKeys("123456");
		driver.findElement(loginBtn).click();
		driver.findElement(signUpLink).click();
		//waitForElementPresent(firstName,10).sendKeys("Rupali");
		waitForElementToBeVisible(firstName,10).sendKeys("Rupali");
		//System.out.println(driver.getTitle());
		String title = waitForTitlePresent("Get started with HubSpot CRM", 10);
		System.out.println(title);
		
		if(waitForUrl("signup", 10)) {
			System.out.println("sign up url is correct");
		}

	}
	
	public static WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public static WebElement waitForElementToBeVisible(By locator, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static String waitForTitlePresent(String titleValue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}
	
	public static Boolean waitForUrl(String url, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.urlContains(url));
	}

}
