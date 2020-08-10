package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetTest {

	public static void main(String[] args) throws InterruptedException {

		String browserName = "chrome";
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser(browserName);
		brUtil.launchURL("https://www.spicejet.com/default.aspx");

		By roundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
		By from = By.xpath("//input[contains(@id, 'originStation1_CTXT')]");
		By to = By.xpath("//input[contains(@name, 'destinationStation1_CTXT')]");
		By depDate =By.xpath("(//a[text()='16'])[1]");
		By returnDate = By.id("ctl00_mainContent_view_date2");
	
		
		ElementUtils eleUtil = new ElementUtils(driver);
		WebElement round = eleUtil.waitForElementToBeClickable(roundTrip, 10);
		round.click();
		eleUtil.getElement(from).click();
		eleUtil.doSendKeys(from, "GOI");
		eleUtil.doSendKeys(to, "BOM");
		//eleUtil.doSendKeys(depDate, "16");
		

	}

}
