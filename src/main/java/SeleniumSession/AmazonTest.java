package SeleniumSession;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonTest {

	public static void main(String[] args) throws InterruptedException {
	
		String browserName = "chrome";
		By images = By.tagName("img");
		By searchDropBox = By.xpath("//select[@id='searchDropdownBox']/option");
		By searchBox = By.id("twotabsearchtextbox");
		By serachLaptop = By.xpath("//div[@id='suggestions']/div");
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser(browserName);
		br.launchURL("https://www.amazon.in/");
		
		ElementUtils eleUtil = new ElementUtils(driver);
		eleUtil.getAllImages(images);
		System.out.println("--------------------------------");
		
		eleUtil.getValueFromDropDownWithoutSelectClass(searchDropBox, "Baby");
		
		//Serach "Laptop" in serach box and click on "laptop speaker"
		System.out.println("--------------------------------");
		br.launchURL("https://www.amazon.in/");
		eleUtil.doSendKeys(searchBox, "laptop");
		Thread.sleep(3000);
		ArrayList<String> list = eleUtil.doSuggestionListClick(serachLaptop, "Pramod");
		System.out.println("--------------------------------");
		System.out.println(list);
		
		//br.closeBrowser();

	}

}
