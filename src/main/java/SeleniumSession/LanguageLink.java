package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLink {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		List<WebElement> linkList = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		int noLang = linkList.size();
		System.out.println("No of Language Link available : " +noLang );
		
//		for(int i=0; i<noLang; i++) {
//			System.out.println(lang.get(i).getText());
//		}
		
		
//		for(WebElement ele : linkList) {
//			String myLang = ele.getText();
//			System.out.println(myLang);
//			
//			if(myLang.equals("मराठी")) {
//				ele.click();
//				break;
//			}
//		}
		
//		lang.stream().forEach(ele -> System.out.println(ele.getText()));
		
		getLanguageLink(linkList, "मराठी");
		
		//driver.close();
	}
	
	public static void getLanguageLink(List<WebElement> linkList, String value) {
		int noLang = linkList.size();
		System.out.println("No of Language Link available : " +noLang );
		for(int i=0; i<noLang; i++) {
			String myLang = linkList.get(i).getText();
			System.out.println(myLang);
			if(myLang.equals(value)) {
				linkList.get(i).click();
				break;
			}
		}
		
	}

}
