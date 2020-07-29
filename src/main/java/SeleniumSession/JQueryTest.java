package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JQueryTest {

	public static void main(String[] args) throws InterruptedException {
		String browserName = "chrome";
		By multiSelection = By.id("justAnInputBox");
		By options = By.xpath("//span[@class='comboTreeItemTitle']");
		
		BrowserUtil broUtil = new BrowserUtil();
		WebDriver driver = broUtil.launchBrowser(browserName);
		broUtil.launchURL("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		ElementUtils eleUtil = new ElementUtils(driver);
		eleUtil.getElement(multiSelection).click();
		Thread.sleep(2000);
		
		//eleUtil.selectChoiceValue(options, "choice 2 2"); // Single Click
		//eleUtil.selectChoiceValue(options, "choice 5", "choice 6 2 2", "choice 3"); //Multiple click
		//eleUtil.selectChoiceValue(options, "choice 1", "choice 7");// Boundary Click
		eleUtil.selectChoiceValue(options, "alL"); // All Click

	}

}
