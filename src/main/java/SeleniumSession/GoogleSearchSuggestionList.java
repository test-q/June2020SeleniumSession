package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSuggestionList {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("testing");
		Thread.sleep(3000);
		By suggestion = By.xpath("//ul[@class='erkvQe']/li//div[@class='sbl1']/span");
		SuggestionListClick(suggestion, "testing types");
		
		//Use Parent-child relation xpath
//		List<WebElement> suggestionList = driver.findElements(By.xpath("//ul[@class='erkvQe']/li//div[@class='sbl1']/span")); 
//		System.out.println(suggestionList.size());
//		
//		for(WebElement ele : suggestionList) {
//			String text = ele.getText();
//			System.out.println(ele.getText());
//			if(text.equals("testing in maharashtra")) {
//				ele.click();
//				break;
//			}
//		}
	}
	
	public static void SuggestionListClick(By locator, String text) {
		
		List<WebElement> suggestionList = driver.findElements(locator); 
		System.out.println(suggestionList.size());
		
		for(WebElement ele : suggestionList) {
			String suggestiontext = ele.getText();
			System.out.println(ele.getText());
			if(suggestiontext.equals(text)) {
				ele.click();
				break;
			}
		}
	}

}
