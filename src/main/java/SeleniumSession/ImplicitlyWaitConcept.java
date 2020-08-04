package SeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		By email = By.id("username");
		By password = By.id("password");
		By login = By.xpath("//button[@id='loginBtn']");

		System.out.println(driver.getTitle()); //implicitlyWait not applicable for non webelements like alert title url
		driver.findElement(email).sendKeys("test@gmail.com");
		driver.findElement(password).sendKeys("123456");
		driver.findElement(login).click();
	}

}
