package SeleniumSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleCase1 {
	public static WebDriver driver;
	
	public static void main(String[] args) {		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		By popup1 = By.xpath("//a[text()='Good PopUp #1']");
		By popup2 = By.xpath("//a[text()='Good PopUp #2']");
		By popup3 = By.xpath("//a[text()='Good PopUp #3']");
		By popup4 = By.xpath("//a[text()='Good PopUp #4']");
		
		driver.findElement(popup1).click();
		driver.findElement(popup2).click();
		driver.findElement(popup3).click();
		driver.findElement(popup4).click();
		
		String parentWindowId = driver.getWindowHandle();
		Set<String> windowSet = driver.getWindowHandles();
		
		getSwitchToChildWindow(windowSet, parentWindowId);
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		driver.quit();		
	}
		
	public static void getSwitchToChildWindow(Set<String> windowSet, String parentWindowId) {
		int count = windowSet.size();
		System.out.println("No. Of windows Opened: " + count);
		Iterator<String> it = windowSet.iterator();
		while(it.hasNext()) {
			String curChildWindowId = it.next();
			if(! parentWindowId.equals(curChildWindowId)) {
				driver.switchTo().window(curChildWindowId);
				System.out.println("Title Of child Window: " + driver.getTitle());
				driver.close();
			}
		}
	}
	
	
	
}
