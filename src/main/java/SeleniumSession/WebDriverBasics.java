package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		// WebDriver is interface hence we can not create object of WebDriver
		// Hence we are doing Top casting -> Create object of child class can be
		// referred by Interface reference variable
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");

	}

}
