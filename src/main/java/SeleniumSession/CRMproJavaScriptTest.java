package SeleniumSession;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRMproJavaScriptTest {

	
	public static void main(String[] args) throws InterruptedException {
		String browserName = "chrome";
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser(browserName);
		br.launchURL("https://classic.crmpro.com/");
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		String title = jsUtil.getTitleByJS();
		System.out.println("Title of The Page: " +title);
		
		Thread.sleep(5000);
		jsUtil.refreshBrowserByJS();
		String browserInfo = jsUtil.getBrowserInfo();
		System.out.println("Browser Information: " + browserInfo);
		String innerText = jsUtil.getPageInnerText();
		System.out.println("Page Inner Text: " + innerText);
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		WebElement task = driver.findElement(By.linkText("Forgot Password?"));
		
		jsUtil.flash(username);
		jsUtil.flash(password);
		jsUtil.drawBorder(login);
		
		Thread.sleep(4000);
		
		jsUtil.sendKeysUsingJSWithWebElement("batchautomation", username);
		jsUtil.sendKeysUsingJSWithWebElement("Test@123", password);
		jsUtil.clickElementByJS(login);
		Thread.sleep(4000);
		
		jsUtil.generateAlert("Sharvi, Rupali and Mayur");
		Thread.sleep(4000);
		jsUtil.scrollPageDown();
		Thread.sleep(4000);
		jsUtil.scrollPageUp();
		Thread.sleep(4000);
		jsUtil.scrollIntoView(task);
		Thread.sleep(4000);
		
//		jsUtil.checkPageIsReady();
		

		
		

	}

}
