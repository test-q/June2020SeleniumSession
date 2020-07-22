package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(5000);
		
		//Way 1
//		driver.findElement(By.id("username")).sendKeys("rupali@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("rup123");
//		driver.findElement(By.id("loginBtn")).click();
		
		//Way2
		
//		WebElement username = driver.findElement(By.id("username"));
//		WebElement password = driver.findElement(By.id("password"));
//		WebElement loginButton =  driver.findElement(By.id("loginBtn"));
//		
//		username.sendKeys("rupali@gmail.com");
//		password.sendKeys("rup123");
//		loginButton.click();
		
		//Way3 By Locator
		
		By userName1 = By.id("username");
		By password1= By.id("password");
		By loginButton1 = By.id("loginBtn");
		
//		driver.findElement(userName1).sendKeys("ruppali@gmail.com");
//		driver.findElement(password1).sendKeys("rup123");
//		driver.findElement(loginButton1).click();
		
		//Way 4 
//		getElement(userName1).sendKeys("rupali@gmail.com");
//		getElement(password1).sendKeys("rup123");
//		getElement(loginButton1).click();
		
		//Way 5
		doSendKeys(userName1, "rupali@gmail.com");
		doSendKeys(password1, "rup123");
		doClick(loginButton1);
		
		//2. name:
		//driver.findElement(By.name("username")).sendKeys("test@gmail.com");
		
		//3. className:
		//form-control private-form__control login-email
		//form-control private-form__control login-password m-bottom-3
//		driver.findElement(By.className("login-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.className("login-password")).sendKeys("test@gmail.com");
		
		//4. xpath: address of element in HTML DOM - is a locator but not an attribute
//		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("test@123");
		
		//5. cssSelector: address of element in HTML DOM - is a locator but not an attribute
//		driver.findElement(By.cssSelector("#username")).sendKeys("test@gmail.com");
//		driver.findElement(By.cssSelector("#password")).sendKeys("test123");
		
		
		//6. link text: only for links: with <a> htmltag
		//driver.findElement(By.linkText("Sign up")).click();
		
		//7. partialLinkText: only for links but not recommended
		//sign up
		//sign in
		//driver.findElement(By.partialLinkText("Sign")).click();
		
		//8. tagName: html tag
//		String header = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(header);
	}
	
	public static WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	public static void doSendKeys(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		driver.findElement(locator).click();
	}

}
