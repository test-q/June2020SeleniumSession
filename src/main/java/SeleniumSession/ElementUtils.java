package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
			System.out.println(linkName);
			
			if(linkName.equals(value)) {
				ele.click();
				break;
			}
		}
		
	}
	
	/**
	 * this method is used to find all image on Web page and click given image
	 * @param locator
	 */
	public void getAllImages(By locator) {
		int length = getElementList(locator).size();
		System.out.println("No. of Images available: " + length);
		
		for(WebElement img : getElementList(locator)) {
			System.out.println(img.getAttribute("alt"));
		}
	}
	
	//***************************** DROP DOWN UTILITY ******************************
	/**
	 * this method is used to select drop down box value by visible text
	 * @param locator
	 * @param value
	 */
	public void getDropDownByVisibleText(By locator, String value) {
		WebElement ele = driver.findElement(locator);
		Select s = new Select(ele);
		s.selectByVisibleText(value);
		
	}
	
	/**
	 * this method is used to select drop down box value by index based
	 * @param locator
	 * @param index
	 */
	public void getDropDownByIndex(By locator, int index) {
//		WebElement ele = driver.findElement(locator);
//		Select s = new Select(ele);
//		s.selectByIndex(index);
		
		WebElement ele1 = getElement(locator);  // using getElement()
		Select s = new Select(ele1);
		s.selectByIndex(index);	
	}
	
	/**
	 * this method is used to select drop down box value by value text
	 * @param locator
	 * @param value
	 */
	public void getDropDownByValue(By locator, String value) {
		WebElement ele = driver.findElement(locator);
		Select s = new Select(ele);
		s.selectByValue(value);
	}
	
	
	/**
	 * this method is used to find out size of drop down box.
	 * @param locator
	 * @return int
	 */
	public int getDropdownOptionsCount(By locator) {
		WebElement dropdownBox = driver.findElement(locator);
		
		Select s = new Select(dropdownBox);
		List<WebElement> optionList = s.getOptions();
		return optionList.size();
		
	}
	
	/**
	 * this method is used to display all options in drop down box
	 * @param locator
	 */
	public void getDropdownOptionsValue(By locator) {
		WebElement dropdownBox = driver.findElement(locator);
		Select s = new Select(dropdownBox);
		List<WebElement> optionList = s.getOptions();
		
		optionList.stream().forEach(ele -> System.out.println(ele.getText()));
	}
	 
/**
 * this method is used to return drop down options text.
 * @param locator
 * @param value
 * @return Drop down values List of text
 */
	public List<String> getDropdownOptionsText(By locator) {
		List<String> textList = new ArrayList<String>();
		
		WebElement dropdownBox = driver.findElement(locator);
		Select s = new Select(dropdownBox);
		List<WebElement> optionList = s.getOptions(); 
		
		for(WebElement ele: optionList) {
			String text = ele.getText();
			System.out.println(text);
			textList.add(text);	
		}
		return 	textList;
	}
	
	public void getValueFromDropDownWithoutSelectClass(By locator, String value) {
		
		List<WebElement> optionList = driver.findElements(locator);
		
		System.out.println("Size Of Dropdown Box: " + optionList.size());
		
		for(WebElement ele : optionList) {
			String text = ele.getText();
			System.out.println(text);
			if(text.equals(value)) {
				ele.click();
				System.out.println(text + " : Click Successfully");
				break;
			}
		}
		
	}
	
	/**
	 * this method is used to click value from suggestion list open and return suggestion list
	 * @param locator
	 * @param text
	 * @return 
	 */
	public ArrayList<String> doSuggestionListClick(By locator, String text) {
		boolean flag = true;
		ArrayList<String> suggestionText = new ArrayList<String>();
		List<WebElement> suggestionEleList = driver.findElements(locator); 
		System.out.println(suggestionEleList.size());
		
		for(WebElement ele : suggestionEleList) {
			String value = ele.getText();
			System.out.println(value);
			suggestionText.add(value);
			
			if(value.equals(text)) {
				ele.click();
				System.out.println(text+" : Is Found In Suggestion List.");
				flag = false;
				break;
			}
		}
		if(flag == true) {
			System.out.println(text + " : Is not found in suggestion list.");
		}
		return suggestionText;
	}
	
	
	/**
	 * this method is used to click on "single choice/Multiple choice/ all choice" in choice drop down/jquery drop down box.
	 * @param locator
	 * @param value
	 */ 	
	public void selectChoiceValue(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		
		try {
			if(value[0].equalsIgnoreCase("all")) {
				for(int all=0; all<choiceList.size(); all++) {
					String text = choiceList.get(all).getText();
					choiceList.get(all).click();
					System.out.println(text + " : is Clicked");
				}
			}
			
			else {
				for(int i=0;  i<choiceList.size();  i++) {
					
					String text = choiceList.get(i).getText();
					System.out.println(text);
					
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
			
			
	    }
   }
	
	
	
	
	

}
