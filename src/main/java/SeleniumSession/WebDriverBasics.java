package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// Day 19 - 15 July 2020
		/*
		 * Browser Company upgrade there browser and version change continuously hence
		 * selenium facing Compatibility issues so it is decided every browser company
		 * will provide one executable file ie .exe and you have configure this .exe
		 * file in your code in the form of System.setProperty and than launch the
		 * browser and this is the major change selenium 2 to selenium 3
		 */
		System.setProperty("webdriver.chrome.driver", "D:\\Rupali\\Driver\\chromedriver.exe");

//		WebDriver driver = new WebDriver(); //WebDriver is interface and we can not create object of WebDriver
//		Hence we are doing Top casting -> Create object of child class can be referred by Interface reference variable
		WebDriver driver = new ChromeDriver();// ChromeDriver is class which is extending RemoteWebDriver and
												// RemoteWebDriver is implementing WebDriver interface
												// i.e. WebDriver is grand Interface of ChromeDriver class
												// We are creating object that means ChromeDriver constructor will be called.
												// and inside the default constructor selenium guys written code for launch browser
												// Hence this line launch the browser.
												// If you not written System.setProperty line than it will throw the
												// "ExecutionException" error

		driver.get("http://google.com"); // If u r written this way "www.google.com" than it is not working ->Without http it wont work shows "invalid argument"

		String title1 = driver.getTitle(); // Getting title
		System.out.println(title1);

		// Validation point/ check point

		if (title1.equals("Google")) {
			System.out.println("Title is correct.");
		} else {
			System.out.println("Title is not correct.");
		}

		String url = driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());

		if (url.contains("google")) {
			System.out.println("Correct URL");
		} else {
			System.out.println("Incorrect URL");
		}

		// System.out.println(driver.getPageSource());

		driver.quit(); // Close the browser Rupali

	}

}
