package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementsList {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com");
		
		By footerLinks = By.xpath("//ul[@class='footer-nav']/li/a");
		
		List<WebElement> footerList = visibilityofAllElements(footerLinks, 10);
		footerList.stream().forEach(ele -> System.out.println(ele.getText()));

	}
	
	public static List<WebElement> visibilityofAllElements(By locator, int timeout) {
		WebDriverWait  wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));	
	}
	
	public static void getPageLinksText(By locator, int timeOut){
		visibilityofAllElements(locator, timeOut).stream().forEach(ele -> System.out.println(ele.getText()));
	}

}
