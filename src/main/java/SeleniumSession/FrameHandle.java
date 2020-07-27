package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(2);  //By INDEX
		//driver.switchTo().frame("main"); //BY NAME
		
		driver.switchTo().frame(driver.findElement(By.name("main")));
		WebElement ele = driver.findElement(By.tagName("h2"));
		System.out.println(ele.getText());

	}

}
