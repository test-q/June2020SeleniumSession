package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonTest {

	public static void main(String[] args) {
	
		String browserName = "chrome";
		By images = By.tagName("img");
		By searchDropBox = By.xpath("//select[@id='searchDropdownBox']/option");
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser(browserName);
		br.launchURL("https://www.amazon.in/");
		
		ElementUtils eleUtil = new ElementUtils(driver);
		eleUtil.getAllImages(images);
		
		eleUtil.getValueFromDropDownWithoutSelectClass(searchDropBox, "Baby");
		
		br.closeBrowser();

	}

}
