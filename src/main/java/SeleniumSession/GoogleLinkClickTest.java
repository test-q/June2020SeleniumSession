package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleLinkClickTest {

	public static void main(String[] args) {
		String browserName = "chrome";
		By links = By.xpath("//div[@id='SIvCob']/a");
		By freshFooterLinks = By.xpath("//div[@class='footer-navs l-page clearfix-lg']//div//a");
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser(browserName);
		//br.launchURL("https://www.google.co.in/");
		br.launchURL("https://www.freshworks.com/");
		
		ElementUtils eleUtil = new ElementUtils(driver);
		//eleUtil.doLinkClick(links, "मराठी");

		eleUtil.doLinkClick(freshFooterLinks, "Careers");
		br.closeBrowser();
	}

}
