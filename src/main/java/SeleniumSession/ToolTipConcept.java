package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTipConcept {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/tooltip/");
		//driver.switchTo().frame(0); //Find frame by index
		driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); //Find frame by webelement
		driver.findElement(By.id("age")).sendKeys("30");
		
		//Try to capture tootip text
		//1. Open site 2. go to Source 3. Mouse over the webelement 4. press F8 5.Go to element and inspect tooltip and find xpath
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("age"))).perform();
		
		String tooTipText = driver.findElement(By.className("ui-tooltip-content")).getText();
		System.out.println("Tool Tip Text: " +tooTipText);

	}

}
