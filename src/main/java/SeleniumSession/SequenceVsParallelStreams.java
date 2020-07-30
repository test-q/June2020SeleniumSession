package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SequenceVsParallelStreams {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());
		
		long startTime = System.currentTimeMillis();
		//linkList.stream().forEach(ele -> System.out.println(ele.getText()));
		linkList.stream().parallel().forEach(ele -> System.out.println(ele.getText()));
		long endTime = System.currentTimeMillis();
		System.out.println("-------------------------------");
		//System.out.println("Sequence Stream Total Time taken in milisec: " + (endTime-startTime)); //11732
		System.out.println("Parallel Stream Total Time taken in milisec: " +(endTime-startTime)); //10556
		

	}

}
