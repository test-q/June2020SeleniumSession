package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By country = By.id("Form_submitForm_Country");
		By industry = By.id("Form_submitForm_Industry");
		
//		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
//		WebElement industry = driver.findElement(By.id("Form_submitForm_Industry"));
		
//		Select s = new Select(country);
//		s.selectByVisibleText("India");
//		s.selectByIndex(1);
//		s.selectByValue("American Samoa");
		
		getDropDownByVisibleText(country, "India");
		getDropDownByIndex(country, 16);
		getDropDownByValue(country, "Singapore");
		
		getDropDownByVisibleText(industry, "Government - Local");
		getDropDownByIndex(industry, 16);
		getDropDownByValue(industry, "Retail");

	}
	
	public static void getDropDownByVisibleText(By locator, String value) {
		WebElement ele = driver.findElement(locator);
		Select s = new Select(ele);
		s.selectByVisibleText(value);
		
	}
	
	public static void getDropDownByIndex(By locator, int index) {
		WebElement ele = driver.findElement(locator);
		Select s = new Select(ele);
		s.selectByIndex(index);
		
	}
	
	public static void getDropDownByValue(By locator, String value) {
		WebElement ele = driver.findElement(locator);
		Select s = new Select(ele);
		s.selectByValue(value);
	}

}
