package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelectClass {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		List<WebElement> searchBox = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));
		System.out.println("Size of Drop down Box: " + searchBox.size());
		
		System.out.println("************ Iteam in Drop Down Box********************");
		searchBox.stream().forEach(ele -> System.out.println(ele.getText()));
		
		System.out.println("************ Click on particular iteam in Drop Down Box********************");
		for(WebElement ele : searchBox) {
			String text = ele.getText();
			if(text.equals("Garden & Outdoors")) {
				ele.click();
				System.out.println("Iteam clicked successfully: " + text);
				break;
			}
		}
	}
	
	public static void selectValueFromDropDownWithoutSelect(By locator, String value) {
		
		List<WebElement> optionList = driver.findElements(locator);
		
		System.out.println("Size Of Dropdown Box: " + optionList.size());
		
		for(WebElement ele : optionList) {
			String text = ele.getText();
			System.out.println(text);
			if(text.equals(value)) {
				ele.click();
				System.out.println(text + " : Click Successfully");
				break;
			}
		}
		
	}

}
