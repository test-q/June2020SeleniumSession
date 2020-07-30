package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementActions {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/");
		Thread.sleep(5000);
		
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		
		Actions act = new Actions(driver);
		act.sendKeys(username, "batchautomation").perform();
		act.sendKeys(password, "Test@12345").perform();
		act.click(login).perform();
		driver.close();

	}
	public static WebElement getElement(By locator){
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator, String value){
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public static void doActionsClick(By locator){
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

}
