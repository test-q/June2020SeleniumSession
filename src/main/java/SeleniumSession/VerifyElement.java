package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.freshworks.com/");
		WebElement platform = driver.findElement(By.linkText("Platform"));
		
		if(platform.isDisplayed()) {
			String text = platform.getText();
			System.out.println(text);
			platform.click();
		}
		driver.close();

	}

}
