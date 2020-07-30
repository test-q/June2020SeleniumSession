package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));

		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();
	   // first move to the target element and than right click on it
		List<WebElement> list = driver.findElements(By.xpath(
				"//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-item context-menu-icon')]"));
		System.out.println(list.size());

		list.stream().parallel().forEach(ele -> System.out.println(ele.getText()));
		for (WebElement ele : list) {
			String text = ele.getText();

			if (text.equals("Copy")) {
				ele.click();
				break;
			}
		}
	}
	
	

}
