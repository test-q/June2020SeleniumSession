package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/");
		Thread.sleep(3000);
		
		WebElement content = driver.findElement(By.className("menulink"));
		
		doMovetoElement(content);
//		Actions act = new Actions(driver);
//		act.moveToElement(content).perform();
		WebElement courses = driver.findElement(By.linkText("COURSES"));
		//act.moveToElement(courses).perform();
		doMovetoElement(courses);	

	}
	
	public static void doMovetoElement(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
	}

}
