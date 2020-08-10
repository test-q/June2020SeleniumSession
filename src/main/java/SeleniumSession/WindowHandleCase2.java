package SeleniumSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleCase2 {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		By popup1 = By.xpath("//a[text()='Good PopUp #1']");
		By popup2 = By.xpath("//a[text()='Good PopUp #2']");
		By popup3 = By.xpath("//a[text()='Good PopUp #3']");
		By popup4 = By.xpath("//a[text()='Good PopUp #4']");
		
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(popup1).click();
		Set<String> windowSet = driver.getWindowHandles();
		getBrowserWindowHandleWithList(windowSet, parentWindowId);
		System.out.println("");
		
		driver.switchTo().window(parentWindowId);
		driver.findElement(popup2).click();
		windowSet = driver.getWindowHandles();
		getBrowserWindowHandleWithList(windowSet, parentWindowId);
		System.out.println("");
		
		driver.switchTo().window(parentWindowId);
		driver.findElement(popup3).click();
		windowSet = driver.getWindowHandles();
		getBrowserWindowHandleWithList(windowSet, parentWindowId);
		System.out.println("");
		
		driver.switchTo().window(parentWindowId);
		driver.findElement(popup4).click();
		windowSet = driver.getWindowHandles();
		getBrowserWindowHandleWithList(windowSet, parentWindowId);
		System.out.println("");
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Title Of Parent Window: " + driver.getTitle());
		driver.quit();

	}
	
	public static void getBrowserWindowHandleWithList(Set<String> windowSet, String parentWindowId) {
		List<String> windowList= new ArrayList<String>(windowSet);
		int count = windowList.size();
		System.out.println("No of Windows Opened: " + count);
		
		for(int i=0; i<count; i++) {
			String curChildWindowId = windowList.get(i);
			if(! parentWindowId.equals(curChildWindowId)) {
				driver.switchTo().window(curChildWindowId);
				System.out.println("Title Of Child Window " + i + " : " + driver.getTitle());
				driver.close();
			}
		}
	}

}
