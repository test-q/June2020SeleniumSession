package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(3000);
		By option = By.xpath("//span[@class='comboTreeItemTitle']");
		
		//Single Selection
		//selectChoiceValue(option, "choice 6 2");
		
		//Multiple selection
		selectChoiceValue(option, "choice 1", "choice 2 3", "choice 4", "choice 7", "choice 6 2 2");
		
		//All selection
		//selectChoiceValue(option, "all");
		
		driver.close();
		
//		List<WebElement> optionList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
//		
//		for(int i=0; i<optionList.size(); i++) {
//			String text = optionList.get(i).getText();
//			System.out.println(text);
//			if(text.equals("choice 5")) {
//				optionList.get(i).click();
//			}	
//		}
		
		

	}
	
	public static void selectChoiceValue(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		try {
			if(value[0].equalsIgnoreCase("all")) {
				for(int all=0;  all<choiceList.size();  all++) {
					String text = choiceList.get(all).getText();
					choiceList.get(all).click();
					System.out.println(text + " : is Clicked");
				}
			}
			
			else {
				for(int i=0;  i<choiceList.size();  i++) {
					
					String text = choiceList.get(i).getText();
					//System.out.println(text);
					
					for(int j=0; j<value.length; j++) {		
						if(text.equals(value[j])) {
							choiceList.get(i).click();
							System.out.println(text + " : is Clicked");
							break;
						}
					}		
				}	
			}
			
		}catch(Exception e) {	
			
			System.out.println(e);
	    }
   }
}
