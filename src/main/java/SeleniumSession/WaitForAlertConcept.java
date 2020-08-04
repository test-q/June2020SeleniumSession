package SeleniumSession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcept {
	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert1.getText());
		alert1.accept();
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert alert2 = waitForAlertToBePresent(10);
		System.out.println(alert2.getText());
		alert2.dismiss();
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alert3 = waitForAlertToBePresent(10);
		System.out.println(alert3.getText());
		alert3.sendKeys("Rupali");
		alert3.accept();

	}
	
	public static Alert waitForAlertToBePresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

}
