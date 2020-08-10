package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HubSpotXpathConcept {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
		By email    = By.xpath("//input[@id='username']");
		By password = By.xpath("//input[@id='password']");
		By login    = By.id("loginBtn");
		//By contactName = By.xpath("//span[text()='Vibha Igale']//ancestor::td//preceding-sibling::td//input[@type='checkbox']/..");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement emailId = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		emailId.sendKeys("sr.test85@gmail.com");
		driver.findElement(password).sendKeys("Bugzilla16");
		driver.findElement(login).click();
		
		wait.until(ExpectedConditions.titleIs("Account Setup | HubSpot"));
		driver.navigate().to("https://app.hubspot.com/contacts/8229364/contacts/list/view/my/");
		//span[text()='Vibha Igale']//ancestor::td//preceding-sibling::td//span[@class='private-checkbox__inner']
		//span[text()='Vibha Igale']//ancestor::td//preceding-sibling::td//input[@type='checkbox']/..
		//span[text()='Vibha Igale']//ancestor::td//following-sibling::td/a
		
		getContactName("Vibha Igale").click();
		System.out.println(getEmail("Vibha Igale"));
		getContactName("Tom Steam").click();
		System.out.println(getEmail("Tom Steam"));
		getContactName("Tina Mukne").click();
		System.out.println(getEmail("Tina Mukne"));

	}
	
	public static WebElement getContactName(String name) {
		By contactName = By.xpath("//span[text()='"+name+"']//ancestor::td//preceding-sibling::td//input[@type='checkbox']/..");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(contactName));
		
	}
	
	public static String getEmail(String name) {
		By email = By.xpath("//span[text()='"+name+"']//ancestor::td//following-sibling::td/a");
		return driver.findElement(email).getText();
	}

}
