package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * this method is used to create WebElement on basis of given BY Locator.
	 * @param locator
	 * @return WebElement
	 */
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	
	/**
	 * this method is used to create List of WebElement on basis of given BY Locator.
	 * @param locator
	 * @return List of WebElement
	 */
	public List<WebElement> getElementList(By locator) {
		List<WebElement> eleList = driver.findElements(locator);
		return eleList;
	}
	
	public void doSendKeys(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	/**
	 * this method is used to find all Links on Web page and click given value
	 * @param locator
	 * @param value
	 */
	public void doLinkClick(By locator, String value) {
		int length = getElementList(locator).size();
		System.out.println("No. of Link available: " + length);
		
		for(WebElement ele : getElementList(locator)) {
			String linkName = ele.getText();
			System.out.println(ele.getText());
			
			if(linkName.equals(value)) {
				ele.click();
				break;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	

}
