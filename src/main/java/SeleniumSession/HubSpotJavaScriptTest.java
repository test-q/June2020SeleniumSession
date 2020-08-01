package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HubSpotJavaScriptTest {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(4000);
		//Get Title of the page
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
		System.out.println(title);
		
		Thread.sleep(2000);
		js.executeScript("history.go(0);");
		
		String browserInfo = js.executeScript("return navigator.userAgent;").toString();
		System.out.println(browserInfo);
		
		String innerText = js.executeScript("return document.documentElement.innerText;").toString();
		System.out.println(innerText);
		
		WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement forgotPassword = driver.findElement(By.linkText("Forgot my password"));
		flash(email);
		flash(password);
		//js.executeScript("alert('Hi Sharvi');");
		Thread.sleep(4000);
		//js.executeScript("arguments[0].click();", forgotPassword);
		
		
		//generateAlert("My JavaScript...");
		
		
		js.executeScript("document.getElementById('username').value='rupali@gmail.com';");
		js.executeScript("document.getElementById('password').value='SoftwareTestingMaterial.com';");
		
		Thread.sleep(4000);
	
		

	}
	
	public static String getTitleByJS() {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void refreshBrowserByJS() {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0);");
	}
	
	public static void getInnerTextByJS() {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("return document.documentElement.innerText;").toString();
	}
	
	public static void flash(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 20; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	private static void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	
	public static void generateAlert(String message) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+ message +"')");
	}
	

}
