package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	public static void main(String[] args) {
		
		//My total Links are
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println("Total links are available on Page: " + linkList.size());
		
		for(int i=0; i<linkList.size(); i++) {
			String name = linkList.get(i).getText();
			
			if(! name.isEmpty()) {
				System.out.println(i+ " ---> " + name);
				System.out.println(linkList.get(i).getAttribute("href"));
				
			}
		}
		
		
		

	}

}
