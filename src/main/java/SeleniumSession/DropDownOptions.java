package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownOptions {
	
	public static WebDriver driver;

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		By searchDropBox = By.id("searchDropdownBox");
		
		System.out.println(getDropdownOptionsCount(searchDropBox));
		
		//getDropdownOptionsValue(searchDropBox);
		System.out.println(getDropdownOptionsValue(searchDropBox, "Luggage & Bags"));
		
		//select[@id='searchDropdownBox']/option
		
//		WebElement searchDropdown = driver.findElement(By.id("searchDropdownBox"));
//		Select s = new Select(searchDropdown);
//		List<WebElement> dropdownOptions = s.getOptions();
//		System.out.println("Size of Dropdown Box: " + dropdownOptions.size());
		
//		for(WebElement ele : dropdownOptions) {
//			System.out.println(ele.getText());
//		}
		
//		dropdownOptions.stream().forEach(ele -> System.out.println(ele.getText()));
		
		
	}
	
	public static int getDropdownOptionsCount(By locator) {
		WebElement dropdownBox = driver.findElement(locator);
		
		Select s = new Select(dropdownBox);
		List<WebElement> optionList = s.getOptions();
		return optionList.size();
		
	}
	
	public static void getDropdownOptionsValue(By locator) {
		WebElement dropdownBox = driver.findElement(locator);
		Select s = new Select(dropdownBox);
		List<WebElement> optionList = s.getOptions();
		
		optionList.stream().forEach(ele -> System.out.println(ele.getText()));
	}
	
	public static List<String> getDropdownOptionsValue(By locator, String value) {
		List<String> textList = new ArrayList<String>();
		WebElement dropdownBox = driver.findElement(locator);
		Select s = new Select(dropdownBox);
		List<WebElement> optionList = s.getOptions(); 
		
		for(WebElement ele: optionList) {
			String text = ele.getText();
			System.out.println(text);
			textList.add(text);	
		}
		return 	textList;
	}

}
